package com.example.model;

/**
 * @author yaoweixin
 * @date 2020/3/1-21:27
 */
public class UserGoodOrder {
    private User user;
    private Good good;
    private Order order;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
