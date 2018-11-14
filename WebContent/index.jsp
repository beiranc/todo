<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Index Page</title>
	<link rel="icon" href="./pages/images/favicon.ico">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- jquery for Bootstrap 导入-->
    <script src="./pages/bootstrap/js/jquery/2.0.0/jquery.min.js"></script>

    <!-- bootstrap 导入 -->
    <link rel="stylesheet" href="./pages/bootstrap/css/bootstrap/3.3.6/bootstrap.min.css">
    <script src="./pages/bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
      	<div class="row clearfix">
      		<div class="col-md-12 column">
      			<div class="jumbotron well text-center">
      				<h1 style="color:#f2711c">ToDoList</h1>
      				<p class="text-info">Time and task tracking at your fingertips.</p>
      			</div>
      			<div class="row clearfix">
      				<div class="col-md-6 column">
      					<p class="text-center lead text-info">
      						 <em style="color:#f2711c">这是什么？</em><br/><br/>
                               A simple todo application for managing all your needs.
                               Most use cases should be satisfied.
      					</p>
      				</div>
      				<div class="col-md-6 column">
      					<p class="lead text-warning text-center">
      						 <em style="color:#f2711c">还没帐号？点此<a href="/todo/pages/RegisterPage.jsp"> 注册 </a></em><br/><br/><br/>
                              	 已有账号？点此<a href="/todo/pages/LoginPage.jsp"> 登录  </a>
      					</p>
      				</div>
      			</div>
      		</div>
      	</div>
        <div class="row clearfix">
      		<div class="col-md-12 column text-center">
      			<p class="lead text-warning text-center">ToDoList&nbsp;&copy;版权所有</p>
      		</div>
      	</div>
     </div>
</body>
</html>