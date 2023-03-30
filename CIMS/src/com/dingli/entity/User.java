package com.dingli.entity;

/**
 * 用户实体类
 * */
public class User {
    /**
     * 账号
     * */
    private int uid;

    /**
     * 用户名
     * */
    private String uname;

    /**
     * 密码
     * */
    private String password;

    /**
     * 电话
     * */
    private String phone;

    /**
     * 角色：0-管理员；1-普通成员
     * */
    private int role;

    /**
     * 部门id
     * */
    private int did;

    /**
     * 构造方法 有参构造，无参构造
     * */
    public User() {
    }

    public User(int uid, String uname, String password, String phone, int role, int did) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.did = did;
    }

    /**
     * get与set方法
     * */
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    //生成的toString方法
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", did=" + did +
                '}';
    }

}
