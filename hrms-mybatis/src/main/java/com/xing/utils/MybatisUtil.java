package com.xing.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*mybatis工具类*/
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*知识点回顾：
     * 空指针异常：当一个对象为null时，又调用了方法，就会出现
     * */
    /*定义一个方法，用来获取sqlSession*/
    /*用static修饰的方法：可以直接使用 “类名.方法名” 直接调用*/
    public static SqlSession getSqlSession(){
        //调用方法
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}

