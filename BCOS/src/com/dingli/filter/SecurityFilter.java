package com.dingli.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse
            servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        //判断是否登录
        if (session.getAttribute("currentUser") == null) {
            request.setAttribute("message", "请登录后操作！");
            request.getRequestDispatcher("./jsp/login.jsp").forward(request,
                    response);
        }
        filterChain.doFilter(request, response);
    }
}
