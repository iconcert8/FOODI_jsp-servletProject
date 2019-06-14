<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>검색 결과</h1>
	<br><br>
	<h2>사람</h2>
	<c:forEach var="u" items="${userlist }">
		<div>아이디:${u.userId }</div>
		<div>닉네임:${u.userNick }</div>
	</c:forEach>
	<h2>피드</h2>
	<c:forEach var="f" items="${feedlist }">
		<div>작성자:${f.userId }</div>
		<div>썸네일:${f.feedImg }</div>
		<div>피드내용:${f.feedContent }</div>
	</c:forEach>
</body>
</html>