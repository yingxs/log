<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>客户修改页面</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/customer.action" method="post">
		<input type="hidden" name="custId" value="${cust.custId }">
		<input type="hidden" name="_method" value="put">
		客户名称：<input type="text" name="custName" value="${cust.custName }" /><br /> 
		客户电话：<input type="text" name="custTelephone" value="${cust.custTelephone }"  /><br /> 
		<input type="submit" value="修改">
	</form>

</body>
</html>