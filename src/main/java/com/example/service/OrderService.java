package com.example.service;

import com.example.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/1-14:43
 */
@Repository
public interface OrderService {
    public Map<String,Object> getmyorder(int userid);
    public Map<String,Object> buygood(Order order);
    public List<Order> getallorder();
    public Map<String,Object> getfiveorder();
}
