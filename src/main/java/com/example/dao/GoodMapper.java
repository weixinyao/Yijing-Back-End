package com.example.dao;

import com.example.model.ClassifyGood;
import com.example.model.Good;

import java.util.List;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer goodid);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer goodid);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
    List<Good> selectAllGood();
    List<ClassifyGood> findClassifyGoods();
    List<Good> queryByGoodname(String goodname);
    List<Good> queryByClassifyname(String classifyname);
    Good selectByKey(int goodid);
    int getuseridbygoodid(int goodid);
    List<Good> findallshenhegood();
    int permitgood(int goodid);

}