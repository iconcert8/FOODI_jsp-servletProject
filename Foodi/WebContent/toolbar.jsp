<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/toolbar.js"></script>
<link rel="stylesheet" href="css/toolbar.css">
</head>
<body>
	<header id="menuButton">
	<div>
		<a class="top_left_button" href="#">T</a>

	</div>

	<div id="menuBar" class="hidden">
		<ul>
			<li><a href="#">뉴스피드</a></li>
			<li><a href="#">타임라인</a></li>
			<li><a href="#">팔로우</a></li>
			<li><a href="#">설정</a></li>

		</ul>
	</div>

	<div>
	<form action="search/searchresult.do" method="post">
	검색어: <input type="text" name="searchKeyword"/><input type="submit" value="검색"/>
	</form> 
	</div>

	<div id="userMenu">
		<ul>
			<li><a href="makeFeed.jsp">글쓰기</a></li>
			<li><a href="#">즐겨찾기</a></li>
			<li><a href="#">메세지</a></li>
			<li><a href="#">알림</a></li>
			<li><a href="#">로그아웃</a></li>
		</ul>
	</div>
	</header>
</body>
</html>