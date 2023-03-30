package com.dingli.util;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * JDBC工具类
 * */
public class JdbcTools {
    //1.全局变量的申明 类体中添加以下全局变量，包含数据库连接核心参数url、username、password，及jdbc核心参数
    private String url = "jdbc:mysql://localhost:3306/cims?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai";
    private String username = "root";
    private String password = "123456";

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;


    //2.构造函数的添加
    public JdbcTools() {
    }
    public JdbcTools(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    //3.加载驱动类
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //4.获取连接的方法
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    //5.添加执行查询核心方法
    public ResultSet executeQuery(String sql, Object... item) {
        try {
            ps = getConnection().prepareStatement(sql);
            for (int i = 0; i < item.length; i++) {
                ps.setObject(i + 1, item[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //6.添加资源关闭方法
    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //7.添加执行增删改核心方法
    public int executeUpdate(String sql, Object... item) {
        int count = 0;
        try {
            ps = getConnection().prepareStatement(sql);
            for (int i = 0; i < item.length; i++) {
                ps.setObject(i + 1, item[i]);
            }
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        close();
        return count;
    }


    //8.查询方法封装-将ResultSet集合转换为List<Map<String, Object>>形式，并在返回结果前关闭
    public List<Map<String, Object>> select(String sql, Object... item) {
        List<Map<String, Object>> result = new LinkedList<>();
        List<String> columnList = new LinkedList<>();
        try {
            ResultSet rs = executeQuery(sql, item);
            ResultSetMetaData md = rs.getMetaData();
            for (int i = 0; i < md.getColumnCount(); i++) {
                columnList.add(md.getColumnName(i + 1));
            }
            while (rs.next()) {
                Map<String, Object> map = new LinkedHashMap<>();
                for (String column : columnList) {
                    map.put(column.toLowerCase(), rs.getObject(column));
                }
                result.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        close();
        return result;
    }


    //9.增删改方法封装
    public int update(String sql, Object... item) {
        return executeUpdate(sql, item);
    }
    public int insert(String sql, Object... item) {
        return executeUpdate(sql, item);
    }
    public int delete(String sql, Object... item) {
        return executeUpdate(sql, item);
    }

    //10.测试
    public static void main(String[] args) {
        JdbcTools tools = new JdbcTools();
        List<Map<String, Object>> list = tools.select("select * from department");
                list.forEach(System.out::println);
    }


}
