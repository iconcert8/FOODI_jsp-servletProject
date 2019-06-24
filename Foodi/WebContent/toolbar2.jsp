<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Foodi/js/toolbar.js"></script>
<link rel="stylesheet" href="/Foodi/css/toolbar.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
</head>
<body>
	<nav class="nav">

	<div id="menuButton" class="menuClick">

		<a class="menuOnOff" href="#"> <img src="/Foodi/css/icon/menuOn.png"
			id="menuOn" width="60px" height="60px" /></a> <a
			class="menuOnOff hidden" href="#"> <img
			src="css/icon/menuOff.png" id="menuOff" width="60px" height="60px" /></a>

	</div>

	<div id="searchForm">
		<form action="search/searchresult.do" method="post">
			<input type="text" name="searchKeyword" /> <input type="submit"
				value="검색" />
		</form>
	</div>

	<!-------------------------  로그인 했을경우 나타날 화면  ------------------------->
	<div id="userMenu">
		<c:if test="${loginUser != null}">
			<ul>
				<li><a href="/Foodi/makeFeed.jsp"> <img src="/Foodi/css/icon/feed.png"
						width="50" height="50" />
				</a></li>&nbsp;&nbsp;

				<li><a href="#"> <img src="/Foodi/css/icon/kook.png" width="50"
						height="50" />
				</a></li>&nbsp;&nbsp;

				<li><a href="#"> <img src="/Foodi/css/icon/chat.png" width="50"
						height="50" />
				</a></li>&nbsp;&nbsp;

				<li><a href="#" id="notify"> <img
						src="/Foodi/css/icon/notification.png" width="50" height="50" />
				</a></li>&nbsp;&nbsp;

				<li><a href="/Foodi/userInfo/logout.do" method="post"> <img
						src="/Foodi/css/icon/logout.png" width="50" height="50" />
				</a></li>&nbsp;&nbsp;
			</ul>
		</c:if>
		<!-----------------------  로그인하지 않았을 경우 나타날 화면  ----------------------->
		<c:if test="${loginUser == null}">
			<ul>
				<li><a href="/Foodi/login.jsp"> <img src="/Foodi/css/icon/logout.png"
						width="50" height="50" />
				</a></li>&nbsp;&nbsp;
				<li><a href="/Foodi/join.jsp"> <img src="/Foodi/css/icon/join.png"
						width="50" height="50" />&nbsp;&nbsp;
				</a></li>
			</ul>
		</c:if>
		<!---------------------------------------------------------------------->
	</div>
	</nav>


	<div id="menuBar" class="hidden">
		<!-------------------------  로그인 했을경우 나타날 화면  ------------------------->
		<c:if test="${loginUser != null}">
			<ul>
				<li>프로필사진 <img src="upload/${loginUser.userImg}" width="50"
					height="50" />
				</li>
				<br>

				<li>닉네임 ${loginUser.userNick}</li>
				<br>

				<li><a href="#">News Feed</a></li>
				<br>

				<li><a href="#">Time Line</a></li>
				<br>

				<li><a href="#">Follow</a></li>
				<br>

				<li><a href="#">Setting</a></li>
				<br>
			</ul>
		</c:if>
		<!-----------------------  로그인하지 않았을 경우 나타날 화면  ----------------------->
		<c:if test="${loginUser == null}">
			<ul>
				<li><a href="/Foodi/login.jsp">로그인 하세욧</a></li>
			</ul>
		</c:if>
		<!---------------------------------------------------------------------->
	</div>

	<!---------------- 알림 추가시킬 영역 토글버튼으로 히든클래스 설정 ------------------>
	<div id="notifyList" class="hidden"></div>





</body>
</html>