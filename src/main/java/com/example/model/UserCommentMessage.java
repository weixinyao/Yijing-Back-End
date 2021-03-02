package com.example.model;

/**
 * @author yaoweixin
 * @date 2020/2/28-21:02
 */
public class UserCommentMessage {
    private User user;
    private Comment comment;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
