package com.xing.mapper;

import com.xing.domain.Staff;
import com.xing.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestStaffOne {

    /**
     * 添加员工信息（员工入职）
     * */
    @Test
    public void addStaff(){
        //获取sqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过sqlSession得到接口
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);

        Staff staff1 = new Staff(null, "小花", "开发部", "Java工程师");
        int i = staffMapper.addStaff(staff1);
        if (i>0){
            System.out.println("欢迎员工：" + staff1.getEmployeeName() + " 入职！");
        }else{
            System.out.println("录入员工信息失败！");
        }
    }

    /**
     *删除员工信息（根据员工的编号，操作员工离职）
     * */
    @Test
    public void deleteStaffById(){
        //获取sqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过sqlSession得到接口
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);

        Staff staff = new Staff();

        //输入你所要删除员工的员工编号
        int i = staffMapper.deleteStaff(128);
        if (i>0){
            System.out.println("删除操作成功");
        }else{
            System.out.println("删除操作失败，请重试！");
        }
    }


    /**
     * 先通过员工姓名查找出该员工信息，再进行修改员工信息
     * */
    @Test
    public void findStaffByName(){
        //获取sqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过sqlSession得到接口
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);

        //输入你查询修改员工的姓名
        Staff staffByName = staffMapper.findStaffByName("小明");
        System.out.println("员工编号：" + staffByName.getEmployeeId());
        System.out.println("员工姓名：" + staffByName.getEmployeeName());
        System.out.println("员工部门：" + staffByName.getDepartment());
        System.out.println("员工职位：" + staffByName.getPosition());

        System.out.println("->->->");

        Staff staff = new Staff(0,"小明","aaa","bbb");

        int i = staffMapper.updateEmployeeByName(staff);
        if (i>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    /**
     * 查询所有员工信息
     * */
    @Test
    public void findAllStaff(){
        //获取sqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过sqlSession得到接口
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);

        List<Staff> allStaff = staffMapper.findAllStaff();
        //遍历输出
        allStaff.forEach(System.out::println);
    }

    /**
     * 根据员工id查询员工信息
     * */
    @Test
    public void findStaffById() {
        //获取sqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过sqlSession得到接口
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);

        Staff staffById = staffMapper.findStaffById(118);
        System.out.println(staffById);

    }

}
