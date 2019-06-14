<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>리스트</b>
	<c:if test="${userInfos}">
		<c:forEach var="user" items="${userInfos}">
			<label>${user.userId}</label>
			<button value="${user.userId}">버튼</button>
		</c:forEach>
	</c:if>
</body>
</html>