<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>messenger</title>
</head>
<body>
	<header>
	
	</header>
	<nav>
		<c:if test="${member.userImg}">
			<img alt="profile Img" src="thum/${member.userImg }">
		</c:if>
		<span>${member.userId }</span><br>
		<span>${member.userNick }</span>
	</nav>
		<hr>
	<section>
	
	</section>
	<aside>
	
	</aside>
	
	<footer>
	
	</footer>
</body>
</html>