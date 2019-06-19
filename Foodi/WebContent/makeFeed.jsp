<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<style type="text/css">
input {
	apperance: none;
	-webkit-apperance: none;
}

/* 드래그 드랍이 가능한 공간 표시 */
#imgs {
	width: 500px;
	height: 50px;
	background-color: lightgray;
}

li {
	display: inline;
}
</style>

</head> 
<body>
	<form action="feed/insertFeed.do" method="post"
		enctype="multipart/form-data">
		<ul>
			<li>작성자</li>
			<li>${userId}<input type="hidden" name="userId" value="a"></li>
		</ul>
		<ul>
			<li>내용</li>
			<li><textarea row="10" cols="50" name="feedContent"></textarea></li>
		</ul>
		<ul>
			<li>태그</li>
			<li><input type="text" name="tag"></li>
		</ul>
		<ul>
			<li>기본사진</li>
			<li><input type="file" name="feedImg" accept="image/*"></li>
		</ul>
		<ul>
			<li>추가사진</li>
			<li><input multiple="multiple" id="imgs" type="file"
				accept="image/*" name="feedImgs[]"></li>
		</ul>
		<ul id="list">
			<li>파일 목록</li>
		</ul>
		<ul>
			<li>위치</li>
			<li><input type="text" name="feedLoc"></li>
		</ul>
		<ul>
			<li>
				<input type="radio" name="feedLock" value="1" checked="checked">전체공개 &nbsp &nbsp
				<input type="radio" name="feedLock" value="2">팔로우 공개 &nbsp &nbsp
				<input type="radio" name="feedLock" value="3">비공개
			</li>
		</ul>
		<ul>
			<li><input type="submit" value="작성하기"></li>
			<li><a href="#">돌아가기(이전페이지로)</a></li>
		</ul>
	</form>

</body>
</html>