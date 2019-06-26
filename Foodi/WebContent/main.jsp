<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Foodi/css/main.css">
<link rel="stylesheet" href="/Foodi/css/lightBoxFeed.css">
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/Foodi/js/mainView.js"></script>
<title>Insert title here</title>
</head>
<body>
	<nav>
		<jsp:include page="toolbar.jsp"></jsp:include>
	</nav>
	<div style="height: 100px;"></div>
	<header>
		 
		<h1></h1>
		<div></div>
		<!-- <form action="/Foodi/search/searchresult.do" method="post">
	<input type="text" name="searchKeyword" /><input type="submit" value="검색"/>
	</form>  -->
		</div>
	</header>
	
	<section>	
		<h2>HOT TAG</h2>
		<div id="line"></div>
		<article>
			<h3 id="firstH3"></h3>
			<div class="arrow arrowLeft"><b><</b></div>
			<div class="ulBox">
				<ul id="firstUl"></ul>
			</div>
			<div class="arrow arrowRight"><b>></b></div>
		</article>
	
		<article>
			<h3 id="secondH3"></h3>
			<div class="arrow arrowLeft"><b><</b></div>
			<div class="ulBox">
				<ul id="secondUl"></ul>
			</div>
			<div class="arrow arrowRight"><b>></b></div>
		</article>
	</section>
	<!-- 라이트박스 피드 -->
	<!-- /라이트박스 피드 -->
</body>
</html>