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
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/Foodi/css/chat.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
</head>
<body>
	<header>
		채팅창입니다.
	</header>
	<nav>
		<c:if test="${member.userImg}">
			<img alt="profile Img" src="thum/${member.userImg }">
		</c:if>
		<span>${member.userId }</span><br>
		<span>${member.userNick }</span>
	</nav>
		<hr>
		
	<article>
		<input type="text" id="search">
	</article>
	<section id="chatView">
		
	</section>
	<aside>
		<hr>
		채팅 목록
		<div id="resList"></div>
	</aside>
	
	<footer>
		<form action="view" method="post">
			<textarea rows="3" cols="100" name="chatMsg" autofocus="autofocus"></textarea>
			<input type="button" value="send" onclick="reqMsg()">
<!-- 			<input type="submit" value="send"> -->
		</form>
	</footer>
	
	<script type="text/javascript" src="/Foodi/js/chat.js" charset="utf-8"></script>
</body>
</html>