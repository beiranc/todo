<%@page import="Model.TodolistService"%>
<%@page import="Model.UserService"%>
<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List Page</title>
	<!-- 导入icon -->
	<link rel="icon" href="./images/favicon.ico">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 导入自定义CSS -->
	<link href="./css/Login.css" rel='stylesheet' type='text/css' />
	<!-- jquery for Bootstrap 导入-->
    <script src="./bootstrap/js/jquery/2.0.0/jquery.min.js"></script>

    <!-- bootstrap 导入 -->
    <link rel="stylesheet" href="./bootstrap/css/bootstrap/3.3.6/bootstrap.min.css">
    <script src="./bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <style>
    	a, a:hover {
    		text-decoration: none;
    	}
    </style>
</head>
<body>
	<%@ page import="java.util.*" %>
	<%@ page import="Model.Todolist"%>
	<div class="container-fluid">
            <%
    			HttpSession httpSession = request.getSession();
    			UserService userService = new UserService();
    			User user = new User();
    			String userId = (String) httpSession.getAttribute("userId");
    			user = userService.getUserById(userId);
    		%>
    		<div class="jumbotron well text-center">
	    		<div class="container-fluid" id="LG">
					<div class="row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<div class="col-xs-3 span3">
									<button class="btn btn-block btn-large btn-warning disabled" type="button"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;当前用户: <%= user.getUserName() %></button>
									 <span></span>
								</div>
								<div class="col-xs-3 span3">
									 <a href='/todo/pages/AddTodolistPage.jsp'><button class="btn btn-block btn-large btn-info" type="button"><span class="glyphicon glyphicon-plus"></span>&nbsp;添加一个清单</button></a>
								</div>
								<div class="col-xs-3 span3">
									 <a href='/todo'><button class="btn btn-block btn-large btn-danger" type="button"><span class="glyphicon glyphicon-chevron-left"></span>&nbsp;返回主页面</button></a>
								</div>
								<div class="col-xs-3 span3">
									<!-- 搜索框 -->
									 <form class="form-search form-inline">
				        				<input class="input-medium search-query" type="text" placeholder="keyword..."/> <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-search"></span>&nbsp;查找</button>
				        			</form>
								</div>
							</div>
						</div>
					</div>
				</div>
    		</div>
        	<div class="row-fluid">
        		<div class="span12">
        			<table class="table table-hover table-bordered text-center">
        				<thead>
                            <caption class="text-center"><h1>Todolist</h1></caption>
        					<tr>
        						<th class="text-center">标题</th>
        						<th class="text-center">备注</th>
        						<th class="text-center">修改</th>
        						<th class="text-center">删除</th>
        					</tr>
        				</thead>
        				<tbody>
                            <%
                				List<Todolist> list = new ArrayList();
                				//获取List
                				TodolistService todolistService = new TodolistService();
                				list = (List) todolistService.getAllTodolistById(userId);;
                				for(int i=0; i < list.size(); i++){
                			%>
        					<tr class="success">
        						<td><a href='/todo/pages/ListTasksPage.jsp?todolistId=<%= list.get(i).getTodolistId() %>'><%= list.get(i).getTitle() %></a></td>
        						<td><%= list.get(i).getComments() %></td>
        						<td><a href='/todo/pages/UpdateTodolist.jsp?todolistId=<%= list.get(i).getTodolistId() %>'><button class="btn btn-block btn-large btn-success" type="button">修改</button></a></td>
        						<td><a href='/todo/listPage.do?todolistId=<%= list.get(i).getTodolistId() %>'><button class="btn btn-block btn-large btn-primary" type="button">删除</button></a></td>
        					</tr>
                            <%
                				}
                			%>
        				</tbody>
        			</table>
        		</div>
        	</div>
      </div>
</body>
</html>