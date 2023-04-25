<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/17
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <title>操作首页</title>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <script src="./js/jquery-3.2.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
</head>

<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"/>
<!-- 中间主体 -->
<div class="container-fluid">
    <%--导航栏--%>
    <jsp:include page="menu.jsp"/>
    <%--主体图片--%>
    <div class="col-md-10">
        <div style="text-align: center;">
            <img src="./images/bc.jpg" width="80%" alt="操作首页图片">
        </div>
    </div>
</div>

    <script>
        $("#nav a:nth-child(1)").addClass("active");
    </script>
</body>

</html>