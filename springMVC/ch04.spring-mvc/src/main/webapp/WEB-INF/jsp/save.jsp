<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>客户添加页面</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/customer.action"
		method="post">
		客户名称：<input type="text" name="custName" /><br /> 客户电话：<input
			type="text" name="custTelephone" /><br /> <input type="submit"
			value="添加">
	</form>

</body>
</html>