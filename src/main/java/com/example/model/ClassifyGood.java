package com.example.model;

import java.util.List;

/**
 * @author yaoweixin
 * @date 2020/2/26-20:52
 */
public class ClassifyGood {
    private String classifyname;
    private List<Good> goodList;

    public String getClassifyname() {
        return classifyname;
    }

    public void setClassifyname(String classifyname) {
        this.classifyname = classifyname;
    }

    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }
}
