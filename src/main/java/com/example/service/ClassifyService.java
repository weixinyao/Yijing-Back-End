package com.example.service;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/2-12:11
 */
@Repository
public interface ClassifyService {
    public Map<String,Object> queryallclassify();
}
