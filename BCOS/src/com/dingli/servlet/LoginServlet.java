package com.dingli.servlet;

import com.dingli.dao.UserDAO;
import com.dingli.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录/注销
 * */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
//        response.getWriter().println("<h1>LoginServlet访问成功！</h1>");

        //获取session对象
        HttpSession session = request.getSession();


        //获取操作指令
        String action = request.getParameter("action");
        if (action.equals("login")) {
            //登录操作分支
            String uid = request.getParameter("uid");
            String password = request.getParameter("password");
            //调用数据层
            User currentUser = userDAO.login(Integer.parseInt(uid), password);

            if (currentUser == null) {
                //登录失败：返回登录页，提示失败原因
                request.setAttribute("message", "登录失败！账号密码有误或无权限进行操作！");
                request.getRequestDispatcher("./jsp/login.jsp").forward(request,
                        response);
            } else {
                //登录成功，跳向操作首页
                session.setAttribute("currentUser", currentUser);
                request.getRequestDispatcher("./jsp/index.jsp").forward(request,
                        response);
            }
        }else if (action.equals("exit")) {
            session.removeAttribute("currentUser");
            request.setAttribute("message", "退出登录成功！");
            request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
        }

    }

}
