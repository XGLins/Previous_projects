<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/9/25
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>新增设备信息</title>
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
                        <h1 style="text-align: center;">添加设备信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="EquipmentServlet.do?action=add" method="post">
                        <div class="form-group">
                            <label for="ename" class="col-sm-2 control-label">设备名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="ename" name="ename"
                                       required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="edescribe" class="col-sm-2 control-label">设备描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="edescribe" name="edescribe"
                                       required>
                            </div>
                        </div>




                        <div class="form-group">
                            <label for="edescribe" class="col-sm-2 control-label">所属部门</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="edname" name="edname"
                                       required>
                            </div>
                        </div>

<%--                        <div class="form-group">--%>
<%--                            <label for="edname" class="">所属部门</label>--%>
<%--                            <select id="edname" name="edname" class="form-control">--%>
<%--                                <c:forEach items="${dptList}" var="dpt">--%>
<%--                                    <option value="${dpt.did}">${dpt.dname}</option>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>

<%--                        </div>--%>





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
    $("#nav li:nth-child(5)").addClass("active");
</script>
</body>

</html>
