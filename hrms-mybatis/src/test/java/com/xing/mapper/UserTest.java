package com.xing.mapper;

import com.xing.domain.User;
import com.xing.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {

    /**
     * 查询管理员（返回布尔值）
     * */
    @Test
    public void findUserById(){
        //获取sqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过sqlSession得到接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User userById = userMapper.findUserById("admin","123456");
        if (userById.getUserName().equals("admin") || userById.getPassWord().equals("123456")){
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败");
        }

    }



}
