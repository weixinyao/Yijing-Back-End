package com.example.service.impl;

import com.example.dao.CollectMapper;
import com.example.dao.GoodMapper;
import com.example.model.*;
import com.example.service.CollectService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/1-15:25
 */
@Repository
public class CollectServiceimpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;
    @Resource
    private GoodMapper goodMapper;
    @Override
    public Map<String, Object> getmycollect(int userid) {
        Map<String,Object> map = new HashMap<>();
        List<Collect> collectList = collectMapper.getcollectbyuserid(userid);
        List<CollectGood> collectGoodList = new ArrayList<>();
        for(Collect collect: collectList){
            int goodid = collect.getGoodid();
            Good good =goodMapper.selectByPrimaryKey(goodid);
            CollectGood collectGood = new CollectGood();
            collectGood.setGood(good);
            collectGood.setCollect(collect);
            collectGoodList.add(collectGood);
        }
        map.put("mycollect",collectGoodList);
        return map;
    }

    @Override
    public Map<String, Object> addcollect(Collect collect) {
        Map<String,Object> map = new HashMap<>();
        int flag = collectMapper.insert(collect);
        if(flag == 1){
            map.put("success","收藏成功");
        }else {
            map.put("error","收藏失败请重试");
        }
        return map;
    }
}
