package com.example.controller;

import com.example.service.impl.PublishServiceimpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/1-15:47
 */
@Controller
public class PublishController {
    @Resource
    private PublishServiceimpl publishServiceimpl;
    @GetMapping("/publish/{userid}")
    @ResponseBody
    public Map<String,Object> getpublish(@PathVariable(value="userid")int userid){
        return publishServiceimpl.getmypublish(userid);
    }
    @GetMapping(value="/getdowngood/{goodid}")
    @ResponseBody
    public Map<String,Object> getdowngood(@PathVariable(value="goodid")int goodid){
        return publishServiceimpl.querydowngood(goodid);
    }
    @GetMapping(value="/downgood/{goodid}")
    @ResponseBody
    public Map<String,Object> downgood(@PathVariable(value="goodid")int goodid){
        return publishServiceimpl.downgood(goodid);
    }
}
