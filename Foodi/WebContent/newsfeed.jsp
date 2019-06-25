<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/Foodi/js/newsFeed.js"></script>
<link rel="stylesheet" href="/Foodi/css/all.css">
<link rel="stylesheet" href="/Foodi/css/newsFeed.css">
<title>Insert title here</title> 
</head>
<body>
 	<nav>
		<jsp:include page="toolbar.jsp"></jsp:include> 
	</nav> 
	<div style="height: 100px;"></div>
	
	<section> 
		<article id="left" class="side">
			<h3>Recent Writer</h3>
			<ul id="wtrList">
			
			</ul>
		</article>
		
		<article id="middle"> 
			<h3>뉴스피드</h3>
	 		<ul id="nfList">
	 		
	 		</ul>
			<div id="lightBox" class="black">
				<b id="close">X</b>
				<div id="feedInfoBox"></div>
				<b>댓글</b>
				<div id="replyBox"></div>				
			</div>
		</article> 
		
		<article id="right" class="side">
			우측
		</article>		
	</section>
</body>
</html>