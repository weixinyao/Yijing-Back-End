package com.example.service;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/1-15:18
 */
@Repository
public interface PublishService {
    public Map<String,Object> getmypublish(int userid);
    public Map<String,Object> querydowngood(int goodid);
    public Map<String,Object> downgood(int goodid);
}
