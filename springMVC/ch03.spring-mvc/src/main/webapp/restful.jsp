<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>查询操作</h3>
	<form action="${pageContext.request.contextPath }/restful.action" method="get" >
		<input type="submit"  value="提交"/>
	</form>
	
	<hr/>
	
	<h3>新增操作</h3>
	<form action="${pageContext.request.contextPath }/restful.action" method="post" >
	用户名：<input type="text" name="userName" /><br/>
	密码：<input type="password" name="userPass" /><br/>
		<input type="submit"  value="提交"/>
	</form>
	
	<hr/>
	
	<h3>更新操作</h3>
	<form action="${pageContext.request.contextPath }/restful.action" method="post" >
	用户名：<input type="text" name="userName" /><br/>
	密码：<input type="password" name="userPass" /><br/>
		<input type="hidden"  name="userId" value="1"/>
		
		<input type="hidden"  name="_method" value="put"/>
		<input type="submit"  value="提交"/>
	</form>
	
	<h3>删除操作</h3>
	<form action="${pageContext.request.contextPath }/restful/1.action" method="post" >
		<input type="hidden"  name="_method" value="delete"/>
		<input type="submit"  value="提交"/>
	</form>
	
	
</body>
</html>