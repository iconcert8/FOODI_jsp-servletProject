<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글</h1>
	<div id="newsFeedDetail">
	 	피드번호 : <b>${feedVO.feedNo}</b><br><br>
	 	아이디 : <b>${feedVO.userId}</b><br><br>
	 	내용 : <b>${feedVO.feedContent}</b><br><br>
	 	<c:if test="${feedVO.feedImg != null}">
	 		이미지 : <a href="download.jsp?filename=${feedVO.feedImg}">${feedVO.feedImg}</a><br><br>
	 	</c:if><br><br>
	 		<c:if test="${feedVO.feedImg != null}">
	 		이미지들 : <a href="download.jsp?filename=${feedVO.feedImg}">${feedVO.feedImg}</a><br><br>
	 	</c:if><br><br> 
	 	좋아요 : <b>${feedVO.feedGoodCnt}</b><br><br>
	 	위치 : <b>${feedVO.feedLoc }</b><br><br>
	 	작성 날짜 : <b>${feedVO.feedDate}</b><br><br>
	 	수정 날짜 : <b>${feedVO.feedUpdate}</b><br><br>
	 	공개 여부 : <b>${feedVO.feedLock }</b><br><br>
	</div>  
	<br><br>  
		<h3>댓글 목록</h3>
		<div> 
			<div id="newsfeedReply">
				<c:forEach var="r" items="${reply}">
					<div>
						<b>${r.replyNo}</b>
						<b>${r.userId}</b>
						<b>${r.replyContent}</b>
						<b>${r.replyDate}</b>
					</div> 
				</c:forEach> 
			</div>
			 
			<form action="insertNewsfeedReply.do" method="post">
				이름 : <b>${userInfoVO.userId}</b><br><br>
				내용 : <br><textarea rows="5" cols="200" name="replyContent"></textarea>
				<input type="hidden" name="feedNo" value="${feedVO.feedNo}">
				<input type="submit" value="작성">
			</form>
		</div>
</body>
</html>