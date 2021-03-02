package com.example.controller;

import com.example.model.Comment;
import com.example.model.User;
import com.example.model.UserCommentMessage;
import com.example.service.impl.CommentServiceimpl;
import com.example.service.impl.UserServiceimpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author yaoweixin
 * @date 2020/2/28-20:57
 */
@Controller
public class CommentController {
    @Resource
    private CommentServiceimpl commentServiceimpl;
    @Resource
    private UserServiceimpl userServiceimpl;
    @GetMapping(value="/comment/{goodid}")
    @ResponseBody
    public Map<String,Object> querycommentbygoodid(@PathVariable(value="goodid")int goodid) {
        Map<String,Object> map = new HashMap<>();
        List<UserCommentMessage> userCommentMessageList = new ArrayList<>();
        List<Comment> commentList = commentServiceimpl.querycommentbygoodid(goodid);
        for(Comment comment: commentList){
            User user = userServiceimpl.queryuserbyid(comment.getUserid());
            UserCommentMessage userCommentMessage = new UserCommentMessage();
            userCommentMessage.setUser(user);
            userCommentMessage.setComment(comment);
            userCommentMessageList.add(userCommentMessage);
        }
        map.put("usercomment",userCommentMessageList);
        return map;

    }
    @PostMapping(value="/addcomment")
    @ResponseBody
    /* 添加评论*/
    public Map<String,Object> insertcomment(@RequestBody Comment comment){
        Map<String,Object> map = new HashMap<>();
        Date date = new Date();
        comment.setCommenttime(date);
        int flag = commentServiceimpl.insertcomment(comment);
        if(flag == 1){
            map.put("success","添加评论成功");
        }else {
            map.put("error","添加评论失败");
        }
        return map;
    }
    @GetMapping(value="/deletecomment/{commentid}")
    @ResponseBody
    public Map<String,Object> deletecomment(@PathVariable(value="commentid")int commentid){
        Map<String,Object> map = new HashMap<>();
        int flag = commentServiceimpl.deletecomment(commentid);
        if(flag == 1){
            map.put("success","删除成功");
        }else {
            map.put("error","删除失败请重试");
        }
        return map;
    }
}
