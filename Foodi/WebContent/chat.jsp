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
    <link rel="stylesheet" href="/Foodi/css/all.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
</head>
<body>
	<header>
		채팅창입니다.
	</header>
	<nav>
		메뉴바 들어 갈 곳 
	</nav>
		<hr>
		
	<section>
		<article id="left" class="side">
			<input type="text" id="search">
		</article>
		
		<article id="middle">
			<div id="resInfo">
			
			</div>
			<div id="chatView">
	
			</div>
			<div id="sendMsg">
				<form action="view" method="post">
					<textarea rows="3" cols="100" name="chatMsg" autofocus="autofocus"></textarea>
					<input type="button" value="send" onclick="reqMsg()">
		<!-- 			<input type="submit" value="send"> -->
				</form>
			</div>
		</article>
		
		
		
		<article id="right" class="side">				
		채팅 목록
		<hr>
		<div id="resList"></div>
		</article>		
	</section>
	
	<footer>

	</footer>

	<script type="text/javascript" src="/Foodi/js/chat.js" charset="utf-8"></script>
</body>
</html>