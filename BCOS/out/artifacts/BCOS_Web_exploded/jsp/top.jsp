<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 顶栏 -->
<div class="container-fluid" id="top">
  <nav class="navbar navbar-default">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-
              toggle="collapse" data-target="#nav"
              aria-expanded="false">
        <span class="sr-only"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a style="font-weight: bold;" class="navbar-brand" href="UserServlet.do?action=index">银行柜台作
        业系统<small>——你好，${currentUser.uname}！</small></a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-envelope">
</span>&nbsp;消息</a></li>
        <li><a href="LoginServlet.do?action=exit"><span class="glyphicon glyphicon-log-in">
</span>&nbsp;退出系统</a></li>
      </ul>
    </div>
  </nav>
</div>
