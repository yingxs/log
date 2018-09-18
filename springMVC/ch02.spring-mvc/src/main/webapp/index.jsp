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
	
	<h3>2.@PathVariable路径参数接收</h3>
	<form action="${pageContext.request.contextPath}/param/test2/zhangsan/123456.action" method="post">
	<input type="submit" value="提交" />
	</form>
	
	<h3>3.简单数据类型</h3>
	<form action="${pageContext.request.contextPath}/param/test3.action" method="post">
	用户名:<input type="text" name="userName" /></br/>
	密 码:<input type="password" name="userPass"/><br/>
	<input type="submit" value="提交" />
	</form>

	<h3>4.JavaBean类型</h3>
	<form action="${pageContext.request.contextPath}/param/test4.action" method="post">
	用户名:<input type="text" name="userName" /></br/>
	密 码:<input type="password" name="userPass"/><br/>
	手机:<input type="text" name="userTelephone"/><br/>
	<input type="submit" value="提交" />
	</form>
	
	<h3>5.包装JavaBean类型</h3>
	<form action="${pageContext.request.contextPath}/param/test5.action" method="post">
	用户名:<input type="text" name="user.userName" /></br/>
	密 码:<input type="password" name="user.userPass"/><br/>
	手机:<input type="text" name="user.userTelephone"/><br/>
	性别:<input type="radio" name="gender" value="男"/>男
		<input type="radio" name="gender" value="女"/>女
	<input type="submit" value="提交" />
	</form>

</body>
</html>