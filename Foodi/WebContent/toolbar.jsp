<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/toolbar.js"></script>
<link rel="stylesheet" href="css/toolbar.css">
</head>
<body>
	<header>

	<div id="menuButton">
		<a class="top_left_button" href="#">Toggle Button</a>

	</div>

	<div id="menuBar" class="hidden">
	
	<!-------------------------  로그인 했을경우 나타날 화면  ------------------------->
		<c:if test="${loginUser != null}">
			<ul>
				<li>프로필사진
					<img src="upload/${loginUser.userImg}" width="50" height="50" />
				</li>
				
				<li>닉네임 ${loginUser.userNick}
				</li>
				
				<li><a href="#">News Feed</a>
				</li>
				
				<li><a href="#">Time Line</a>
				</li>
				
				<li><a href="#">Follow</a>
				</li>
				
				<li><a href="#">Setting</a>
				</li>
			</ul>
		</c:if>
	<!-----------------------  로그인하지 않았을 경우 나타날 화면  -----------------------> 
		<c:if test="${loginUser == null}">
			<ul>
				<li><a href="login.jsp">로그인 하세욧</a></li>
			</ul>
		
		</c:if>	
	<!---------------------------------------------------------------------->
	</div>
	
	
	<div id="searchForm">
		<form action="search/searchresult.do" method="post">
			검색어: <input type="text" name="searchKeyword" />
			<input type="submit" value="검색" />
		</form>
	</div>



	<!-------------------------  로그인 했을경우 나타날 화면  ------------------------->
	<div id="userMenu">
		<c:if test="${loginUser != null}">
			<ul>
				<li><a href="makeFeed.jsp">
					<img src="css/icon/write.png" width="50" height="50" />
				</a></li>
	
				<li><a href="#">
					<img src="css/icon/favorite.png" width="50" height="50" />
				</a></li>
	
				<li><a href="#">
					<img src="css/icon/chat.png" width="50" height="50" />
				</a></li>
	
				<li><a href="#" id="notify">
					<img src="css/icon/notification.png" width="50" height="50" />
					</a>
					<div id="notifyList" class="hidden">
						<!---------------- 알림 추가시킬 영역 토글버튼으로 히든클래스 설정 ------------------>
				</div></li>
	
				<li><a href="userInfo/logout.do" method="post">
					<img src="css/icon/logout.png" width="50" height="50" />
				</a></li>
			</ul>
		</c:if>
	<!-----------------------  로그인하지 않았을 경우 나타날 화면  -----------------------> 
		<c:if test="${loginUser == null}">
			<ul>
				<li><a href="login.jsp">
					<img src="css/icon/logout.png" width="50" height="50" />
				</a></li>
				<li><a href="join.jsp">
					<img src="css/icon/join.png" width="50" height="50" />
				</a></li>
			</ul>
		</c:if>
	<!---------------------------------------------------------------------->
			
			
	</div>
	

	</header>



</body>
</html>