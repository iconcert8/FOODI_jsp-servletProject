<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>자신의 DB에 있는 ID를 입력하시오</h3>
	<h4>session에 'loginUser'라는 키값으로 userInfo객체가 들어갈것임</h4>
	<form action="userInfo/testGet" method="post">
		ID : <input type="text" name="id"><br>
		<input type="submit" value="GO">
	</form>
</body>
</html>	 