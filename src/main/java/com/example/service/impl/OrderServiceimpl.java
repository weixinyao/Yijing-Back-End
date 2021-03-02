package com.example.service.impl;

import com.example.dao.GoodMapper;
import com.example.dao.OrderMapper;
import com.example.dao.UserMapper;
import com.example.model.Good;
import com.example.model.Order;
import com.example.model.OrderGood;
import com.example.model.User;
import com.example.service.OrderService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author yaoweixin
 * @date 2020/3/1-14:46
 */
@Repository
public class OrderServiceimpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private GoodMapper goodMapper;
    @Resource
    private UserMapper userMapper;
    @Override
    public Map<String, Object> getmyorder(int userid) {
        Map<String,Object> map = new HashMap<>();
        List<OrderGood> orderGoodList = new ArrayList<>();
        List<Order> orderList =orderMapper.getOrderByuserid(userid);
        for(Order order:orderList){
            int goodid = order.getGoodid();
            Good good = goodMapper.selectByPrimaryKey(goodid);
            OrderGood orderGood = new OrderGood();
            orderGood.setGood(good);
            orderGood.setOrder(order);
            orderGoodList.add(orderGood);
        }
        map.put("myorder",orderGoodList);
        return map;
    }

    @Override
    public Map<String, Object> buygood(Order order) {
        Map<String,Object> map = new HashMap<>();
        Date date = new Date();
        order.setCreatetime(date) ;
        int goodid = order.getGoodid();
        Good good = goodMapper.selectByPrimaryKey(goodid);
        int pubid = goodMapper.getuseridbygoodid(good.getGoodid());//发布该物品的发布者id
        User pubuser = userMapper.selectByPrimaryKey(pubid);
        Double pubmoney = pubuser.getMoney();
        Double pubmoneynow = 0.0;
        int totalcount = good.getTotalcount();//得到商品总数
        int rest = good.getRest();//得到剩余数量
        int seld = good.getSeld();//得到已售数量
        Double goodprice = good.getGoodprice();
        int buynum = order.getBuynumber();
        Double totalprice = buynum*goodprice; //总价格
        int userid = order.getUserid();
        User user = userMapper.selectByPrimaryKey(userid);
        Double usermoney = user.getMoney();//用户余额
        if(totalprice> usermoney){
            map.put("error","用户余额不足请充值");
        }else {
            Double restmoney = usermoney - totalprice;
            User usern = new User();
            usern.setUserid(userid);
            usern.setMoney(restmoney);
            pubmoneynow = pubmoney + totalprice;
            pubuser.setMoney(pubmoneynow);
            int flag1 =userMapper.updateByPrimaryKeySelective(usern);
            int flag = userMapper.updateByPrimaryKeySelective(pubuser);
            int seln = seld + buynum;
            int restn = totalcount - seln;
            Good goodn = new Good();
            goodn.setGoodid(goodid);
            goodn.setRest(restn);
            goodn.setSeld(seln);
            int flag2 = goodMapper.updateByPrimaryKeySelective(goodn);
            int flag3 = orderMapper.insert(order);
            if(flag1 ==1 && flag2 == 1 && flag3 == 1 && flag == 1){
                map.put("success","购买成功");
            }else {
                map.put("error","操作失败请重试");
            }

        }

        return map;
    }

    @Override
    public List<Order> getallorder() {
        return orderMapper.getallorder();
    }

    @Override
    public Map<String,Object> getfiveorder() {
        Map<String,Object> map = new HashMap<>();
        List<OrderGood> orderGoodList = new ArrayList<>();
        List<Order> orderList = orderMapper.getfiveorder();
        for(Order order: orderList){
              int goodid = order.getGoodid();
              Good good = goodMapper.selectByPrimaryKey(goodid);
              OrderGood orderGood = new OrderGood();
              orderGood.setOrder(order);
              orderGood.setGood(good);
              orderGoodList.add(orderGood);
        }
        map.put("fivegood",orderGoodList);
        return map;
    }
}
