package com.xing.app;

import com.xing.domain.Staff;
import com.xing.domain.User;
import com.xing.mapper.StaffMapper;
import com.xing.mapper.UserMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * 开始编写“人力资源管理系统”
 * */
public class HrmsApp {
    static String banner = "************欢迎来到人力资源管理系统************";

    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    static StaffMapper staffMapper = context.getBean("staffMapper", StaffMapper.class);
    static UserMapper userMapper = context.getBean("userMapper", UserMapper.class);


    /**
     * 程序入口
     * */
    public static void main(String[] args) {
        //通过键盘的方式输入
        Scanner in = new Scanner(System.in);

        //登录验证
        login();

        while (true) {
            //提示语（进入系统）
            System.out.println(banner);
            //功能列表
            System.out.println("请选择您的操作：");
            //1.员工入职；
            System.out.println("1.员工入职；");
            //2.员工离职；
            System.out.println("2.员工离职；");
            //3.修改员工信息；
            System.out.println("3.修改员工信息；");
            //4.查询所有员工信息；
            System.out.println("4.查询所有员工信息；");
            //5.通过员工编号查询员工信息；
            System.out.println("5.通过员工编号查询员工信息；");
            //6.退出；
            System.out.println("6.退出；");

            System.out.print("选择您的操作为：");
            Integer num = in.nextInt();

            switch (num) {
                case 1:
                    //员工入职
                    addStaff();
                    break;
                case 2:
                    //员工离职
                    deleteStaffById();
                    break;
                case 3:
                    //修改员工信息
                    updateEmployeeById();
                    break;
                case 4:
                    //查询所有员工信息
                    findAllStaff();
                    break;
                case 5:
                    //通过员工编号查询员工信息
                    findStaffById();
                    break;
                case 6:
                    //退出
                    exitSystem();
                    break;
                default:
                    System.out.println("您输入的有误，请重试！");
                    break;
            }
        }
    }

    /**
     * 登录系统
     * */
    public static void login(){
//通过键盘的方式输入
        Scanner in = new Scanner(System.in);

        int count = 0;
        while (true) {
            //提示语（进入系统）
            System.out.println(banner);

            //请您输入管理员账号
            System.out.println("请您输入管理员账号");
            String username = in.nextLine();
            //请您输入管理员密码
            System.out.println("请您输入管理员密码");
            String passWord = in.nextLine();

            count++;
            if (count==3){
                System.out.println(banner);
                System.out.println("->->->->error:500:您输入的账号密码错误多次！请尝试打开程序重新登录！<-<-<-<");
                System.exit(1);
            }

            User userById = userMapper.findUserById(username, passWord);
            if (userById == null) {
                System.out.println("用户名或密码错误！");
            } else {
                System.out.println("登录成功");
                break;
            }
        }
    }

    /**
     * 员工入职
     * */
    public static void addStaff(){
        //通过键盘的方式输入
        Scanner in = new Scanner(System.in);

        //提示语（进入系统）
        System.out.println(banner);

        System.out.println("请输入员工的姓名：");
        String name = in.nextLine();
        System.out.println("请输入员工的部门：");
        String department = in.nextLine();
        System.out.println("请输入员工的职位：");
        String position = in.nextLine();

        Staff staff = new Staff(0,name,department,position);


        int i = staffMapper.addStaff(staff);

        //判断操作是否成功
        if (i>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    /**
     *员工离职（根据员工的编号，操作员工离职）
     * */
    public static void deleteStaffById(){
        //通过键盘的方式输入
        Scanner in = new Scanner(System.in);

        //提示语（进入系统）
        System.out.println(banner);
        System.out.println("请输入离职员工的编号：");
        Integer id = in.nextInt();
        int i = staffMapper.deleteStaff(id);

        //判断操作是否成功
        if (i>0){
            System.out.println("操作成功");
        }else {
            System.out.println("操作失败");
        }
    }

    /**
     * 修改员工信息(根据员工姓名修改员工信息)
     * */
    public static void updateEmployeeById(){
        //通过键盘的方式输入
        Scanner in = new Scanner(System.in);

        //提示语（进入系统）
        System.out.println(banner);
        System.out.println("请输入需要修改的员工姓名：");
        String name = in.nextLine();

        //根据员工姓名查找员工信息
        Staff staff = staffMapper.findStaffByName(name);

        System.out.println("员工详情信息为：");
        System.out.println("编号：" + staff.getEmployeeId());
        System.out.println("姓名：" + staff.getEmployeeName());
        System.out.println("部门：" + staff.getDepartment());
        System.out.println("职位：" + staff.getPosition());

        //输入修改后的员工信息
        System.out.println("请输入员工修改后的部门：");
        String department = in.nextLine();
        System.out.println("请输入员工修改后的职位：");
        String position = in.nextLine();

        Staff staff1 = new Staff(0,name,department,position);

        int i = staffMapper.updateEmployeeById(staff1);

        //判断操作是否成功
        if (i>0){
            System.out.println("修改成功");
            Staff staff2 = staffMapper.findStaffByName(name);

            System.out.println("员工详情信息为：");
            System.out.println("编号：" + staff2.getEmployeeId());
            System.out.println("姓名：" + staff2.getEmployeeName());
            System.out.println("部门：" + staff2.getDepartment());
            System.out.println("职位：" + staff2.getPosition());
        }else {
            System.out.println("修改失败");
        }
    }

    /**
     * 查询所有员工信息
     * */
    public static void findAllStaff(){
        //通过键盘的方式输入
        Scanner in = new Scanner(System.in);

        //提示语（进入系统）
        System.out.println(banner);
        System.out.println("所有员工信息为：");
        List<Staff> allStaff = staffMapper.findAllStaff();
        System.out.println("编号\t\t\t姓名\t\t\t部门\t\t\t职位");
        for (Staff staff : allStaff){
            System.out.println(staff.getEmployeeId() + "\t\t\t" + staff.getEmployeeName()
                    + "\t\t\t" + staff.getDepartment() + "\t\t" + staff.getPosition());
        }
    }

    /**
     * 根据id查询员工
     * */
    public static void findStaffById(){
        //通过键盘的方式输入
        Scanner in = new Scanner(System.in);

        //提示语（进入系统）
        System.out.println(banner);
        System.out.println("您要查询员工id为：");
        Integer id = in.nextInt();
        System.out.println("您要查询的员工编号为" + id + "：");

        Staff staffById = staffMapper.findStaffById(id);
        System.out.println("编号\t\t\t姓名\t\t\t部门\t\t\t职位");
        System.out.println(staffById.getEmployeeId() + "\t\t\t" + staffById.getEmployeeName()
                + "\t\t\t" + staffById.getDepartment() + "\t\t" + staffById.getPosition());

    }

    /**
     * 退出系统
     * */
    public static void exitSystem(){
        //提示语（进入系统）
        System.out.println(banner);
        System.out.println("您退出了系统，欢迎下次登录");
        System.exit(0);
    }
}
