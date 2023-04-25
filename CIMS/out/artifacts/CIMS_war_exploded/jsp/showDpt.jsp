<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/8/29
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>

<head>
    <title>部门管理</title>
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
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
                        <h1 class="col-md-4">部门信息管理</h1>
                        <div class="col-md-5" style="margin-top: 26px;">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入查询" name="search">
                                <span class="input-group-addon btn" id="sub"><input style="border: 0;" type="submit"
                                                                                    value="搜索"></span>
                            </div>
                        </div>
                        <button class="btn btn-success col-md-offset-1 col-md-2" style="margin-top: 26px"
                                onClick="location.href='DepartmentServlet.do?action=goAdd'">
                            添加部门信息
                            <sapn class="glyphicon glyphicon-plus" />
                        </button>
                    </div>
                </div>
                <table class="table table-bordered table-striped table-hover" style="text-align: center;">
                    <thead>
                    <tr>
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>部门描述</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items = "${dptList}" var="dpt">
                    <tr>
                        <td>${dpt.did}</td>
                        <td>${dpt.dname}</td>
                        <td>${dpt.info}</td>
                        <td>
                            <button class="btn btn-default btn-xs btn-info"
                                    onClick="location.href='DepartmentServlet.do?action=goEdit&did=${dpt.did}'">修改
                            </button>
                            <button class="btn btn-default btn-xs btn-danger" onClick="deleteById(${dpt.did})">删除</button>
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
    $("#nav li:nth-child(2)").addClass("active");
    // function deleteById(id) {
    //     if (confirm("删除该用户会同时删除已选课程，确定删除吗？") == true) {
    //         location.href = "javascript:void(0)";
    //     } else {
    //         return false;
    //     }
    // }
</script>

<script>
    var message = "${message}";
    if (message != ""){
        alert(message);
    }
</script>

<%--删除确认--%>
<script>
    function deleteById(did) {
        if (confirm("确认删除该部门信息吗？")) {
            //当确认删除时再进行下一步操作
            //错哒
            // location.href = "DepartmentServlet.do?action=delete?did=" + did;

            //对哒
            location.href = "DepartmentServlet.do?action=delete&did=" + did;
        }
    }
</script>

</body>

</html>