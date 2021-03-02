package com.example.dao;

import com.example.model.Classify;

import java.util.List;

public interface ClassifyMapper {
    int deleteByPrimaryKey(Integer classifyid);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(Integer classifyid);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
    List<Classify> getallclassify();
}