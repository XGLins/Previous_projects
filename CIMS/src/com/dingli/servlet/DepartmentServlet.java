package com.dingli.servlet;

import com.dingli.dao.DepartmentDAO;
import com.dingli.entity.Department;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 部门管理
 * */
@WebServlet("/DepartmentServlet.do")
public class DepartmentServlet extends HttpServlet {

    private DepartmentDAO dptDAO = new DepartmentDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //乱码处理：字符集设置
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");


        //安全拦截-退出过后禁止退回访问
        HttpSession session = request.getSession();
        if (session.getAttribute("currentUser") == null) {
            request.setAttribute("message", "请登录后再进行相应操作");
            request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
        }



        String action = request.getParameter("action");

        //控制台测试流程
        System.out.println(action);

        if (action.equals("show")) {
            //显示部门列表
            List<Department> dptList = dptDAO.selectAll();
            request.setAttribute("dptList", dptList);
            request.getRequestDispatcher("./jsp/showDpt.jsp").forward(request, response);
        }else if (action.equals("goAdd")){
            // 去往添加部门信息界面
            request.getRequestDispatcher("./jsp/addDpt.jsp").forward(request,response);
        }else if (action.equals("add")){
            //部门新增
            String dname = request.getParameter("dname");
            String info = request.getParameter("info");
            Department dpt = new Department(0,dname,info);
            int count = dptDAO.insert(dpt);
            if (count > 0){
                request.setAttribute("message","新增部门成功！");
            }else{
                request.setAttribute("message","新增部门失败！");
            }
            request.getRequestDispatcher("./DepartmentServlet.do?action=show").forward(request,response);
        }else if (action.equals("goEdit")){
            //跳转修改界面
            String did = request.getParameter("did");
            Department Dpt = dptDAO.selectById(Integer.parseInt(did));
            request.setAttribute("Dpt",Dpt);
            request.getRequestDispatcher("./jsp/editDpt.jsp").forward(request,response);
        }else if (action.equals("update")){
            //部门修改
            String did = request.getParameter("did");
            String dname = request.getParameter("dname");
            String info = request.getParameter("info");
            Department dpt = new Department(Integer.parseInt(did), dname, info);

            //数据层调用
            int count = dptDAO.updateById(dpt);
            if (count > 0) {
                request.setAttribute("message", "修改部门成功！");
            } else {
                request.setAttribute("message", "修改部门失败！");
            }
            request.getRequestDispatcher("./DepartmentServlet.do?action=show").forward(request, response);

        }else if (action.equals("delete")){
            //测试是执行以下语句
            System.out.println("调用了");
            //删除部门
            String did = request.getParameter("did");
            int count = dptDAO.deleteById(Integer.parseInt(did));
            if (count>0){
                request.setAttribute("message","删除部门成功！");
            }else{
                request.setAttribute("message","删除部门失败！");
            }
            request.getRequestDispatcher("./DepartmentServlet.do?action=show").forward(request,response);
        }
    }



}
