<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		회원정보 수정 <br>
		<form action="userinfo/updateUserInfo.do" method="post">
			<ul>
				<li>${loginUser.userImg}</li>
			</ul>
			<ul>
				<li><input type="file" accept="image/*" name="updateUserImg"></li>
			</ul>


			<ul>
				<li>닉네임 : </li>
				<li><input type="text" name="updateUserNick"></li>
			</ul>
			
			
			<ul>
				<li>현재 비밀번호 : </li>
				<li><input type="password" name="originalPass"></li>
			</ul>
			<ul>
				<li>새 비밀번호 : </li>
				<li><input type="password" name="updatePass"></li>
			</ul>
			<ul>
				<li>새 비밀번호 확인 : </li>
				<li><input type="password" name="updatePassCheck"></li>
			</ul>
			
			
			<ul>
				<li>E-mail 변경 : </li>
				<li><input type="text" name="updateEmail"></li>
				<li>인증 버튼</li>
			</ul>
			<ul>
				<li>이메일 인증번호 : </li>
				<li><input type="text" name="certificationNumber"></li>
				<li>확인버튼</li>
			</ul>
			
			<ul>
				<li><input type="submit" value="변경하기"></li>
				<li><a href="#">취소하기</a></li>
			</ul>
		</form>
	</div>
</body>
</html>