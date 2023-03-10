<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>查询业务</title>
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
                        <h1 style="text-align: center;">查询业务</h1>
                    </div>
                </div>

                <div class="panel-body">
                    <!-- 原form表单删除 -->
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3" style="margin-top: 30px;">
                            <div class="input-group">
                                <input id="cid" placeholder="请输入卡号" type="text" class="form-control">
                                <span id="queryBtn" class="input-group-addon btn">查询</span>
                            </div>
                            <div id="msg" style="margin: 100px auto;text-align: center;font-size: 24px;">
                                <!-- 查询结果显示 -->
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

    <script>
        $("#nav a:nth-child(4)").addClass("active");
    </script>

    <%--功能新增--%>
    <script>
        $("#queryBtn").click(function () {
            var cid = $("#cid").val();
            $.get("./CommonServlet.do?action=query&cid=" + cid, function (result) {
                $("#msg").html(result);
            });
        });
    </script>
</body>

</html>
