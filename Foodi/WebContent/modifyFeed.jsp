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
<script type="/Foodi/js/jquery-3.4.1.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/Foodi/js/modifyFeed.js"></script>
<link rel="stylesheet" href="/Foodi/css/all.css">
<link rel="stylesheet" href="/Foodi/css/modifyFeed.css">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<jsp:include page="toolbar.jsp"></jsp:include>
	</nav>
	
	<section>
		<article id="left" class="side"></article>
		
		<article id="middle">
			<form action="feed/modifyFeed.do" method="post" enctype="multipart/form-data" id="insertForm middle">
				<ul>
					<li>작성자</li>
					<li><input type="text" name="userId" value="${loginUser.userId}" readOnly></li>
					<li><input type="hidden" name="feedSeq" value="${feedVO.feedSeq}"></li>
				</ul><br>
				
				<ul>
					<li>내용</li>
					<li><textarea row="10" cols="50" name="feedContent">${feedVO.feedContent}</textarea></li>
				</ul><br> 
				
				<ul>
					<li>태그</li>
					<li><input type="text" name="tagName" value="${tagVO.tagName}"></li>
				</ul><br>
				
				<ul>
					<li>기본사진</li>
					<li><input type="file" id="feedImg" name="feedImg" accept="image/*" value="${feedVO.feedImg}"></li><br><br>
					
					<li><img id="preview" src="#" alt="your image" /></li>
					
					<br><br>
				</ul><br>
				
				<ul>
					<li>위치</li>
					<li><input type="text" name="feedLoc" value="${feedVO.feedLoc}"></li>
				</ul><br>
				
				<ul>
					<li>
						<input type="radio" name="feedLock" value="1" checked="checked">전체공개 &nbsp; &nbsp;
						<input type="radio" name="feedLock" value="2">팔로우 공개 &nbsp; &nbsp;
						<input type="radio" name="feedLock" value="3">비공개
					</li>
				</ul><br>
				
				<ul>
					<li><input type="submit" value="수정하기"></li>
					<li><a href="#">돌아가기(이전페이지로)</a></li>
				</ul>
			</form>
		</article>
		
		<article id="right" class="side"></article>
	</section>
</body>
</html>