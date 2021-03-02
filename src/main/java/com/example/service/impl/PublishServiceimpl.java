package com.example.service.impl;

import com.example.dao.ClassifyMapper;
import com.example.dao.GoodMapper;
import com.example.dao.PublishMapper;
import com.example.model.*;
import com.example.service.PublishService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/1-15:24
 */
@Repository
public class PublishServiceimpl implements PublishService {
    @Resource
    private ClassifyMapper classifyMapper;
    @Resource
    private PublishMapper publishMapper;
    @Resource
    private GoodMapper goodMapper;
    @Override
    public Map<String, Object> getmypublish(int userid) {//我的发布
        Map<String,Object> map = new HashMap<>();
        List<Publish> publishList = publishMapper.getpublishbyuserid(userid);
        List<PublishGood> publishGoodList = new ArrayList<>();
        for(Publish publish: publishList){
            int goodid = publish.getGoodid();
            Good good =goodMapper.selectByKey(goodid);
            PublishGood publishGood = new PublishGood();
            publishGood.setGood(good);
            publishGood.setPublish(publish);
            publishGoodList.add(publishGood);
        }
        map.put("mypublish",publishGoodList);
        return map;
    }

    @Override
    public Map<String, Object> querydowngood(int goodid) {//查询即将下架物品的信息
        Map<String,Object> map = new HashMap<>();
        PublishClassifyGood publishClassifyGood = new PublishClassifyGood();
        Good good = goodMapper.selectByKey(goodid);
        Classify classify = classifyMapper.selectByPrimaryKey(good.getClassifyid());
        publishClassifyGood.setClassify(classify);
        publishClassifyGood.setGood(good);
        map.put("gooddetail",publishClassifyGood);
        return map;
    }

    @Override
    public Map<String, Object> downgood(int goodid) {//下架物品
        Map<String,Object> map = new HashMap<>();
        Good good = goodMapper.selectByPrimaryKey(goodid);
        good.setGoodstate(0);
        int flag = goodMapper.updateByPrimaryKeySelective(good);
        if(flag == 1){
            map.put("success","物品已下架");
        }else {
            map.put("error","下架失败请重试");
        }
        return map;
    }
}
