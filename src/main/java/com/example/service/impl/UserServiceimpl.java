package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import com.example.utils.MD5Util;
import com.example.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/24-22:34
 */
@Repository
public class UserServiceimpl implements UserService {
    static int number=0;
    @Value("${absoluteImgPath}")
    String absoluteImgPath;
    @Value("${sonImgPath}")
    String sonImgPath;
    @Resource
    private UserMapper userMapper;
    @Override
    public Map<String, Object> login(String name, String password) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(name);
        User user = userMapper.queryByName(name);
        if(user == null) {
            map.put("error","用户名不存在，请重新登录");
        } else {
            String password2 = user.getPassword();
            String md5 = MD5Util.getMd5(name.concat(password),"utf-8");
            if(password2.equals(md5)) {
                user.setPassword(null);
                map.put("success",true);
                map.put("user",user);
            } else {
                map.put("error","密码错误，请重新登录");
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> register(String name, String password) {
        Map<String,Object> map = new HashMap<>();
        if(userMapper.queryByName(name) == null) {
            String md5 = MD5Util.getMd5(name.concat(password),"utf-8");
            User user = new User();
            user.setUsername(name);
            user.setPassword(md5);
            user.setUserimg("img/ac8ba282-17e6-214e-f020-d099a322553ctimg.jpg");
            user.setEmail("1107442961@qq.com");
            user.setTelephone("15217703391");
            user.setMoney(500.00);
            Integer integer = userMapper.insert(user);
            map.put("success", integer == 1);
        } else {
            map.put("error","用户名已经存在啦");
        }
        return map;
    }

    @Override
    public User queryuserbyid(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> updateuserimg(MultipartFile file,int userid) {
        Map<String,Object> map = new HashMap<>();
        String path="";
            if (file.isEmpty()) {
                map.put("code", "500");
                map.put("msg", "图片不能为空");
                System.out.println("图片不能为空");
                return map;
            }

            String originalFilename = file.getOriginalFilename();
            //随机生成文件名
            String fileName = RandomUtils.random() + originalFilename;
            File dest = new File(absoluteImgPath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            String feedPicture = sonImgPath + fileName;
            try {
                file.transferTo(dest);
                path+=feedPicture;
            } catch (Exception e) {
                map.put("ERROR", e.getMessage());
                return  map;
            }


        try {
                User user = new User();
                user.setUserimg(path);
                user.setUserid(userid);
               int flag = userMapper.updateByPrimaryKeySelective(user);
               if(flag == 1) {
                   map.put("OK", "200");
               }else {
                   map.put("error","上传失败");
               }

            return map;
        }
        catch (Exception e){
            map.put("ERROR",  e.getMessage());
            return map;
        }
    }

    @Override
    public User queryusermessage(int userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateusermessage(User user) {
        String oldpassword = user.getPassword();
        String name = user.getUsername();
        String newpassword = MD5Util.getMd5(name.concat(oldpassword),"utf-8");
        user.setPassword(newpassword);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Map<String, Object> addmoney(User user) {
        double addmoney = user.getMoney();//充值的钱
        double orgmoney = userMapper.getmoney(user.getUserid());
        double nowmoney = addmoney + orgmoney;
        System.out.println("nowmoney="+nowmoney);
        user.setMoney(nowmoney);
        int flag = userMapper.updateByPrimaryKeySelective(user);
        Map<String,Object> map = new HashMap<>();
        if(flag == 1){
            map.put("success","充值成功");
        }else {
            map.put("error","充值失败请重试");
        }
        return map;
    }

}
