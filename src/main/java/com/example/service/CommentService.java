package com.example.service;

import com.example.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yaoweixin
 * @date 2020/2/28-20:54
 */
@Repository
public interface CommentService {
    public List<Comment> querycommentbygoodid(int goodid);
    public int insertcomment(Comment comment);
    public int deletecomment(int commentid);
}
