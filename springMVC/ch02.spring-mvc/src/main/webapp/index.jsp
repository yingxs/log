<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>不同类型的参数封装</title>
</head>
<body>
	
	<h3>1.默认参数类型</h3>
	<form action="${pageContext.request.contextPath}/param/test1.action" method="post">
	用户名:<input type="text" name="userName" /></br/>
	密 码:<input type="password" name="userPass"/><br/>
	<input type="submit" value="提交" />
	</form>

</body>
</html>