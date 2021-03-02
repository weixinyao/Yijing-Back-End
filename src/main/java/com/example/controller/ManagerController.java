package com.example.controller;

import com.example.model.Good;
import com.example.model.Order;
import com.example.model.User;
import com.example.model.UserGoodOrder;
import com.example.service.impl.GoodServiceimpl;
import com.example.service.impl.ManagerServiceimpl;
import com.example.service.impl.OrderServiceimpl;
import com.example.service.impl.UserServiceimpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/26-0:03
 */
@Controller
public class ManagerController {
    @Resource
    private GoodServiceimpl goodServiceimpl;
    @Resource
    private UserServiceimpl userServiceimpl;
    @Resource
    private OrderServiceimpl orderServiceimpl;
    @Resource
    private ManagerServiceimpl managerServiceimpl;
    @GetMapping(value="/managerlogin")
    @ResponseBody
    public Map<String,Object> managerlogin(@RequestParam(value="managername")String name, @RequestParam(value="mpassword")String password){
        return managerServiceimpl.managerlogin(name,password );
    }
    @GetMapping(value="/getallorder")
    @ResponseBody
    public Map<String,Object> getallorder(){//管理员拿到所有订单
     Map<String,Object> map = new HashMap();
     List<UserGoodOrder> userGoodOrderList = new ArrayList<>();
     List<Order> orderList = orderServiceimpl.getallorder();
     for(Order order: orderList){
         int userid = order.getUserid();
         int goodid = order.getGoodid();
         User user = userServiceimpl.queryuserbyid(userid);
         Good good = goodServiceimpl.queryGoodById(goodid);
         UserGoodOrder userGoodOrder = new UserGoodOrder();
         userGoodOrder.setGood(good);
         userGoodOrder.setOrder(order);
         userGoodOrder.setUser(user);
         userGoodOrderList.add(userGoodOrder);
     }
        map.put("allorder",userGoodOrderList);
     return map;

    }
    @GetMapping(value="/analyseorder")
    @ResponseBody
    public Map<String,Object> analyse(){//统计订单信息
        return managerServiceimpl.analyseorder();
    }
}
