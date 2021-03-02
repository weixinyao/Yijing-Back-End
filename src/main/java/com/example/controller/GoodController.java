package com.example.controller;

import com.example.model.ClassifyGood;
import com.example.model.Good;
import com.example.service.impl.GoodServiceimpl;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/26-10:41
 */
@Controller
public class GoodController {
    @Resource
    private GoodServiceimpl goodServiceimpl;
    @GetMapping(value="/getgoods/{pagenum}")
    @ResponseBody
    //根据第几页查询相应的商品数据
    public Map<String,Object> findAllGoods(@PathVariable(value = "pagenum")int pagenum){
        Map<String,Object> map = new HashMap<>();
        PageInfo<Good> pageInfo = goodServiceimpl.selectallgoods(pagenum,4 );
        map.put("goods",pageInfo);
        return map;
    }
    @GetMapping(value="/getclassifygoods")
    @ResponseBody
    //查询所有商品并对商品进行分类
    public Map<String,Object> findclassifygoods(){
        Map<String,Object> map = new HashMap<>();
        List<ClassifyGood> classifyGood = goodServiceimpl.findclassifygoods();
        map.put("classifygoodlists",classifyGood);
        List<String> list = new ArrayList<>();
        list.add("//cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/69bf9d06a7285a70adbec96448d5377c.jpg?thumb=1&w=500&h=200");
        list.add("//i8.mifile.cn/v1/a1/250eae49-3536-0d22-4f3a-5041affcb1f9!500x200.webp");
//        list.add("//i8.mifile.cn/v1/a1/efdcf401-f553-aef7-1751-43854b6f4a20!500x200.webp");
//        list.add("//cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/17dbc837b82de528f8f4abf4ede0753a.jpg?thumb=1&w=500&h=200");
//        list.add("//cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f1042af20f63f37c30bd9399efdc0b7a.jpg?thumb=1&w=500&h=200");
//        list.add("//cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/55a9f5db1e6cd217a27b6b59d64509cd.jpg?thumb=1&w=500&h=200");
        map.put("titleimg",list);
        return map;
    }
    @GetMapping(value="/searchgood")
    @ResponseBody
    //根据商品名或者分类名查询相应的商品
    public Map<String,Object> searchgoods(@RequestParam(value="name")String name) {
        Map<String,Object> map = new HashMap<>();
        List<Good> goodList = goodServiceimpl.findqueryGoods(name);
        map.put("searchresult",goodList);
        return map;
    }
    @GetMapping(value="/good/{goodid}")
    @ResponseBody
    //根据id查询指定的商品
    public Map<String,Object> findgoodById(@PathVariable(value="goodid")int goodid) {
        Map<String,Object> map = new HashMap<>();
        Good good = goodServiceimpl.queryGoodById(goodid);
        map.put("good",good);
        return map;
    }
    @PostMapping(value="/uploadgood")
    @ResponseBody
    public Map<String,Object> uploadgood(@RequestParam(value = "file",required = false) MultipartFile[] file,@RequestParam(value = "goodname",required = false)String goodname,@RequestParam(value = "goodinfo",required = false)String goodinfo,@RequestParam(value = "goodprice",required = false)Double goodprice,@RequestParam(value = "goodcontent",required = false)String goodContent,@RequestParam(value = "classifyid",required = false)Integer classifyid,@RequestParam(value = "totalcount",required = false)Integer totalcount,@RequestParam(value = "publisherid",required = false)Integer publisherid){
        Map<String,Object> map = new HashMap<>();
        Good good = new Good();
        good.setClassifyid(classifyid);
        good.setGoodContent(goodContent);
        good.setGoodinfo(goodinfo);
        good.setGoodname(goodname);
        good.setGoodprice(goodprice);
        good.setTotalcount(totalcount);
        good.setRest(totalcount);
        good.setSeld(0) ;
        good.setGoodstate(2) ;
        good.setPublisherid(publisherid);
        return goodServiceimpl.applygood(file,good);
    }
    @GetMapping(value="/getallshenhegood")  //获取所有审核的物品
    @ResponseBody
    public Map<String,Object> findallshgood(){
        return goodServiceimpl.findallshenhegood();
    }
    @GetMapping(value="/shenhegood/{goodid}")
    @ResponseBody
    public Map<String,Object> selectshenhegoodbyid(@PathVariable(value="goodid")int goodid){
        return goodServiceimpl.selectshenhegoodbyid(goodid);
    }
    @GetMapping(value="/permitgood/{goodid}")
    @ResponseBody
    public Map<String,Object> permit(@PathVariable(value="goodid")int goodid){
        return goodServiceimpl.permitgood(goodid);
    }

}
