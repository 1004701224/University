<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.7.2.js">
$(function() {
	$("a").click(function() {
		$("img").attr("src","validcode?date="+new Date());
		return false;
	})
})
</script>
<body>
<form action="login" method="post" >
	<input type="text" name="name" ><br>
	<input type="password" name="password" ><br>
	<input type="text" name="num"><br> 
	<input type="submit" value="提交"><img alt="" src="validcode" width="80px" height="40px"><a href="">看不清</a>
</form>
</body>
</html>