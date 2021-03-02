package com.example.service;

import com.example.model.ClassifyGood;
import com.example.model.Good;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/26-10:24
 */
@Repository
public interface GoodService {
    public PageInfo<Good> selectallgoods(int page,int pagesize);
    public List<ClassifyGood> findclassifygoods();
    public List<Good> findqueryGoods(String name);
    public Good queryGoodById(int id);
    public Map<String,Object> applygood(MultipartFile[] file, Good good);
    public Map<String,Object> findallshenhegood();
    public Map<String,Object> selectshenhegoodbyid(int gooid);
    public Map<String,Object> permitgood(int goodid);
}
