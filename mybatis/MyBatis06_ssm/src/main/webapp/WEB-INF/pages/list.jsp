<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查询员工</title>
</head>
<body>
	<table>
			<tr>
				<th>id</th>
				<th>lastName</th>
				<th>email</th>
				<th>gender</th>
				<th>departmentName</th>
			</tr>
		<c:forEach items="${allEmps }" var="emp">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>${emp.gender }</td>
				<%-- <td>${emp.dept.departmentName }</td> --%>
			</tr>
		</c:forEach>
	</table>
</body>
</html>