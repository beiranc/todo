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
	<div id='content'>
        <table align='center'>
			<thead>
				<caption><h1>Todolist</h1></caption>
				<tr>
					<th>Title</th>
					<th>Comments</th>
				</tr>
			</thead>
			<tbody>
			<%@ page import="java.util.*" %>
			<%@ page import="Model.Todolist"%>
			<%
				List<Todolist> list=new ArrayList();
				//Action 部分setAttribute()
				list = (List) request.getAttribute("todolist");
				for(int i=0; i < list.size(); i++){
			%>
		    	<tr>
			    	<td><%= list.get(i).getTitle() %>></td>
					<td><%= list.get(i).getComments() %>></td>
				</tr>
			<%
				}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>