<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/upload/test1.action" method="post" enctype="multipart/form-data" >
	用户名:<input type="text" name="userName" />
	密码:<input type="password" name="userPass"/>
	头像:<input type="file" name="headIcon">
	<input type="submit" value="保存">
</form>
</body>
</html>