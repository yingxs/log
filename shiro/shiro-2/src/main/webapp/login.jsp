<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<h4>Login Page</h4>
	<form action="shiro/login" method="post">
	
		username:<input typpe="text" name="username">
		<br/><br/>
	
		password:<input typpe="password" name="password">
		<br/><br/>
	
		<input type="submit" value="login">
	
	</form>

</body>
</html>