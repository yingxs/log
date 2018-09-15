<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>客户录入页面</title>
</head>
<body>

	<form action="customer_save.action" method="post">
		客户名称：<input type="text" name="custName" /><br/>
		客户名称：<input type="text" name="custMobile" /><br/>
		<input type="submit" name="保存" /><br/>
	</form>


</body>
</html>