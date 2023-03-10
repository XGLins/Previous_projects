<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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

    <div class="col-md-10">
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">修改用户信息</h1>
                    </div>
                </div>
                <div class="panel-body">



                    <form class="form-horizontal" role="form" action="UserServlet.do?action=update"
                          method="post">
                        <div class="form-group">
                            <label for="uid" class="col-sm-2 control-label">账号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" id="uid"
                                       name="uid" value="${user.uid}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="uname" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="uname" name="uname"
                                       value="${user.uname}"
                                       placeholder="请输入姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="password"
                                       name="password"
                                       placeholder="请输入密码" value="${user.password}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">电话</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone" name="phone"
                                       value="${user.phone}"
                                       placeholder="请输入电话号码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="idcard" class="col-sm-2 control-label">身份证号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="idcard" name="idcard"
                                       placeholder="请输入身份证号" value="${user.idcard}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="role" class="col-sm-2 control-label">角色</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="role" id="role">
                                    <option
                                            <c:if test="${user.role==0}">selected</c:if>  value="0">管理员
                                    </option>
                                    <option
                                            <c:if test="${user.role!=0}">selected</c:if> value="1"> 普通用户
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-success" type="submit">提交</button>
                            <button class="btn btn-warning" type="reset">重置</button>
                        </div>
                    </form>




                </div>

            </div>
        </div>
    </div>

    <script>
        $("#nav a:nth-child(2)").addClass("active");
    </script>
</body>

</html>
