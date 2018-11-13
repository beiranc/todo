<%@page import="Model.Tasks"%>
<%@page import="Model.TasksService"%>
<%@page import="Model.TodolistService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List Tasks Page</title>
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
			TodolistService todolistService = new TodolistService();
			String todolistId = (String) httpSession.getAttribute("todolistId");
			Todolist todolist = todolistService.getTodolistById(todolistId);
		%>
		<span>Current List: <%= todolist.getTitle() %></span><br />
		<span><a href='/todo/pages/AddTasksPage.jsp'>添加一个任务</a></span>
        <table align='center'>
			<thead>
				<caption><h1><%= todolist.getTitle() %></h1></caption>
				<tr>
					<th>Title</th>
					<th>Contents</th>
					<th>Priority</th>
					<th>CreateTime</th>
					<th>Deadline</th>
					<th>isFinished</th>
				</tr>
			</thead>
			<tbody>
			<%
				List<Tasks> list = new ArrayList();
				//获取tasks
				TasksService tasksService = new TasksService();
				list = (List) tasksService.getAllTasksById(todolistId);
				for(int i=0; i < list.size(); i++){
			%>
		    	<tr>
			    	<td><%= list.get(i).getTitle() %></td>
					<td><%= list.get(i).getContents() %></td>
					<td><%= list.get(i).getPriority() %></td>
					<td><%= list.get(i).getCreateTime() %></td>
					<td><%= list.get(i).getDeadline() %></td>
					<td><%= list.get(i).isFinished() %></td>
				</tr>
			<%
				}
			%>
			</tbody>
			<a href='/todo/pages/ListPage.jsp'>返回主列表</a>
		</table>
	</div>
</body>
</html>