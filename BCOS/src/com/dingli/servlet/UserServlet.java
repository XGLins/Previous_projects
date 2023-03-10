package com.dingli.servlet;

import com.dingli.dao.UserDAO;
import com.dingli.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 账户管理
 *
 * */
@WebServlet("/UserServlet.do")
public class UserServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        //获取操作指令
        String action = request.getParameter("action");
        if (action.equals("index")) {
            //跳转操作首页
            request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
        }else if (action.equals("show")) {
            //列表查询跳转
            String search = request.getParameter("search");
            List<User> userList = userDAO.list(search);
            request.setAttribute("search", search);
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("./jsp/showUser.jsp").forward(request, response);
        }else if (action.equals("goAdd")) {
            request.getRequestDispatcher("./jsp/addUser.jsp").forward(request,
                    response);
        }else if (action.equals("add")) {
            //用户新增
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String idcard = request.getParameter("idcard");
            String role = request.getParameter("role");
            //封装对象
            User user = new User(0, uname, password, phone, idcard, new Date(),
                    Integer.parseInt(role));

            int count = userDAO.insert(user);
            if (count > 0) {
                request.setAttribute("message", "新增用户成功！");
            } else {
                request.setAttribute("message", "新增用户失败！");
            }
            request.getRequestDispatcher("./UserServlet.do?action=show").forward(request, response);
        }else if (action.equals("goEdit")) {
            //跳向修改界面
            String uid = request.getParameter("uid");
            User user = userDAO.selectById(Integer.parseInt(uid));
            request.setAttribute("user", user);
            request.getRequestDispatcher("./jsp/editUser.jsp").forward(request,
                    response);
        }else if (action.equals("update")) {
            //修改用户信息
            String uid = request.getParameter("uid");
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String idcard = request.getParameter("idcard");
            String role = request.getParameter("role");

            User user = new User(Integer.parseInt(uid), uname, password, phone, idcard, null, Integer.parseInt(role));

            int count = userDAO.updateById(user);
            if (count > 0) {
                request.setAttribute("message", "修改用户信息成功！");
            } else {
                request.setAttribute("message", "修改用户信息失败！");
            }
            request.getRequestDispatcher("./UserServlet.do?action=show").forward(request,
                    response);
        }else if (action.equals("delete")) {
            //删除成员
            String uid = request.getParameter("uid");
            int count = userDAO.deleteById(Integer.parseInt(uid));
            if (count > 0) {
                request.setAttribute("message", "删除用户信息成功！");
            } else {
                request.setAttribute("message", "删除用户信息失败！");
            }
            request.getRequestDispatcher("./UserServlet.do?action=show").forward(request,
                    response);
        }


    }
}
