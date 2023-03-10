package com.xing.domain;

import com.xing.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    /**
     * 查询管理员（返回布尔值）
     * */
    @Test
    public void findUserById(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        User userById = userMapper.findUserById("admin","123456");
        if (userById.getUserName().equals("admin") || userById.getPassWord().equals("123456")){
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败");
        }

    }



}
