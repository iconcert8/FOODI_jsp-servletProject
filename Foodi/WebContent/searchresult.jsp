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
	<a href="search/search.do"><div>검색 창으로 돌아가기</div></a>
	<br><br>
	<h2>사용자</h2><br><br>
	<c:forEach var="u" items="${userlist }">
		<div>썸네일: ${u.userImg }</div>
		<div>ID: ${u.userId }</div>
		<div>닉네임: ${u.userNick }</div>
		<br>
	</c:forEach>
	<br><br>
	<h2>피드</h2><br><br>
	<c:forEach var="f" items="${feedlist }">
		<div>썸네일: ${f.feedImg }</div>
		<div>ID: ${f.userId }</div>
		<div>피드내용: ${f.feedContent }</div>
		<div>태그:${f.tagName }</div>
		<br>
	</c:forEach>
</body>
</html>