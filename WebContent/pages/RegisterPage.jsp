<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
</head>
<body>
	<h3>Register Page</h3>
	<form action='/todo/register.do' method='POST'>
		UserName: <input type='text' name='userName'/> <br/><br/>
		Password: <input type='password' name='password'/> <br/><br/>
		<input type='submit' value='Register' />
	</form>
</body>
</html>