package com.example.service;

import com.example.model.Collect;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/1-15:19
 */
@Repository
public interface CollectService {
    public Map<String,Object> getmycollect(int userid);
    public Map<String,Object> addcollect(Collect collect);
}
