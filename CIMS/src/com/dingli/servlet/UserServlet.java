package com.dingli.servlet;

import com.dingli.dao.DepartmentDAO;
import com.dingli.dao.UserDAO;
import com.dingli.entity.Department;
import com.dingli.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 * */
@WebServlet("/UserServlet.do")
public class UserServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();
    private DepartmentDAO dptDAO = new DepartmentDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        //乱码处理，字符集设置
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
        if (action.equals("show")){
            //成员列表展示
            List<User> userList = userDAO.selectAll();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("./jsp/showUser.jsp").forward(request,response);
        }else if (action.equals("goAdd")){
            //跳转新增用户界面
            List<Department> dptList = dptDAO.selectAll();
            request.setAttribute("dptList", dptList);
            request.getRequestDispatcher("./jsp/addUser.jsp").forward(request,response);
        }else if (action.equals("add")){
            //成员新增
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String role = request.getParameter("role");
            String did = request.getParameter("did");
            User user = new User(0, uname, password, phone, Integer.parseInt(role),
                    Integer.parseInt(did));
            int count = userDAO.insert(user);
            if (count > 0) {
                request.setAttribute("message", "新增成员成功！");

//                System.out.println("测试通过……");

            } else {
                request.setAttribute("message", "新增成员失败！");
//                System.out.println("测试未通过……");
            }

            request.getRequestDispatcher("./UserServlet.do?action=show").forward(request,response);
        }else if (action.equals("goEdit")){
            //跳向修改界面
            String uid = request.getParameter("uid");
            User user = userDAO.selectById(Integer.parseInt(uid));
            request.setAttribute("user", user);
            List<Department> dptList = dptDAO.selectAll();
            request.setAttribute("dptList", dptList);
            request.getRequestDispatcher("./jsp/editUser.jsp").forward(request, response);
        }else if (action.equals("update")) {
            //修改成员信息
            String uid = request.getParameter("uid");
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String role = request.getParameter("role");
            String did = request.getParameter("did");
            User user = new User(Integer.parseInt(uid),
                    uname, password, phone, Integer.parseInt(role),
                    Integer.parseInt(did));

            //判断操作是否成功，带着提示信息，将界面转至showUser.jsp
            int count = userDAO.updateById(user);
            if (count > 0) {
                request.setAttribute("message", "修改成员成功！");
            } else {
                request.setAttribute("message", "修改成员失败！");
            }
            request.getRequestDispatcher("./UserServlet.do?action=show").forward(request, response);
        }else if (action.equals("delete")) {
            //删除成员
            String uid = request.getParameter("uid");
            int count = userDAO.deleteById(Integer.parseInt(uid));

            if (count > 0) {
                request.setAttribute("message", "删除成员成功！");
            } else {
                request.setAttribute("message", "删除成员失败！");
            }
            request.getRequestDispatcher("./UserServlet.do?action=show").forward(request, response);
        }else if (action.equals("statistics")) {
        //部门成员数据统计
            List<Map<String, Object>> result = userDAO.statistics();

            //页面跳转
            request.setAttribute("result",result);
            request.getRequestDispatcher("./jsp/statistics.jsp").forward(request,
                    response);
        }


    }
}
