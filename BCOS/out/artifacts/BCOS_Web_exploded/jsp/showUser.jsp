<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>用户信息管理</title>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
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
<div class="container-fluid">
    <%--导航栏--%>
    <jsp:include page="menu.jsp"/>

    <div class="col-md-10">
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-4">用户信息管理</h1>
                        <div class="col-md-5" style="margin-top: 26px;">
                            <div class="input-group">
                                <input id="search" value="${search}" type="text" class="form-control" placeholder="请输入查询" name="search">
                                <span id="searchBtn" class="input-group-addon btn" ><input style="border: 0;" type="submit"
                                                                                    value="搜索"></span>
                            </div>
                        </div>
                        <button class="btn btn-success col-md-offset-1 col-md-2" style="margin-top: 26px"
                                onClick="location.href='UserServlet.do?action=goAdd'">
                            添加用户信息
                            <sapn class="glyphicon glyphicon-plus"/>
                        </button>
                    </div>
                </div>
                <table class="table table-bordered table-striped table-hover" style="text-align: center;">
                    <thead>
                    <tr>
                        <th>账号</th>
                        <th>姓名</th>
                        <th>电话</th>
                        <th>身份证号</th>
                        <th>注册时间</th>
                        <th>角色</th>
                        <th>操作</th>
                    </tr>
                    </thead>


                    <tbody>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.uid}</td>
                            <td>${user.uname}</td>
                            <td>${user.phone}</td>
                            <td>${user.idcard}</td>
                            <td>
                                <fmt:formatDate value="${user.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/>
                            </td>
                            <td>
                                <c:if test="${user.role==0}">管理员</c:if>
                                <c:if test="${user.role==1}">普通用户</c:if>
                            </td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='UserServlet.do?action=goEdit&uid=${user.uid}'">修改</button>
                                <button class="btn btn-default btn-xs btn-danger"
                                        onClick="deleteById(${user.uid});">删除
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>


                </table>
                <div class="panel-footer">
                </div>
            </div>
        </div>
    </div>

    <script>
        $("#nav a:nth-child(2)").addClass("active");
    </script>

    <%--添加功能01--%>
    <script>
         $("#searchBtn").click(function () {
             location.href = "UserServlet.do?action=show&search=" +
                 $("#search").val();
         });
     </script>

     <script>
         var message = "${message}";
            if (message != "") {
                alert(message);
         }
     </script>

     <%--添加功能03--%>
     <script>
         function deleteById(uid) {
            if (confirm("是否确认删除该用户信息?")) {
                    location.href = "UserServlet.do?action=delete&uid=" + uid;
            }
         }
     </script>

</body>

</html>