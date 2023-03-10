<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>开卡业务</title>
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
                        <h1 style="text-align: center;">添加银行卡信息</h1>
                    </div>
                </div>
                <div class="panel-body">


                    <form class="form-horizontal" role="form" action="CardServlet.do?action=add"
                          method="post">
                        <div class="form-group">
                            <label for="type" class="col-sm-2 control-label">卡类型</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="type" id="type">
                                    <option value="钻石卡">钻石卡</option>
                                    <option value="金卡">金卡</option>
                                    <option value="银卡" selected>银卡</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="account" class="col-sm-2 control-label">余额</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="account"
                                       name="account"
                                       value="0" placeholder="请输入余额">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="uid" class="col-sm-2 control-label">开卡账号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="uid" name="uid"
                                       placeholder="请输入开卡账号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="uname" class="col-sm-2 control-label">开卡人</label>
                            <div class="col-sm-10">
                                <input readonly type="text" class="form-control" id="uname"
                                       name="uname">
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
        $("#nav a:nth-child(3)").addClass("active");
    </script>

    <%--新增功能1--%>
        <script>
            $("#uid").blur(function () {
                var uid = $("#uid").val();
                if (uid == null || uid.trim() == "") {
                    return;
                }
                $.get("CardServlet.do?action=getOpener&uid=" + uid, function (result) {
                    $("#uname").val(result);
                });
            });
        </script>
</body>

</html>
