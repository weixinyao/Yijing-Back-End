package com.example.model;

/**
 * @author yaoweixin
 * @date 2020/3/12-12:42
 */
public class UserFeedback {
    private User user;
    private Feedback feedback;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
