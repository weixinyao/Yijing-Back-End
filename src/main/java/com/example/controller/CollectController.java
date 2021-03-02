package com.example.controller;

import com.example.model.Collect;
import com.example.service.impl.CollectServiceimpl;
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
public class CollectController {
    @Resource
    private CollectServiceimpl collectServiceimpl;
    @GetMapping("/collect/{userid}")
    @ResponseBody
    public Map<String,Object> getorder(@PathVariable(value="userid")int userid){
        return collectServiceimpl.getmycollect(userid);
    }
    @GetMapping(value="/collectgood/{userid}/{goodid}")
    @ResponseBody
    public Map<String,Object> addcollect(@PathVariable(value="userid")int userid,@PathVariable(value="goodid")int goodid){
        Collect collect = new Collect();
        collect.setGoodid(goodid);
        collect.setUserid(userid);
        return collectServiceimpl.addcollect(collect);
    }
}
