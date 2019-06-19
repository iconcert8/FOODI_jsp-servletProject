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
		
	<article id="search">
		<input type="text" onkeyup="search()">
	</article>
	<section id="chatView">
<%-- 		<c:forEach var="chat" items="${chatList }"> --%>
<%-- 			<div>ID : ${chat.reqId } / To : ${chat.resId }<br>${chat.chatDate } &nbsp; ${chat.chatMsg } <br> --%>
<%-- 			<c:if test="${chat.chatChk >= 1 }">안읽음</c:if> --%>
<%-- 			<c:if test="${chat.chatChk < 1 }">읽음</c:if> --%>
<!-- 			</div> -->
<%-- 		</c:forEach> --%>
	</section>
	<aside id="resList">
		<hr>
		채팅 목록
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