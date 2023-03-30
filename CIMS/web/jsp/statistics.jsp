<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/9/1
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <title>成员统计</title>
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="./js/jquery-3.2.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <style>
        th {
            text-align: center;
        }
    </style>
</head>

<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"/>
<!-- 中间主体 -->
<div class="container">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-4 col-md-offset-4">部门成员统计</h1>
                    </div>
                </div>
                <table class="table table-bordered table-striped table-hover" style="text-align: center;">
                    <thead>
                    <tr>
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>成员数量</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${result}" var="map">
                        <tr>
                            <td>${map.did}</td>
                            <td>${map.dname}</td>
                            <td>${map.count}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                <div class="panel-footer">
                </div>
            </div>
        </div>
    </div>
</div>

<%--<script>--%>
<%--    $("#nav li:nth-child(3)").addClass("active");--%>
<%--    function deleteById(id) {--%>
<%--        if (confirm("删除该用户会同时删除已选课程，确定删除吗？") == true) {--%>
<%--            location.href = "javascript:void(0)";--%>
<%--        } else {--%>
<%--            return false;--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

<script>
    $("#nav li:nth-child(4)").addClass("active");
</script>

</body>

</html>

