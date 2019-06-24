<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Foodi/css/member.css">
<title>Insert title here</title>
</head>
<body>
	<nav> 메뉴바 들어 갈 곳 </nav>
	<section> <!-- <article id="left" class="side">
			좌측
		</article>
		 -->

	<h2>회원 정보 수정</h2>

	<article id="middle">
		
		

	<div>
		<form action="userinfo/updateUserInfo.do" method="post">
			<div id="userimg"></div>
			<div id="jump"></div>
			<ul></ul>
			<ul>
				<li>${login4User.userImg}</li>
			</ul>
			<ul>
				<li><input  id="f1" type="file" a accept="image/*" name="updateUserImg"></li>
			</ul>


			<ul> 

				<li>닉네임&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="updateUserNick"></li>
			</ul>

			<div class="line"></div>
			<ul>
				<li>현재 비밀번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="password" name="originalPass"></li>
			</ul>
			<ul>

				<li>새 비밀번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="password" name="updatePass"></li>
			</ul>
			<ul>
				<li>새 비밀번호 확인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="password" name="updatePassCheck"></li>
			</ul>
	
			<div class="line"></div>

			<ul>
				<li>E-mail &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="updateEmail"><input id="ij" type="submit" value="인증"></li>
			</ul>
			<ul>

				<li>이메일 인증번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="certificationNumber"><input id="hi" type="submit" value="확인"></li>

			</ul>
			<ul class="ci">
				<input id="up" type="submit" value="변경하기">
				<a  href="#"><input id="ch" type="submit" value="취소하기"></a>
			</ul>
		</form> 
	</div>

	</article> <!-- 	<article id="right" class="side">
			우측 
		</article>	 --> </section>
</body>
</html>