<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/8/30
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>

<head>
    <title>部门信息修改</title>
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
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
                        <h1 style="text-align: center;">修改学生信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="DepartmentServlet.do?
action=update" method="post">
                        <div class="form-group">
                            <label for="did" class="col-sm-2 control-label">部门编号</label>
                            <div class="col-sm-10">
                                <input readonly type="number" class="form-control" id="did" name="did"
                                            value="${Dpt.did}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dname" class="col-sm-2 control-label">部门名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="dname" name="dname"
                                       placeholder="请输入部门名称" value="${Dpt.dname}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="info" class="col-sm-2 control-label">部门描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="info" name="info"
                                       placeholder="请输入部门描述" value="${Dpt.info}">
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
