package com.xing.mapper;


import com.xing.domain.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository//把对象交给spring容器管理
public interface StaffMapper {

    //增加员工信息（员工入职）
    int addStaff(Staff staff);

    // 删除员工信息（根据员工的编号，操作员工离职）
    int deleteStaff(int id);

    //修改员工信息
    int updateEmployeeById(Staff staff);

    //查询表中所有用户
    List<Staff> findAllStaff();

    // 根据员工id查找员工信息
    Staff findStaffById(int employeeId);

    // 根据员工name查找员工信息
    Staff findStaffByName(String employeeName);

    //分页查询
    List<Staff> getStaffByLimit(Map<String,Object> map);

    //使用map集合传递参数
    int addMap(Map<String,Object> map);

    //模糊查询
    List<Staff> findStaffLikeName(String name);



}
