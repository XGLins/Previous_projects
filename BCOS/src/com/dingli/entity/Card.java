package com.dingli.entity;

import java.util.Date;

public class Card {
    //私有化成员变量
    private int cid;
    private String type;
    private double account;
    private Date createTime;
    private int uid;

    /**
     * 账户信息
     * */
    private User user;

    //构造方法
    public Card() {
    }
    public Card(int cid, String type, double account, Date createTime, int uid) {
        this.cid = cid;
        this.type = type;
        this.account = account;
        this.createTime = createTime;
        this.uid = uid;
    }

    //get 和 set 方法
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //重写toString
    @Override
    public String toString() {
        return "Card{" +
                "cid=" + cid +
                ", type='" + type + '\'' +
                ", account=" + account +
                ", createTime=" + createTime +
                ", uid=" + uid +
                '}';
    }
}
