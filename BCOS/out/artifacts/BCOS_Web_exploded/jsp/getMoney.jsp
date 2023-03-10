<%--
  Created by IntelliJ IDEA.
  User: Xing_lin_lin
  Date: 2022/10/18
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>取款业务</title>
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
                        <h1 style="text-align: center;">取款业务</h1>
                    </div>
                </div>
                <div class="panel-body">



                    <form class="form-horizontal" role="form" action="CommonServlet.do?action=get"
                          method="post">
                        <div class="form-group">
                            <label for="cid" class="col-sm-2 control-label">卡号</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="cid" name="cid"
                                       placeholder="请输入取款卡号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="money" class="col-sm-2 control-label">取款金额</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="money" name="money"
                                       placeholder="请输入取款金额">
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
        $("#nav a:nth-child(4)").addClass("active");
    </script>

    <%--增加功能--%>
    <script>
       var message = "${message}";
          if (message != "") {
             alert(message);
          }
    </script>

</body>

</html>