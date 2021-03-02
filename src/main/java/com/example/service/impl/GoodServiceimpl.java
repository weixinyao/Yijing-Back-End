package com.example.service.impl;

import com.example.dao.ClassifyMapper;
import com.example.dao.GoodMapper;
import com.example.dao.PublishMapper;
import com.example.model.*;
import com.example.service.GoodService;
import com.example.utils.RandomUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/26-10:27
 */
@Repository
public class GoodServiceimpl implements GoodService {
    static int number=0;
    @Value("${absoluteImgPath}")
    String absoluteImgPath;
    @Value("${sonImgPath}")
    String sonImgPath;
    @Resource
    private GoodMapper goodMapper;
    @Resource
    private PublishMapper publishMapper;
    @Resource
    private ClassifyMapper classifyMapper;
    @Override
    public PageInfo<Good> selectallgoods(int pagenum, int pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Good> goodList = goodMapper.selectAllGood();
        PageInfo<Good> goodPageInfo = new PageInfo<>(goodList);
        return goodPageInfo;
    }

    @Override
    public List<ClassifyGood> findclassifygoods() {
        List<ClassifyGood> classifyGood = goodMapper.findClassifyGoods();
        return classifyGood;
    }

    @Override
    public List<Good> findqueryGoods(String name) {
        List<Good> goodList1 = goodMapper.queryByGoodname(name);
        System.out.println(goodList1.toString());
        List<Good> goodList2 = goodMapper.queryByClassifyname(name);
        System.out.println("----------");
        System.out.println(goodList2.toString());
        List<Good> goodList12 = new ArrayList<>();
        goodList12.addAll(goodList1);
        goodList12.addAll(goodList2);
        List<Good> goodLists = new ArrayList<>();
        Boolean isexist = false;
        for(Good goodo: goodList12) {
            if (goodLists != null) {
                for (Good goodn : goodLists) {
                    if (goodn.getGoodid() == goodo.getGoodid()) {
                        isexist = true;
                    }

                }
                if (isexist == false) {
                    goodLists.add(goodo);
                }
            } else {
                goodLists.add(goodo);
            }
        }
        return goodLists;
    }

    @Override
    public Good queryGoodById(int id) {
        return goodMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> applygood(MultipartFile[] file, Good good) {
        Map<String,Object> map = new HashMap<>();
        String path="";
        String firstimgurl = "";
        for (int i = 0; i < file.length; i++) {
            if (file[i].isEmpty()) {
                map.put("code", "500");
                map.put("msg", "图片不能为空");
                System.out.println("图片不能为空");
                return map;
            }

            String originalFilename = file[i].getOriginalFilename();
            //随机生成文件名
            String fileName = RandomUtils.random() + originalFilename;
            File dest = new File(absoluteImgPath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            String feedPicture = sonImgPath + fileName;
            try {
                if(i == 0) {
                  file[i].transferTo(dest);
                  path+=feedPicture+",";
                  firstimgurl = feedPicture;
                }else {
                    file[i].transferTo(dest);
                    path += feedPicture + ",";
                }
            } catch (Exception e) {
                map.put("ERROR", e.getMessage());
                return  map;
            }
        }

        try {
              good.setImgurl(path);
              good.setFirstimgurl(firstimgurl);
              int userid = good.getPublisherid();
            Publish publish = new Publish();
              int flag1 = goodMapper.insert(good);
              int goodid = good.getGoodid();
            publish.setUserid(userid);
            publish.setGoodid(goodid);
            int flag2 =publishMapper.insert(publish);
              if(flag1 ==1 && flag2 == 1) {
                  map.put("OK", "200");
              }else {
                  map.put("error","发布失败请重试");
              }

            return map;
        }
        catch (Exception e){
            map.put("ERROR",  e.getMessage());
            return map;
        }


    }

    @Override
    public Map<String, Object> findallshenhegood() {
        Map<String,Object> map = new HashMap<>();
        List<Good> goodList = goodMapper.findallshenhegood();
        map.put("shenhegood",goodList);
        return map;
    }

    @Override
    public Map<String, Object> selectshenhegoodbyid(int goodid) {
        Map<String,Object> map = new HashMap<>();
        SingleClassifyGood singleClassifyGood = new SingleClassifyGood();
        Good good = goodMapper.selectByKey(goodid);
        int classifyid = good.getClassifyid();
        Classify classify = classifyMapper.selectByPrimaryKey(classifyid);
        singleClassifyGood.setClassify(classify);
        singleClassifyGood.setGood(good);
        map.put("classifygood",singleClassifyGood);
        return map;
    }

    @Override
    public Map<String, Object> permitgood(int goodid) {
        Map<String,Object> map = new HashMap<>();
        int flag = goodMapper.permitgood(goodid);
        if(flag == 1){
            map.put("success","审核通过");
        }else {
            map.put("error","审核失败请重试");
        }
        return map;
    }
}
