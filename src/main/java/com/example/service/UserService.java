package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/24-22:30
 */
@Repository
public interface UserService {
    public Map<String, Object> login(String name, String password);
    public Map<String, Object> register(String name, String password);
    public User queryuserbyid(int id);
    public Map<String,Object> updateuserimg(MultipartFile file,int userid);
    public User queryusermessage(int userid);
    public int updateusermessage(User user);
    public Map<String,Object> addmoney(User user);
}
