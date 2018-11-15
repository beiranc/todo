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
                TodolistService todolistService = new TodolistService();
                String todolistId = (String) request.getParameter("todolistId");
                Todolist todolist = todolistService.getTodolistById(todolistId);
            %>
    		<div class="jumbotron well text-center">
	    		<div class="container-fluid" id="LG">
					<div class="row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<div class="col-xs-3 span3">
									<button class="btn btn-block btn-large btn-warning disabled" type="button"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;当前清单: <%= todolist.getTitle() %></button>
									 <span></span>
								</div>
								<div class="col-xs-3 span3">
									 <a href='/todo/pages/AddTasksPage.jsp?todolistId=<%= todolistId %>'><button class="btn btn-block btn-large btn-info" type="button"><span class="glyphicon glyphicon-plus"></span>&nbsp;添加一个任务</button></a>
								</div>
								<div class="col-xs-3 span3">
									 <a href='/todo/pages/ListPage.jsp'><button class="btn btn-block btn-large btn-danger" type="button"><span class="glyphicon glyphicon-chevron-left"></span>&nbsp;返回主列表</button></a>
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
                            <caption class="text-center"><h1><%= todolist.getTitle() %></h1></caption>
        					<tr>
        						<th class="text-center">标题</th>
        						<th class="text-center">内容</th>
        						<th class="text-center">优先级</th>
        						<th class="text-center">创建时间</th>
                                <th class="text-center">最后期限</th>
                                <th class="text-center">是否完成</th>
                                <th class="text-center">设为完成</th>
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
        					<tr class="info">
                                <td><%= list.get(i).getTitle() %></td>
            					<td><%= list.get(i).getContents() %></td>
            					<td><%= list.get(i).getPriority() %></td>
            					<td><%= list.get(i).getCreateTime() %></td>
            					<td><%= list.get(i).getDeadline() %></td>
            					<%
            						if(list.get(i).isFinished()) {
            					%>
            							<td>已完成</td>
            					<%
            						} else {
            					%>
            							<td>未完成</td>
            					<%	
            						}
            					%>
            					<td><a href='#'><button class="btn btn-large btn-primary" type="button">完成</button></a></td>
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