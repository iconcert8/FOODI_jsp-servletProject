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
			<td>피드 추가 이미지</td>
			<td>좋아요</td>
			<td>피드 위치</td>
			<td>피드 작성 날짜</td>
			<td>피드 수정 날짜</td>
			<td>피드 공개 여부</td> 
		</tr>
		<c:forEach var="FeedVO" items="${feedlist}">
			<tr> 
				<td>${FeedVO.feedNo }</td>
				<td>${FeedVO.userId }</td>
				<td>${FeedVO.feedContent}</td>
		<td><c:if test="${FeedVO.feedImg != null}">
						<c:set var="head"
							value="${fn:substring(FeedVO.userId, 
                                   0, fn:length(FeedVO.feedImg)-4) }"></c:set>

						<c:set var="pattern"
							value="${fn.substring(FeedVO.feedImg, fn:length(head) +1, fn:length(feedVO.feedImg)) }"></c:set>

 
							<c:choose>
							<c:when test="${pattern == 'jpg' || pattern == 'gif' }">
								<img src="upload/{${head }_small.${pattern}">
							</c:when>
							<c:otherwise>
								<c:out value="NO IMAGE"></c:out>
							</c:otherwise>
						</c:choose> 
					</c:if></td> 
					<td>${FeedVO.feedImgs}</td>
					<td>${FeedVO.feedGoodCnt}</td>
					<td>${FeedVO.feedLoc }</td>
					<td>${FeedVO.feedDate }</td>
					<td>${FeedVO.feedUpdate }</td>
					<td>${FeedVO.feedLock }</td>
			</tr> 
		</c:forEach> 
	</table> 
	

</body>
</html>  	