<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Todolist Page</title>
</head>
<body>
	<h3>Add Todolist Page</h3>
	<form action='/todo/addTodolist.do' method='POST'>
		Title: <input type='text' name='title'/> <br/><br/>
		Comments: <input type='text' name='comments'/> <br/><br/>
		<input type='submit' value='Confirm to Add a Todolist' />
	</form>
</body>
</html>