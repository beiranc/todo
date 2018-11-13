<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register Page</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<meta name="keywords" content="Faker" />
		<link href="css/Login.css" rel='stylesheet' type='text/css' />
		<script src="http://apps.bdimg.com/libs/jquery/1.11.1/jquery.min.js"></script>
	</head>
	<body>
		<!--Register-->
		<h1>用户注册</h1>
		<div class="login-form">
			<div class="head-info">
				<label class="lbl-1"> </label>
				<label class="lbl-2"> </label>
				<label class="lbl-3"> </label>
			</div>
				<div class="clear"> </div>
			<div class="avtar">
				<img src="images/avtar.png" />
			</div>
			<form action='/todo/register.do' method='POST'>
				<input type="text" class="text" name="userName" placeholder="请输入用户名">
				<input type="password" name="password" placeholder="请输入密码">
				<div class="register">
					<input type="submit" value="确认注册">
				</div>
			</form>
		</div>
	</body>
</html>