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
	<nav>
		<jsp:include page="toolbar.jsp"></jsp:include> 
	</nav> 
	<div style="height: 100px;"></div>
	<section>
		<article id="left" class="side">좌측</article>

		<article id="middle">
			
			<div>
				<h2 id="search_result">
				<span id="searchKeyword">${searchKeyword }</span>"에 대한 검색 결과
				</h2>
			</div>
			
			<h2 id="user_title">Tag</h2>
				<c:forEach var="t" items="${taglist }">
					<div class="tagSSG">
						<span>${t }</span>
						<input type="button" style="font-size:30px;" class="ssgbtn" name=${t } value="SSG"></input>
					</div>
				</c:forEach>
			<br>
			<br>
			
			<h2 id="user_title">사용자</h2>
			<br>
			<br>
			
			<div class="user_list">
			<c:forEach var="u" items="${userlist }">
				<div class="user">
					<a href="/Foodi/timeline/timeline?userId=${u.userId }">
						<img alt="no images" src="${u.userImg }" style="width:140px;height:140px;padding: 5px;"/>
					</a>
					<div class="id">${u.userId }</div>
					<div class="nick">${u.userNick }</div>
				</div>
			</c:forEach>
			</div>
			
			<br>
			<br>
			<h2 id="feed_title">피드</h2>
			<br>
			<br>
			<ul>
			<c:forEach var="f" items="${feedlist }">
				<li class="feed">
				<div class="feed_content">
					<img alt="no img" src="${f.feedImg }" class="feed_img"/>
				
					<div>
						<span class="feed_tag">${f.tagName }</span>
					</div>
				</div>
				<div class="feedUserInfo">
					<img src="${f.userImg }" class="feed_userImg"/>
					<span class="feed_userId">${f.userId }</span>		
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