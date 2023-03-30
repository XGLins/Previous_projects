package com.dingli.dao;

import com.dingli.entity.User;
import com.dingli.util.JdbcTools;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDAO {

    //注入JdbcTools全局变量
    private JdbcTools jt = new JdbcTools();

    /**
     * Map转User的orm映射方法
     *
     * @param map 传入的map
     * @return User对象
     */
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
        if (map.get("role") != null) {
            user.setRole((int) map.get("role"));
        }
        if (map.get("did") != null) {
            user.setDid((int) map.get("did"));
        }
        return user;
    }

    //登录要求：传入账号及密码进行登录，登录成功后返回该用户相关信息
    public User login(int uid,String password){

        //根据账号及密码进行登录查询，但业务限定系统只能由管理员登录，因此需加上条件role=0
        String sql = "select * from user where uid = ? and password = ? and role = 0";

        //使用JDBC工具类执行查询，返回结果集
        List<Map<String,Object>> list = jt.select(sql,uid,password);
        if (list.size() == 0){
            return null;
        }
        Map<String,Object> map = list.get(0);

        return ormUser(map);
    }

    //UserDAO中新建查询方法，返回List集合数据
    public List<User> selectAll() {

        String sql = "select * from user";

        List<Map<String, Object>> list = jt.select(sql);
        if (list.size() == 0) {
            return null;
        }
        List<User> result = new LinkedList<>();
        list.forEach(one -> {
            ormUser(one);
            result.add(ormUser(one));
        });
        return result;
    }

    //用户新增数据层方法
    public int insert(User user) {
        String sql = "insert into user(uname,password,phone,role,did) value(?,?,?,?,?)";
        return jt.insert(sql, user.getUname(), user.getPassword(),
                user.getPhone(), user.getRole(), user.getDid());
    }


    //先查出修改的成员原数据，再跳向editUser.jsp 默认显示在jsp上
    public User selectById(int uid) {
        String sql = "select * from user where uid=?";
        List<Map<String, Object>> list = jt.select(sql, uid);
        if (list.size() == 0) {
            return null;
        }
        Map<String, Object> one = list.get(0);
        return ormUser(one);
    }

    //完成成员信息修改数据层方法书写
    public int updateById(User user) {
        String sql = "update user set uname=?,password=?,phone=?,role=?,did=? where uid=?";
        return jt.update(sql, user.getUname(), user.getPassword(),
                user.getPhone(), user.getRole(), user.getDid(), user.getUid());
    }


    //删除成员方法
    public int deleteById(int uid) {
        String sql = "delete from user where uid=?";
        return jt.delete(sql, uid);
    }


    //部门成员统计
    public List<Map<String, Object>> statistics() {
        String sql = "select d.did,d.dname,count(u.uid) count from user u,department d where d.did=u.did group by d.dname";
        List<Map<String, Object>> list = jt.select(sql);
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

}
