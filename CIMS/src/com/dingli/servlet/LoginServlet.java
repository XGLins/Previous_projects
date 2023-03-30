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
 * 登录/退出
 * */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        // 乱码处理：字符集设置
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

//        response.getWriter().println("<h1>Servlet访问成功！</h1>");

        //获取session对象
        HttpSession session = request.getSession();

        //获取操作指令
        String action = request.getParameter("action");

        if (action.equals("login")){
            //登录成功
            //1.获取前端传来的数据
            String uid = request.getParameter("uid");
            String password = request.getParameter("password");

            //2.调用数据层
            User currentUser = userDAO.login(Integer.parseInt(uid),password);

            //3.判断
            if (currentUser == null){
                //登录失败：返回登录页，提示失败原因
                request.setAttribute("message","登陆失败！账号密码有误或无权进行操作！");
                request.getRequestDispatcher("./jsp/login.jsp").forward(request,response);

            }else {
                //登录成功，跳向操作页
                session.setAttribute("currentUser",currentUser);
                request.getRequestDispatcher("./jsp/index.jsp").forward(request,response);
            }
        }


        //我们可在LoginServlet.do中添加action=index的分支对跳转首页操作进行处理
        if (action.equals("login")){

        }else if (action.equals("index")){

            request.getRequestDispatcher("./jsp/index.jsp").forward(request,response);

        }else if (action.equals("exit")){
            //退出系统
            session.removeAttribute("currentUser");

            //页面跳转
            request.getRequestDispatcher("./jsp/login.jsp").forward(request,response);

        }


    }

}
