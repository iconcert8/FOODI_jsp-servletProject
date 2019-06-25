<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-uA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="/Foodi/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/Foodi/js/makeFeed.js"></script>
<link rel="stylesheet" href="/Foodi/css/makeFeed.css">
<link rel="stylesheet" href="/Foodi/css/all.css">
</head>
<body>
	<nav>
		<jsp:include page="toolbar.jsp"></jsp:include> 
	</nav> 
	<div style="height: 100px;"></div>
	
	<section>
		<article id="left" class="side"></article>
		
		<article id="middle">
			<form action="feed/insertFeed.do" method="post" enctype="multipart/form-data" id="insertForm middle">
				<ul>
					<li>작성자</li>
					<li>${loginUser.userId}<input type="hidden" name="userId" value="${loginUser.userId}"></li>
				</ul><br>
				
				<ul>
					<li>내용</li>
					<li><textarea row="10" cols="50" name="feedContent"></textarea></li>
				</ul><br> 
				
				<ul>
					<li>태그</li>
					<li><input type="text" name="tagName"></li>
				</ul><br>
				
				<ul>
					<li>기본사진</li>
					<li><input type="file" id="feedImg" name="feedImg" accept="image/*"></li><br><br>
					
					<li><img id="preview" src="#" alt="your image" /></li>
					
					<br><br>
				</ul><br>
				
				
				<!-- ***********멀티파일 첨부를 DB에 저장하기 미완성*************  -->
				<ul>
					<li>추가사진</li>
					<li><input multiple="multiple" id="feedImgs" name="feedImgs" type="file" accept="image/*" name="feedImgs[]"></li>
				</ul><br>
				
				<ul id="list">
					<li>파일 목록</li>
				</ul><br>
				<!-- ****************************************************  -->
				
				<ul>
					<li>위치</li>
					<li><input type="text" name="feedLoc"></li>
				</ul><br>
				
				<ul>
					<li>
						<input type="radio" name="feedLock" value="1" checked="checked">전체공개 &nbsp; &nbsp;
						<input type="radio" name="feedLock" value="2">팔로우 공개 &nbsp; &nbsp;
						<input type="radio" name="feedLock" value="3">비공개
					</li>
				</ul><br>
				
				<ul>
					<li><input type="submit" value="작성하기"></li>
					<li><a href="#">돌아가기(이전페이지로)</a></li>
				</ul>
			</form>
		</article>
		
		<article id="right" class="side"></article>
	</section>
</body>
</html>