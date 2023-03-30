<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/8/31
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <title>操作首页</title>
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="./js/jquery-3.2.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
</head>

<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"/>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">添加成员信息</h1>
                    </div>
                </div>
                <div class="panel-body">

                    <form class="form-horizontal" role="form" action="UserServlet.do?action=add"
                          method="post">
                        <div class="form-group">
                            <label for="uname" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="uname" name="uname"
                                       placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="password"
                                       name="password"
                                       placeholder="请输入密码" value="123456">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">电话</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone" name="phone"
                                       placeholder="请输入电话号码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="role" class="col-sm-2 control-label">角色</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="role" id="role">
                                    <option value="0">管理员</option>
                                    <option value="1" selected>普通成员</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="did" class="control-label">所属部门</label>
                            <select id="did" name="did" class="form-control">
                                <c:forEach items="${dptList}" var="dpt">
                                    <option value="${dpt.did}">${dpt.dname}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset">重置</button>
                        </div>
                    </form>

                </div>

            </div>
        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>

<script>
    $("#nav li:nth-child(3)").addClass("active");
</script>

</body>

</html>


