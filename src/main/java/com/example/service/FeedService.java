package com.example.service;

import com.example.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/1-21:11
 */
@Repository
public interface FeedService {
    public Map<String,Object> addfeedback(Feedback feedback);
    public Map<String,Object> managerfeedback();
    public Map<String,Object> deletefeedback(int feedbackid);

}
