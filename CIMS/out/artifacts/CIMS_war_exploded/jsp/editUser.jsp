<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/9/1
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>

<head>
    <title>操作首页</title>
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
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
                        <h1 style="text-align: center;">修改学生信息</h1>
                    </div>
                </div>
                <div class="panel-body">

                    <form class="form-horizontal" role="form" action="UserServlet.do?action=update"
                          method="post">
                        <div class="form-group">
                            <label for="uid" class="col-sm-2 control-label">账号</label>
                            <div class="col-sm-10">
                                <input readonly type="text" class="form-control" id="uid" name="uid"
                                       value="${user.uid}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="uname" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="uname" name="uname"
                                       placeholder="请输入姓名"
                                       value="${user.uname}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="password"
                                       name="password"
                                       placeholder="请输入密码"
                                       value="${user.password}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">电话</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone" name="phone"
                                       placeholder="请输入电话号码" value="${user.phone}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="role" class="col-sm-2 control-label">角色</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="role" id="role">
                                    <option value="0" <c:if test="${user.role==0}">selected</c:if>>管
                                        理员</option>
                                    <option value="1" <c:if test="${user.role!=0}">selected</c:if>>普
                                        通成员</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="did" class="col-sm-2 control-label">所属部门</label>
                            <div class="col-sm-10">
                                <select id="did" name="did" class="form-control">
                                    <c:forEach items="${dptList}" var="dpt">
                                        <option value="${dpt.did}" <c:if
                                                test="${user.did==dpt.did}">selected</c:if>>
                                                ${dpt.dname}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
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
    $("#nav li:nth-child(2)").addClass("active");
</script>
</body>

</html>





