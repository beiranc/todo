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
	<style>
		#content {
			height: 600px;
		}
		th, td {
			border: 3px solid #aaa;
			border-radius: 15%;
			padding: 15px;
		}
	</style>
</head>
<body>
	<%@ page import="java.util.*" %>
	<%@ page import="Model.Todolist"%>
	<div id='content'>
		<%
			HttpSession httpSession = request.getSession();
			UserService userService = new UserService();
			User user = new User();
			String userId = (String) httpSession.getAttribute("userId");
			user = userService.getUserById(userId);
		%>
		<span>Current User: <%= user.getUserName() %></span><br />
		<span><a href='/todo/pages/AddTodolistPage.jsp'>添加一个清单</a></span>
        <table align='center'>
			<thead>
				<caption><h1>Todolist</h1></caption>
				<tr>
					<th>Title</th>
					<th>Comments</th>
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
		    	<tr>
			    	<td><%= list.get(i).getTitle() %></td>
					<td><%= list.get(i).getComments() %></td>
				</tr>
			<%
				}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>