package com.example.service;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/25-23:41
 */
@Repository
public interface ManagerService {
    public Map<String,Object> managerlogin(String name,String password);
    public Map<String,Object> analyseorder();
}
