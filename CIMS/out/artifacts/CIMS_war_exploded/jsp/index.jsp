<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/8/24
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>操作首页</title>
  <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
  <script src="./js/jquery-3.2.1.min.js"></script>
  <script src="./js/bootstrap.min.js"></script>
</head>
<body>
<!-- 动态包含：顶栏 -->
<jsp:include page="top.jsp"/>
<div class="container" id="content">
  <div class="row">
    <!-- 动态包含：导航栏 -->
    <jsp:include page="menu.jsp"/>
    <div class="col-md-10">
      <img src="./images/bc2.jpg" width="100%" alt="操作首页图片">
    </div>
  </div>
</div>
<div class="container" id="footer">
  <div class="row">
    <div class="col-md-12"></div>
  </div>
</div>
<script>
  $("#nav li:nth-child(1)").addClass("active");
</script>
</body>
</html>
