<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>常规业务办理</title>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <script src="./js/jquery-3.2.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>

    <style>
        .row>div {
            margin-top: 50px;
            height: 100px;
            line-height: 90px;
            font-family: "微软雅黑";
            font-size: 21px;
            color: rgb(58, 54, 54);
        }
    </style>
</head>

<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"/>
<!-- 中间主体 -->
<div class="container-fluid">
    <%--导航栏--%>
    <jsp:include page="menu.jsp"/>

    <div class="col-md-10">
        <div class="row">
            <div onclick="location.href='CommonServlet.do?action=goQuery'" class="btn col-sm-4 col-sm-offset-1 bg-danger">
                查询业务
            </div>
            <div onclick="location.href='CommonServlet.do?action=goSave'" class="btn col-sm-4 col-sm-offset-1 bg-success">
                存款操作
            </div>
            <div onclick="location.href='CommonServlet.do?action=goGet'" class="btn col-md-4 col-md-offset-1 bg-warning">
                取款业务
            </div>
            <div onclick="location.href='CommonServlet.do?action=goTransfer'" class="btn col-md-4 col-md-offset-1 bg-info" onclick="location.href='./business.html'">
                转账业务
            </div>
        </div>
    </div>

    <script>
        $("#nav a:nth-child(4)").addClass("active");
    </script>
</body>

</html>