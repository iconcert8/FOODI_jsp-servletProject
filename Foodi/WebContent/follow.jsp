<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Foodi/css/follow.css">
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/Foodi/js/followView.js" charset="UTF-8"></script>
<title>Insert title here</title>
</head>
<body>
	<%-- <jsp:include page="notify.jsp"></jsp:include> --%>
	<nav>
		메뉴바
	</nav> 
	<header>
		<h2>Follow</h2>
		<div>ㅡ</div> <div id="searchBox"><input type="text" name="flwSearch"><button id="flwSearch">검색</button></div>
	</header>
	<section>
		<article>
			<h3>Follower</h3>
			<ul id="flrList">
			</ul>
		</article>
		<div id="line"></div>
		<article>
			<h3>Following</h3>
			<ul id="flnList">
			</ul>
		</article>
	</section>
</body>
</html>