<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="register" method="post">
	用户名<input type="text" name="name"><br>
	密码<input type="password" name="password"><br>
	确认密码<input type="password"><br>
	授权码<input type="text" name="key"><br>
	验证码<input type="text" name="num"><img src="validcode" width="80px" height="40px"><br>
	<input type="submit" value="注册">
</form>
</body>
</html>