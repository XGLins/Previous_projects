package com.xing.domain;

import com.xing.mapper.StaffMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class StaffTest {

    /**
     * 添加员工信息（员工入职）
     * */
    @Test
    public void addStaff(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StaffMapper staff = context.getBean("staffMapper", StaffMapper.class);

        Staff staff1 = new Staff(0,"孙策","总裁办","总裁助理");

        int i = staff.addStaff(staff1);
        if (i>0){
            System.out.println("新增员工成功！");
        }else{
            System.out.println("新增员工失败！");
        }
    }

    /**
     *删除员工信息（根据员工的编号，操作员工离职）
     * */
    @Test
    public void deleteStaffById(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StaffMapper staff = context.getBean("staffMapper", StaffMapper.class);

        int i = staff.deleteStaff(117);
        if (i>0){
            System.out.println("删除员工成功！");
        }else {
            System.out.println("删除员工失败！");
        }
    }

    /**
     * 根据id修改员工信息
     * */
    @Test
    public void updateEmployeeById(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StaffMapper staff = context.getBean("staffMapper", StaffMapper.class);

        Staff staff1 = new Staff(118,"孙策","开发部","web工程师");

        int i = staff.updateEmployeeById(staff1);
        if (i>0){
            System.out.println("修改用户成功！");
        }else{
            System.out.println("修改用户失败！");
        }
    }

    /**
     * 查询所有员工信息
     * */
    @Test
    public void findAllStaff(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StaffMapper staff = context.getBean("staffMapper", StaffMapper.class);
        List<Staff> allStaff = staff.findAllStaff();
        allStaff.forEach(System.out::println);
    }

    /**
     * 根据id查询员工
     * */
    @Test
    public void findStaffById(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StaffMapper staff = context.getBean("staffMapper", StaffMapper.class);

        Staff staffById = staff.findStaffById(114);
        System.out.println(staffById);
    }

    /**
     * 分页查询
     * */
    @Test
    public void getStaffByLimit(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StaffMapper staff = context.getBean("staffMapper", StaffMapper.class);

        //map集合
        HashMap<String , Object> map = new HashMap<String , Object>();
        map.put("startIndex",0);
        map.put("pageSize",2);

        List<Staff> staffByLimit = staff.getStaffByLimit(map);
        staffByLimit.forEach(System.out::println);
    }

}
