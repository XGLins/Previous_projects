<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 导航栏 -->
<div id="nav" class="col-md-2 list-group" style="text-align:center">
    <a href="UserServlet.do?action=index" class="list-group-item">操作首页</a>
    <a href="UserServlet.do?action=show" class="list-group-item">账户管理</a>
    <a href="CardServlet.do?action=show" class="list-group-item">银行卡管理</a>
    <a href="CommonServlet.do?action=index" class="list-group-item">常规业务办理</a>
    <a href="LoginServlet.do?action=exit" class="list-group-item">退出系统</a>
</div>
