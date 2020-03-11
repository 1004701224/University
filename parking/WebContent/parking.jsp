<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>车牌号</th>
		<th>入场时间</th>
		<th>操作</th>
	</tr>
<c:forEach items="${parking}" var="parking">
	<tr>
		<td>${parking.name}</td>
		<td>${parking.begintime}</td>
		<td><a href="out?id=${parking.id }">车辆出场</a></td>
	</tr>
</c:forEach>
<a href="delete.jsp">注销用户</a>
</table>
</body>
</html>