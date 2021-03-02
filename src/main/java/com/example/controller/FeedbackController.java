package com.example.controller;

//import com.example.model.FeedBack;
import com.example.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/4-22:07
 */
/*
@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping(value="/upload")
    @ResponseBody
    public Map uploadImg(@RequestParam(value = "file",required = false) MultipartFile[] file,@RequestParam(value="update",required = false)Boolean update ,FeedBack feedBack){
       feedBack.setFeedStateTime(new Date());
        feedBack.setFeedTime(new Date());
        return feedbackService.uploadImg(file,update,feedBack);
    }
    @GetMapping(value="/hello")
    @ResponseBody
    public String sayhello(){
        return "hello";
    }
}
*/
