package com.example.dao;

import com.example.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //通过名字查询用户
    User queryByName(String name);
    Double getmoney(int userid);
}