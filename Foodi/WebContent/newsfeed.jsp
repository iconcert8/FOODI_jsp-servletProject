<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/Foodi/js/newsFeed.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table border="1" id="nfList">
		<tr>
			<td>피드번호</td>
			<td>피드아이디</td>
			<td>피드내용</td>
			<td>피드이미지</td>
			<td>좋아요수</td>
			<td>피드 추가 이미지</td>
			<td>피드 작성 날짜</td>
			<td>피드 수정 날짜</td>
			<td>피드 공개 여부</td>
			<td>좋아요</td>
			<td>쿡</td>
			<td>댓글</td>
		</tr>
	</table>
	<h3>댓글</h3>
	<br>
	<div>
		<div id="ReplyVO">
			<c:forEach var="ReplyVO" items="${replyList}">
				<div>
					<b>${ReplyVO.userId }</b><span style="font-size: 6px;">${ReplyVO.replyDate}</span>
					<p>${ReplyVO.replyContent }</p>
				</div>
			</c:forEach>
		</div>

		<form action="feed/insertNewsfeedReply.do" method="post">
			이름 : <input type="text" name="userId"><br> 내용 <br>
			<textarea cols="40" rows="2" name="feedContent"></textarea>
			<br> <input type="hidden" name="feedNo" value="${ReplyVO.feedNo}">
			<input type="submit" value="작성">
		</form>
	</div>

</body>
</html>
