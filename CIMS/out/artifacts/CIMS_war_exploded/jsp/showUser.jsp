<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/8/31
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<html>

<head>
    <title>成员管理</title>
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
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
                        <h1 class="col-md-4">成员信息管理</h1>
                        <div class="col-md-5" style="margin-top: 26px;">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入查询" name="search">
                                <span class="input-group-addon btn" id="sub"><input style="border: 0;" type="submit"
                                                                                    value="搜索"></span>
                            </div>
                        </div>
                        <button class="btn btn-success col-md-offset-1 col-md-2" style="margin-top: 26px"
                                onClick="location.href='UserServlet.do?action=goAdd'">
                            添加成员信息
                            <sapn class="glyphicon glyphicon-plus" />
                        </button>
                    </div>
                </div>
                <table class="table table-bordered table-striped table-hover" style="text-align: center;">
                    <thead>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>电话</th>
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
                            <td>
                                <c:if test="${user.role==0}">管理员</c:if>
                                <c:if test="${user.role!=0}">成员</c:if>
                            </td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='UserServlet.do?action=goEdit&uid=${user.uid}'">修
                                    改</button>
                                <button class="btn btn-default btn-xs btn-danger"
                                        onClick="deleteById(${user.uid})">删除</button>
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
</div>

<script>
    var message = "${message}";
    if (message != "") {
        alert(message);
    }
    $("#nav li:nth-child(3)").addClass("active");
</script>


<%--删除确认提示--%>
<script>
    function deleteById(uid) {
        if (confirm("确认删除该成员信息吗？")) {
//当确认删除时再进行下一步操作
            location.href = "UserServlet.do?action=delete&uid=" + uid;
        }
    }
</script>

</body>

</html>