<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Tasks Page</title>
</head>
<body>
	<h3>Add Tasks Page</h3>
	<form action='addTasks.do' method='POST'>
		Title: <input type='text' name='title'/> <br/><br/>
		Contents: <input type='text' name='contents'/> <br/><br/>
		Priority: <input type='text' name='priority'/> <br/><br>
		Deadline: <input type='date' name='deadline'/> <br/><br/>
		<input type='submit' value='Confirm to Add a Tasks' />
	</form>
</body>
</html>