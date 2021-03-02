package com.example.service.impl;

import com.example.dao.ManagerMapper;
import com.example.dao.OrderMapper;
import com.example.model.Manager;
import com.example.service.ManagerService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/25-23:44
 */
@Repository
public class ManagerServiceimpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;
    @Resource
    private OrderMapper orderMapper;
    @Override
    public Map<String, Object> managerlogin(String name, String password) {
        Map<String,Object> map = new HashMap<>();
        Manager manager = managerMapper.selectByManagername(name);
        if(manager == null){
            map.put("error","用户名不存在，请重新登录");
        }else {
            if(manager.getMpassword().equals(password)){
                map.put("success","用户登录成功");
            }else {
                map.put("error","密码错误，请重新登录");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> analyseorder() {
        int now = orderMapper.getnowordernumber();
        int yesterday = orderMapper.getyesterdayordernumber();
        int nearseven = orderMapper.getnearsevenordernumber();
        int nearthirty = orderMapper.getnearthirtyordernumber();
        int quarter = orderMapper.getquarterordernumber();
        Map<String,Object> map = new HashMap<>();
        map.put("now",now);
        map.put("yesterday",yesterday);
        map.put("nearseven",nearseven);
        map.put("nearthirty",nearthirty);
        map.put("quarter",quarter);
        return map;
    }
}
