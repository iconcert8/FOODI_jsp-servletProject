<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Foodi/css/follow.css">
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/Foodi/js/followView.js" charset="UTF-8"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="notify.jsp"></jsp:include>
	
	<b>팔로워 리스트</b>
	<input type="text" name="flwSearch">
	<button id="flwSearch">검색</button>
	<ul id="flrList">
		
	</ul>
	
	<hr>
	
	<b>팔로잉 리스트</b>
	<ul id="flnList">
		
	</ul>
</body>
</html>