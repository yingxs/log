<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>客户所有数据</h3>
	<form action="${pageContext.request.contextPath }/customer.action" method="post">
	<input  type="hidden" name="_method"  value="delete" />
	<table border="1" width="400">
		<tr>
			<th>选择</th>
			<th>客户名称</th>
			<th>客户电话</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.custList}" var="cust">
			<tr>
				<td><input type="checkbox" name="custIds" value="${cust.custId}" /></td>
				<td>${cust.custName}</td>
				<td>${cust.custTelephone}</td>
				<td><a href="${pageContext.request.contextPath }/customer/${cust.custId}.action">修改</a></td>
			</tr>
		</c:forEach>
		<input type="submit" value="删除" />
	</table>
	</form>
	<a href="${pageContext.request.contextPath }/customer/saveUI.action">添加客户</a>
</body>
</html>