<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="/Foodi/js/toolbar.js"></script>
<link rel="stylesheet" href="/Foodi/css/all.css">
<link rel="stylesheet" href="/Foodi/css/toolbar.css">
</head>
<body>
	<nav class="nav">
	<div id="menuButton" class="menuClick">
		<a class="menuOnOff" href="#">
			<img src="/Foodi/css/icon/menuOn.png" id="menuOn" width="60px" height="60px" />
		</a>
		
		<a class="menuOnOff hidden" href="#">
			<img src="/Foodi/css/icon/menuOff.png" id="menuOff" width="60px" height="60px" />
		</a>
	</div>

	<div id="searchForm">
		<form action="search/searchresult.do" method="post">
			<input id="searchSpace" name="searchKeyword" />
			<input id="searchButton" type="submit" value="검색" />
		</form>
	</div>

	<div id="userMenu">
		<!-------------------------  로그인 했을경우 나타날 화면  ------------------------->
		<c:if test="${loginUser != null}">
			<ul>
				<li><a href="/Foodi/feed/makeFeed.do">
					<img src="/Foodi/css/icon/feed.png" width="50" height="50" />
				</a></li>&nbsp;&nbsp;

				<li><a href="#">
					<img src="/Foodi/css/icon/kook.png" width="50" height="50" />
				</a></li>&nbsp;&nbsp;

				<li><a href="/Foodi/chat/view">
					<img src="/Foodi/css/icon/chat.png" width="50"	height="50" />
				</a></li>&nbsp;&nbsp;

				<li><a href="#" id="notify">
					<img src="/Foodi/css/icon/notification.png" width="50" height="50" />
				</a></li>&nbsp;&nbsp;
				<li><a href="/Foodi/userInfo/logout.do" method="post">
					<img src="/Foodi/css/icon/logout.png" width="50" height="50" />
				</a></li>&nbsp;&nbsp;
			</ul>
		</c:if>
		
		<!-----------------------  로그인하지 않았을 경우 나타날 화면  ----------------------->
		<c:if test="${loginUser == null}">
			<ul>
				<li><a href="userInfo/loginPage.do">
					<img src="/Foodi/css/icon/logout.png" width="50" height="50" />
				</a></li>&nbsp;&nbsp;
			
				<li><a href="userInfo/joinPage.do">
					<img src="/Foodi/css/icon/join.png" width="50" height="50" />
				</a></li>&nbsp;&nbsp;
			</ul>
		</c:if>
		<!---------------------------------------------------------------------->
	</div>
	</nav>


	<div id="menuBar" class="hidden">
		<!-------------------------  로그인 했을경우 나타날 화면  ------------------------->
		<c:if test="${loginUser != null}">
			<ul>
				<li ><img src="/Foodi/upload/${loginUser.userImg}" class="menuProfileImg" /></li><br>

				<li class="menuNick"> ${loginUser.userNick}</li><br>

				<li class="menuLink"><a href="#">News Feed</a></li><br>

				<li class="menuLink"><a href="#">Time Line</a></li><br>

				<li class="menuLink"><a href="#">Follow</a></li><br>
				
				<li class="menuLink"><a href="#">Setting</a></li><br>
			</ul>
		</c:if>
		
		<!-----------------------  로그인하지 않았을 경우 나타날 화면  ----------------------->
		<c:if test="${loginUser == null}">
			<ul>
				<li><a href="userInfo/loginPage.do">로그인 하세욧</a></li>
			</ul>
		</c:if>
		<!---------------------------------------------------------------------->
	</div>

	<!---------------- 알림 추가시킬 영역 토글버튼으로 히든클래스 설정 ------------------>
	<div id="notifyList" class="hidden">
		<jsp:include page="notify.jsp"></jsp:include>
	</div>
	<!---------------------------------------------------------------------->
</body>
</html>