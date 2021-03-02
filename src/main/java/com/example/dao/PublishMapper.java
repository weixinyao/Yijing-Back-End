package com.example.dao;

import com.example.model.Publish;

import java.util.List;

public interface PublishMapper {
    int deleteByPrimaryKey(Integer publishid);

    int insert(Publish record);

    int insertSelective(Publish record);

    Publish selectByPrimaryKey(Integer publishid);

    int updateByPrimaryKeySelective(Publish record);

    int updateByPrimaryKey(Publish record);
    List<Publish> getpublishbyuserid(int userid);
}