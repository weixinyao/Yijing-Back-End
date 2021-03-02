package com.example.service.impl;

import com.example.dao.FeedbackMapper;
import com.example.dao.UserMapper;
import com.example.model.Feedback;
import com.example.model.User;
import com.example.model.UserFeedback;
import com.example.service.FeedService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author yaoweixin
 * @date 2020/3/1-21:13
 */
@Repository
public class FeedbackServiceimpl implements FeedService {
    @Resource
    private FeedbackMapper feedbackMapper;
    @Resource
    private UserMapper userMapper;
    @Override
    public Map<String, Object> addfeedback(Feedback feedback) {
        Map<String,Object> map = new HashMap<>();
        Date date = new Date();
        int flag = feedbackMapper.insert(feedback);
        if(flag == 1){
            map.put("success","反馈成功");
        }else {
            map.put("error","反馈失败请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> managerfeedback() {
        Map<String,Object> map = new HashMap<>();
        List<Feedback> feedbackList = feedbackMapper.findallfeedback();
        List<UserFeedback> userFeedbackList = new ArrayList<>();
        for(Feedback feedback: feedbackList){
            int userid = feedback.getUserid();
            User user = userMapper.selectByPrimaryKey(userid);
            UserFeedback userFeedback = new UserFeedback();
            userFeedback.setFeedback(feedback);
            userFeedback.setUser(user);
            userFeedbackList.add(userFeedback);
        }
        map.put("allfeedback",userFeedbackList);
        return map;
    }

    @Override
    public Map<String, Object> deletefeedback(int feedbackid) {
        Map<String,Object> map = new HashMap<>();
        int flag = feedbackMapper.deleteByPrimaryKey(feedbackid);
        if(flag == 1){
            map.put("success","成功删除反馈");
        }else {
            map.put("error","删除反馈失败请重试");
        }
        return map;
    }
}
