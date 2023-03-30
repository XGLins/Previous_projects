package com.dingli.entity;

/**
 * 设备实体类
 * */
public class Equipment {

    /**
     * 私有化成员变量
     * */
        //设备编号
        private int eid;

        //设备名称
        private String ename;

        //设备描述
        private String edescribe;

        //所属部门
        private String edname;

    /**
     * 带参 与 无参 构造方法
     *
     */
    public Equipment() {
    }

    public Equipment(int eid, String ename, String edescribe, String edname) {
        this.eid = eid;
        this.ename = ename;
        this.edescribe = edescribe;
        this.edname = edname;
    }

    /**
     * get 与 set 方法
     * */
        public int getEid() {
            return eid;
        }

        public void setEid(int eid) {
            this.eid = eid;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getEdescribe() {
            return edescribe;
        }

        public void setEdescribe(String edescribe) {
            this.edescribe = edescribe;
        }

        public String getEdname() {
            return edname;
        }

        public void setEdname(String edname) {
            this.edname = edname;
        }




        //生成的toString方法
        @Override
        public String toString() {
            return "Equipment{" +
                    "eid=" + eid +
                    ", ename='" + ename + '\'' +
                    ", edescribe='" + edescribe + '\'' +
                    ", edname='" + edname + '\'' +
                    '}';
        }
}
