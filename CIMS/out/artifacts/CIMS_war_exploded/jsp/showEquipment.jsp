<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/9/2
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>

<%--显示设备管理--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<head>
    <title>设备管理</title>
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
                        <h1 class="col-md-4">设备信息管理</h1>
                        <div class="col-md-5" style="margin-top: 26px;">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入查询" name="search">
                                <span class="input-group-addon btn" id="sub"><input style="border: 0;" type="submit"
                                                                                    value="搜索"></span>
                            </div>
                        </div>
                        <button class="btn btn-success col-md-offset-1 col-md-2" style="margin-top: 26px"
                                onClick="location.href='EquipmentServlet.do?action=goAdd'">
                            添加设备信息
                            <sapn class="glyphicon glyphicon-plus" />
                        </button>
                    </div>
                </div>
                <table class="table table-bordered table-striped table-hover" style="text-align: center;">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>设备名称</th>
                        <th>设备描述</th>
                        <th>所属部门</th>
                        <th>操作</th>
                    </tr>
                    </thead>


                    <tbody>
                    <c:forEach items = "${equipmentList}" var="epl">
                    <tr>
                        <td>${epl.eid}</td>
                        <td>${epl.ename}</td>
                        <td>${epl.edescribe}</td>
                        <td>${epl.edname}</td>
                        <td>
                            <button class="btn btn-default btn-xs btn-info" onClick="location.href='EquipmentServlet.do?action=update'">修改</button>
                            <button class="btn btn-default btn-xs btn-danger"
                                    onClick="void(0)">删除</button>
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
    $("#nav li:nth-child(5)").addClass("active");

</script>

<script>
    var message = "${message}";
    if (message != "") {
        alert(message);
    }
</script>

</body>

</html>


