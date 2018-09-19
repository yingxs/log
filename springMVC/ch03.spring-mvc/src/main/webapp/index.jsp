<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>异常处理</title>
</head>
<body>
	
	<h3>1.1.@ExceptionHandler注解处理异常</h3>
	<a href="${pageContext.request.contextPath}/exception/test1.action">1.1.@ExceptionHandler注解处理异常</a>
	<hr/>
	
	
	<h3>1.2.SimpleMappingExceptionResolver处理异常</h3>
	<a href="${pageContext.request.contextPath}/exception/test2.action">1.2.SimpleMappingExceptionResolver处理异常</a>
	<hr/>

</body>
</html>