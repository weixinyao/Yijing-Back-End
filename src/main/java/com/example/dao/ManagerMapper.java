package com.example.dao;

import com.example.model.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer managerid);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer managerid);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
    Manager selectByManagername(String managername);
}