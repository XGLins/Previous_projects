package com.dingli.filter;

import javax.servlet.*;
import java.io.IOException;

public class CEF implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse
            servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置字符集
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html");

        //将请求转发给过滤器链下一个filter
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
