package com.example.model;

public class Good {
    private Integer goodid;

    private String imgurl;

    private String goodname;

    private String goodinfo;

    private Double goodprice;

    private String goodContent;

    private Integer classifyid;

    private String firstimgurl;

    private Integer totalcount;

    private Integer rest;

    private Integer seld;

    private Integer publisherid;

    private Integer goodstate;

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }

    public String getGoodinfo() {
        return goodinfo;
    }

    public void setGoodinfo(String goodinfo) {
        this.goodinfo = goodinfo == null ? null : goodinfo.trim();
    }

    public Double getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(Double goodprice) {
        this.goodprice = goodprice;
    }

    public String getGoodContent() {
        return goodContent;
    }

    public void setGoodContent(String goodContent) {
        this.goodContent = goodContent == null ? null : goodContent.trim();
    }

    public Integer getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(Integer classifyid) {
        this.classifyid = classifyid;
    }

    public String getFirstimgurl() {
        return firstimgurl;
    }

    public void setFirstimgurl(String firstimgurl) {
        this.firstimgurl = firstimgurl == null ? null : firstimgurl.trim();
    }

    public Integer getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Integer totalcount) {
        this.totalcount = totalcount;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }

    public Integer getSeld() {
        return seld;
    }

    public void setSeld(Integer seld) {
        this.seld = seld;
    }

    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    public Integer getGoodstate() {
        return goodstate;
    }

    public void setGoodstate(Integer goodstate) {
        this.goodstate = goodstate;
    }
}