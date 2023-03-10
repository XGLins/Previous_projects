<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <title>银行卡信息列表</title>
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
                        <h1 class="col-md-4">银行卡信息管理</h1>
                        <div class="col-md-5" style="margin-top: 26px;">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入查询" name="search">
                                <span class="input-group-addon btn" id="sub"><input style="border: 0;" type="submit"
                                                                                    value="搜索"></span>
                            </div>
                        </div>
                        <button class="btn btn-success col-md-offset-1 col-md-2" style="margin-top: 26px"
                                onClick="location.href='CardServlet.do?action=goAdd'">
                            添加银行卡信息
                            <sapn class="glyphicon glyphicon-plus"/>
                        </button>
                    </div>
                </div>
                <table class="table table-bordered table-striped table-hover" style="text-align: center;">
                    <thead>
                    <tr>
                        <th>卡号</th>
                        <th>卡类型</th>
                        <th>余额</th>
                        <th>开卡时间</th>
                        <th>持有者</th>
                        <th>操作</th>
                    </tr>
                    </thead>


                    <tbody>
                    <c:forEach items="${cardList}" var="card">
                    <tr>
                        <td>${card.cid}
                        <td>${card.type}</td>
                        <td>${card.account}</td>
                        <td>
                            <fmt:formatDate value="${card.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/>
                        </td>
                        <td>${card.user.uname}</td>
                        <td>
                            <button class="btn btn-xs btn-danger"
                                    onClick="deleteById(${card.cid})">销卡
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
            var message = "${message}";
            if (message != "") {
                alert(message);
            }
        </script>

    <script>
        $("#nav a:nth-child(3)").addClass("active");
    </script>

        <%--新增功能--%>
        <script>
            function deleteById(cid) {
                if (confirm("是否确认删除该银行卡信息?")) {
                    location.href = "CardServlet.do?action=delete&cid=" + cid;
                }
            }
        </script>
</body>

</html>