package com.xing.mapper;


import com.xing.domain.Staff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StaffMapper {

    //查询表中所有用户
    List<Staff> findAllStaff();

    //增加员工信息（员工入职）
    int addStaff(Staff staff);

    // 删除员工信息（根据员工的编号，操作员工离职）
    int deleteStaff(int id);

    // 根据员工姓名查找员工信息
    Staff findStaffByName(String employeeName);
    //修改员工信息
    int updateEmployeeByName(Staff staff);

    //根据员工id查询员工信息
    Staff findStaffById(int employeeId);





    //使用map集合传递参数
    int addMap(Map<String,Object> map);


    //模糊查询
    List<Staff> findStaffLikeName(String name);

    //分页查询
    List<Staff> getStaffByLimit(Map<String,Object> map);

}
