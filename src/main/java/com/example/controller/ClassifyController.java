package com.example.controller;

import com.example.service.impl.ClassifyServiceimpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/2-12:18
 */
@Controller
public class ClassifyController {
    @Resource
    private ClassifyServiceimpl classifyServiceimpl;
    @GetMapping(value="/getallclassify")
    @ResponseBody
    public Map<String,Object> getallclassify(){
        return classifyServiceimpl.queryallclassify();
    }
}
