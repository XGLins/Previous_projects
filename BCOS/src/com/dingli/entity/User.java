package com.dingli.entity;

import java.util.Date;

public class User {
    //私有化成员变量
    private int uid;
    private String uname;
    private String password;
    private String phone;
    private String idcard;
    private Date createTime;
    private int role;

    //构造方法
    public User() {
    }
    public User(int uid, String uname, String password, String phone, String idcard, Date createTime, int role) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.phone = phone;
        this.idcard = idcard;
        this.createTime = createTime;
        this.role = role;
    }

    //get 和 set 方法
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    //重写toString
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", idcard='" + idcard + '\'' +
                ", createTime=" + createTime +
                ", role=" + role +
                '}';
    }
}
