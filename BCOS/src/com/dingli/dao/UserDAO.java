package com.dingli.dao;

import com.dingli.entity.User;
import com.dingli.util.JdbcTools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserDAO {
    //将JdbcTools以全局变量的形式注入到DAO中
    private JdbcTools jt = new JdbcTools();

    //User类orm方法映射
    public User ormUser(Map<String, Object> map) {
        User user = new User();
        if (map.get("uid") != null) {
            user.setUid((int) map.get("uid"));
        }
        if (map.get("uname") != null) {
            user.setUname((String) map.get("uname"));
        }
        if (map.get("password") != null) {
            user.setPassword((String) map.get("password"));
        }
        if (map.get("phone") != null) {
            user.setPhone((String) map.get("phone"));
        }
        if (map.get("idcard") != null) {
            user.setIdcard((String) map.get("idcard"));
        }
        if (map.get("create_time") != null) {
            user.setCreateTime((Date) map.get("create_time"));
        }
        if (map.get("role") != null) {
            user.setRole((int) map.get("role"));
        }
        return user;
    }

    /**
     * 方法区域
     * */
    public User login(int uid, String password) {
        String sql = "select * from user where uid=? and password=? and role=0";
        List<Map<String, Object>> list = jt.select(sql, uid, password);
        if (list.size() == 0) {
            return null;
        }
        Map<String, Object> map = list.get(0);
        return ormUser(map);
    }

    //书写list查询列表方法，传入查询条件，返回List结果集
    public List<User> list(String search) {
        String sql = "select * from user";
        List<Map<String, Object>> list;
        //搜索条件不为空时，加入sql条件
        if (search != null && !search.trim().equals("")) {
            sql = sql + " where uid like ? or uname like ? or phone like ? or idcard like ?";
            list = jt.select(sql, "%" + search + "%", "%" + search + "%", "%" +
                    search + "%", "%" + search + "%");
        } else {
            list = jt.select(sql);
        }
        List<User> result = new ArrayList<>();
        list.forEach(one -> result.add(ormUser(one)));
        return result;
    }

    //添加用户新增方法，传入User对象，返回操作结果。
    public int insert(User user) {
        String sql = "insert into user(uname,password,phone,idcard,create_time,role) value(?,?,?,?,?,?)";
        return jt.insert(sql, user.getUname(), user.getPassword(),
                user.getPhone(), user.getIdcard(), user.getCreateTime(),
                user.getRole());
    }

    //在跳转修改界面之前，需查询出要修改用户的原数据，因此在UserDAO添加根据uid查询用户信息方法
    public User selectById(int uid) {
        String sql = "select * from user where uid=?";
        List<Map<String, Object>> list = jt.select(sql, uid);
        if (list.size() == 0) {
            return null;
        }
        Map<String, Object> one = list.get(0);
        return ormUser(one);
    }

    //添加用户修改方法，根据uid，修改用户名称、密码、电话、身份证号、角色
    public int updateById(User user) {
        String sql = "update user set uname=?,password=?,phone=?,idcard=?,role=? where uid=?";
        return jt.update(sql, user.getUname(), user.getPassword(),
                user.getPhone(), user.getIdcard(), user.getRole(), user.getUid());
    }

    //删除用户信息方法，传入要删除的账号，返回操
    public int deleteById(int uid) {
        String sql = "delete from user where uid=?";
        return jt.delete(sql, uid);
    }



}
