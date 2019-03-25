<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="shiro"  uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	list.jsp
	
	Welcome:<shiro:principal></shiro:principal>
	<br/>
	
	<shiro:hasRole name="admin">
		<a href="admin.jsp">Admin Page</a>
	</shiro:hasRole>
	<br/>
	
		<shiro:hasRole name="user">
		<a href="user.jsp">User Page</a>
	</shiro:hasRole>
	<br/>
	
	<a href="shiro/testShiroAnnotation">Test ShiroAnnotation</a>
	
	<a href="shiro/logout">LogOut</a>
</body>
</html>