<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Foodi/css/follow.css">
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/Foodi/js/follow.js" charset="UTF-8"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="notify.jsp"></jsp:include>
	
	<b>팔로워 리스트</b>
	<input type="text" name="flwSearch">
	<button id="flwSearch">검색</button>
	<ul id="flrList">
		<c:if test="${followerList != null}">
			<c:forEach var="user" items="${followerList}">
				<c:choose>
					<c:when test="${user.isFollow == null}">
						<li value="${user.userId}"><label>${user.userId}</label>
							<button flr="${user.userId}" class="nofln" value="${user.userId}">팔로우</button>
						</li>
					</c:when>
					<c:otherwise>
						<li value="${user.userId}"><label>${user.userId}</label>
							<button flr="${user.userId}" class="fln" value="${user.userId}">팔로잉</button>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if>
	</ul>
	<hr>
	<b>팔로잉 리스트</b>
	<ul id="flnList">
		<c:if test="${followingList != null}">
			<c:forEach var="user" items="${followingList}">
				<li fln="${user.userId}" value="${user.userId}"><label>${user.userId}</label>
					<button class="fln" value="${user.userId}">팔로잉</button></li>
			</c:forEach>
		</c:if>
	</ul>
</body>
</html>