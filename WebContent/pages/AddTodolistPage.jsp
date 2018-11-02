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
	<form action='addTodolist.do' method='POST'>
		Chose to Display: <input type='checkbox' name='display_title' value='true'/>Title <br/><br/>
		Chose to Display: <input type='checkbox' name='display_year' value='true'/>Year <br/><br/>
		Chose to Display: <input type='checkbox' name='display_genre' value='true'/>Genre <br/><br/>
		<input type='submit' value='Submit to display' />
	</form>
</body>
</html>