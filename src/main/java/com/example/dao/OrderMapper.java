package com.example.dao;

import com.example.model.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    List<Order> getOrderByuserid(int userid);
    List<Order> getallorder();
    List<Order> getfiveorder();
    int getnowordernumber();
    int getyesterdayordernumber();
    int getnearsevenordernumber();
    int getnearthirtyordernumber();
    int getquarterordernumber();
}