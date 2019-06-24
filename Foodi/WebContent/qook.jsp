<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Foodi/css/all.css">
<link rel="stylesheet" href="/Foodi/css/qook.css">
<title>Insert title here</title>
</head>
<body>
	<nav>
		메뉴바 들어 갈 곳 
	</nav>
	<section>
		<article id="left" class="side">
			좌측
		</article>
		
		<article id="middle">
			<h2>즐겨찾기</h2>
			<div id="map">지도</div>
			<ul id="list">
				<c:forEach var="feed" items="${list}">
					<li><div>피드 이미지 : ${feed.feedImg} 주소: ${feed.feedLoc}</div><b>유저 이미지:${feed.userImg} 아이디:${feed.userId}</b></li>				
				</c:forEach>
			</ul>
		</article>
		
		<article id="right" class="side">
			우측
		</article>		
	</section>
</body>
</html>