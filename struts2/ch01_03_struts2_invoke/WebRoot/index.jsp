<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Action类的三种写法</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h3>方式一：传统访问方式</h3>
    <a href="demo1/save.action">save</a><br/>
    <a href="demo1/update.action">update</a><br/>
  <h3>方式二：通配符访问方式</h3>
    <a href="demo2/demo2_save.action">save</a><br/>
    <a href="demo2/demo2_delete.action">update</a><br/>
  <h3>方式三：动态方法调用的访问方式</h3>
    <a href="demo3/demo3!save.action">save</a><br/>
    <a href="demo3/demo3!delete.action">update</a><br/>
  </body>
</html>
