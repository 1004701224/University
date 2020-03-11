<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
请确认您的信息：<%out.print(request.getSession().getAttribute("username")); %>
<a href="delete">注销</a>
</body>
</html>