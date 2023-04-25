<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="./js/jquery-3.2.1.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<style type="text/css">
		body {
			background: url(./images/bc1.jpg);
			background-position: top;
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
	<div class="container" id="top">
		<div class="row" style="margin-top: 260px; ">
			<div class="col-md-4 col-md-offset-2"><span id="message"
					style="color: red;text-align: center;">${message}</span></div>
			<br>
			<div class="col-md-4 col-md-offset-2" id="login-box">
				<form class="form-horizontal" role="form" action="LoginServlet.do?action=login" id="loginForm" method="post"
					autocomplete="off">
					<div class="form-group">
						<label for="username" class="col-sm-3 control-label">用户</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="username" placeholder="请输入名字" name="uid"
								required>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-3 control-label">密码</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="password" placeholder="请输入密码"
								name="password" required>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-default btn-info" style="width:100%;">登录</button>
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
</script>

</html>