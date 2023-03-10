<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title></title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <script src="./js/jquery-3.2.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background: url(./images/bc.jpg);
            background-position: top;
        }

        #title {
            text-align: center;
            font-size: 56px;
            font-family: "楷体";
            font-weight: bold;
            margin-top: 120px;
            color: white;
        }

        #login-box {
            padding: 35px;
            border-radius: 15px;
            background-color: #56666B;
            color: #fff;
        }
    </style>
</head>

<body>
<div class="container">
    <div id="title" class="col-md-6 col-md-offset-3">银行柜台作业系统</div>
    <div class="col-md-4 col-md-offset-4" style="margin-top:120px;">
        <div id="login-box">

            <form class="form-horizontal" role="form" action="LoginServlet.do?action=login"
                  method="post" autocomplete="off">
                <div class="form-group">
                    <label for="uid" class="col-sm-3 control-label">账号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="uid" placeholder="请输入账
号" name="uid" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="password"
                                   placeholder="请输入密码"
                                   name="password" required>
                        </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-info" style="width:100%;">登录
                        </button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        $(".form-control").focus(function () {
            $("#message").css("display", "none");
        });
    });

    //添加-功能
    var message = "${message}";
    if (message != "") {
        alert(message);
    }
</script>
</html>
