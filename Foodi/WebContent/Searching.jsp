<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Foodi/css/all.css">
<link rel="stylesheet" href="/Foodi/css/Searching.css">
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/Foodi/js/Searching.js"></script>
<title>Insert title here</title>
</head>
<body>
	<nav>메뉴바 들어 갈 곳</nav>
	<section>
		<article id="left" class="side">좌측</article>

		<article id="middle">
			
				<h1 id="search_result">
					<p id="searchKeyword">${searchKeyword }</p>에 대한 검색 결과<div id="btn"><button style="font-size:30px;" id="ssgbtn">SSG</button></div>
				</h1>
			
			<br>
			<br>
			
			<h2 id="user_title">사용자</h2>
			<br>
			<br>
			
			<ul id="user_list">
			<c:forEach var="u" items="${userlist }">
				<li id="user">
				<a href="/Foodi/timeline/timeline?userId=${u.userId }">
				<img alt="no images" src="${u.userImg }" style="width:140px;height:140px;padding: 5px;"/>
				<div id="id">${u.userId }</div>
				<div id="nick">${u.userNick }</div>
				<br>
				</a>
				</li>
			</c:forEach>
			</ul>
			
			<br>
			<br>
			<h2 id="feed_title">피드</h2>
			<br>
			<br>
			<ul>
			<c:forEach var="f" items="${feedlist }">
				<li id="feed">
				<img alt="no img" src="${f.feedImg }" id="feed_img"/>
				<div id="feed_content">
				<div><span id="feed_id">${f.userId }</span><span id="feed_tag">#${f.tagName }</span></div>
				</div>
				<br>
				</li>
			</c:forEach>
			</ul>
		</article>

		<article id="right" class="side">우측</article>
	</section>

</body>
</html>