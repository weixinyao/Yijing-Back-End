package com.example.service.impl;

import com.example.dao.ClassifyMapper;
import com.example.model.Classify;
import com.example.service.ClassifyService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/2-12:12
 */
@Repository
public class ClassifyServiceimpl implements ClassifyService {
    @Resource
    private ClassifyMapper classifyMapper;
    @Override
    public Map<String, Object> queryallclassify() {
        Map<String,Object> map = new HashMap<>();
        List<Classify> classifyList = classifyMapper.getallclassify();
        map.put("allclassify",classifyList);
        return map;
    }
}
