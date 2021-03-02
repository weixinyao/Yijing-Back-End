package com.example.controller;

import com.example.model.Feedback;
import com.example.service.impl.FeedbackServiceimpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/1-21:17
 */
@Controller
public class FeedBakController {
    @Resource
    private FeedbackServiceimpl feedbackServiceimpl;
    @PostMapping(value="/addfeedback")
    @ResponseBody
    public Map<String,Object> addfeedback(@RequestBody Feedback feedback){
        return feedbackServiceimpl.addfeedback(feedback);
    }
    @GetMapping(value="/findallfeedback")
    @ResponseBody
    public Map<String,Object> getallfeedback(){
        return feedbackServiceimpl.managerfeedback();
    }
    @GetMapping(value="/deletefeedback/{feedbackid}")
    @ResponseBody
    public Map<String,Object> deletefeedback(@PathVariable(value="feedbackid")int feedbackid){
        return feedbackServiceimpl.deletefeedback(feedbackid);
    }
}
