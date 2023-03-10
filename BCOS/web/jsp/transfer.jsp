<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>转账业务</title>
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
                        <h1 style="text-align: center;">转账业务操作</h1>
                    </div>
                </div>
                <div class="panel-body">



                    <form class="form-horizontal" role="form" action="CommonServlet.do?action=transfer" method="post">
                        <div class="col-md-6" style="margin:30px auto;">
                            <div class="form-group">
                                <label for="cid1" class="col-sm-2 control-label">转账卡号</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="cid1" name="cid1"
                                           placeholder="请输入转账卡号">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="uname1" class="col-sm-2 control-label">转账人</label>
                                <div class="col-sm-10">
                                    <input readonly type="text" class="form-control" id="uname1"
                                           name="uname1">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="money" class="col-sm-2 control-label">转账金额</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="money" name="money"
                                           placeholder="请输入转账金额">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6" style="margin:30px auto;">
                            <div class="form-group">
                                <label for="cid2" class="col-sm-2 control-label">接受卡号</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="cid2" name="cid2"
                                           placeholder="请输入接受卡号">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="uname2" class="col-sm-2 control-label">接受人</label>
                                <div class="col-sm-10">
                                    <input readonly type="text" class="form-control" id="uname2"
                                           name="uname2">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="col" style="text-align: center">
                                <button class="btn btn-success" type="submit">确认</button>
                                <button class="btn btn-warning" type="reset">重置</button>
                            </div>
                        </div>
                    </form>




                </div>
            </div>
        </div>
    </div>

    <script>
        $("#nav a:nth-child(4)").addClass("active");
    </script>

    <%--新增功能--%>
        <script>
            $("#cid1").blur(function () {
                var cid1 = $("#cid1").val();
                $.get("CommonServlet.do?action=getUnameByCid&cid=" + cid1, function
                    (result) {
                    $("#uname1").val(result);
                });
            });
            $("#cid2").blur(function () {
                var cid2 = $("#cid2").val();
                $.get("CommonServlet.do?action=getUnameByCid&cid=" + cid2, function
                    (result) {
                    $("#uname2").val(result);
                });
            });
            </script>

        <script>
            var message = "${message}";
            if (message != "") {
                alert(message);
            }
            </script>
</body>

</html>
