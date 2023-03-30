package com.dingli.entity;

/**
 * 部门实体类
 * */
public class Department {

    /**
     * 部门id
     * */
    private int did;

    /**
     * 部门名称
     * */
    private String dname;

    /**
     * 部门信息
     * */
    private String info;

    /**
     * 构造方法 有参构造，无参构造
     * */
    public Department() {
    }

    public Department(int did, String dname, String info) {
        this.did = did;
        this.dname = dname;
        this.info = info;
    }

    /**
     * get与set方法
     * */
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    //生成的toString方法
    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
