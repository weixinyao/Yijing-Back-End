package com.example.service.impl;

import com.example.dao.CommentMapper;
import com.example.model.Comment;
import com.example.service.CommentService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yaoweixin
 * @date 2020/2/28-20:55
 */
@Repository
public class CommentServiceimpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public List<Comment> querycommentbygoodid(int goodid) {
        return commentMapper.queryByGoodId(goodid);
    }

    @Override
    public int insertcomment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int deletecomment(int commentid) {
        return commentMapper.deleteByPrimaryKey(commentid);
    }
}
