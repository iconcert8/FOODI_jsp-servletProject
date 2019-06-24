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
<!--     <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> -->
    <link rel="stylesheet" href="/Foodi/css/chat.css">
</head>
<body>
<!-- 	<nav> -->
		<jsp:include page="toolbar.jsp"></jsp:include>
<!-- 	</nav> -->
	<section>
		<article id="left" class="side">
			<div class="ChatTitle">ID Search</div>
				<hr>
			<div id="idSearch">
				<input type="text" id="search"><input type="button" id="searchbtn" value="ID찾기">
			</div>
			<div id="leftList"></div>
		</article>
		
		<article id="middle">
			<div id="resInfo">
			
			</div>
			<div id="chatView">
	
			</div>
			<div id="sendMsg">
				<form action="view" method="post">
					<input type="text" name="chatMsg" autofocus="autofocus"></textarea>
					<input type="button" value="send">
		<!-- 			<input type="submit" value="send"> -->
				</form>
			</div>
		</article>
		
		
		
		<article id="right" class="side">				
			<div class="ChatTitle">List</div>
			<hr>
			<div id="resList"></div>
		</article>		
	</section>
	
	<footer>

	</footer>

	<script type="text/javascript" src="/Foodi/js/chat.js" charset="utf-8"></script>
</body>
</html>