package com.xing.mapper;


import com.xing.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //查找管理员
    User findUserById(@Param("userName") String userName , @Param("passWord") String passWord);

}
