package com.example.dao;

import com.example.model.Feedback;

import java.util.List;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer feedbackid);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer feedbackid);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
    List<Feedback> findallfeedback();
}