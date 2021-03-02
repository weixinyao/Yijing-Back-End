package com.example.controller;

import com.example.model.Order;
import com.example.service.impl.OrderServiceimpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/1-15:04
 */
@Controller
public class OrderController {
    @Resource
    private OrderServiceimpl orderServiceimpl;
    @GetMapping("/order/{userid}")
    @ResponseBody
    public Map<String,Object> getorder(@PathVariable(value="userid")int userid){
        return orderServiceimpl.getmyorder(userid);
    }
    @PostMapping(value="/buygood")
    @ResponseBody
    public Map<String,Object> buygood(@RequestBody Order order){
        return orderServiceimpl.buygood(order);
    }
    @GetMapping(value="/getfiveorder")
    @ResponseBody
    public Map<String,Object> getfiveorder(){//得到当天的购买数量排名前五的订单
        return orderServiceimpl.getfiveorder();
    }
}
