package com.example.controller;

import com.example.model.User;
import com.example.service.impl.UserServiceimpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/24-23:00
 */
@Controller
public class UserController {
    @Resource
    private UserServiceimpl userServiceimpl;
    @GetMapping(value="/login")
    @ResponseBody
    public Map<String, Object> login(@RequestParam(value="username")String name,@RequestParam(value="password")String password){
        return userServiceimpl.login(name,password);
    }
    @PostMapping(value="/register")
    @ResponseBody
    public Map<String,Object> register(@RequestParam(value="username")String name,@RequestParam(value="password")String password) {
        return userServiceimpl.register(name,password);
    }
    @PostMapping(value="/upload")
    @ResponseBody
    public Map<String,Object> uploaduserimg(@RequestParam("file") MultipartFile file,@RequestParam(value="userid")int userid){
            return userServiceimpl.updateuserimg(file,userid);
    }
    @GetMapping(value="/getusermessage/{userid}")
    @ResponseBody
    public Map<String,Object> getuser(@PathVariable(value="userid")int userid){
        Map<String,Object> map = new HashMap<>();
        User user = userServiceimpl.queryusermessage(userid);
        map.put("usermessage",user);
        return map;
    }
    @PostMapping(value="/updateusermessage")
    @ResponseBody
    public Map<String,Object> updateusermessage(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        int flag = userServiceimpl.updateusermessage(user);
        if(flag == 1) {
            map.put("success","修改成功");
        }else {
            map.put("error","修改失败请重试");
        }
        return map;
    }
    @PostMapping(value="/addmoney")
    @ResponseBody
    public Map<String,Object> addmoney(@RequestBody User user){ //充值
        return userServiceimpl.addmoney(user);
    }
}
