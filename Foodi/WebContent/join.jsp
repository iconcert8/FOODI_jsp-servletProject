<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	

</script>
</head>
<body>
	<div class = "container">
		<form action="userinfo/join.do" method="post">
			<table>
				<tr>
					<td>회원 가입</td>
				</tr>
				
				<tr>
					<td>아이디</td>
					<td><input type="text" maxlength="20"></td>
					<td><input type="button" onclick="checkFunction();" value="중복체크"></td> 
				</tr>
				
				<tr>
					<td>닉네임</td>
					<td><input type="text" maxlength="20"></td> 
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td><input type = "password" name ="userPassword1" maxlength="20">
				</tr>
				
				<tr>
					<td>비밀번호 확인</td>
					<td><input type = "password" name ="userPassword2" maxlength="20">
				</tr>
				
				
				
				<tr>
					<td> <input type="submit" value="입력"></td>
					
				</tr>
				
			
			
			
			</table>
		</form>
	
	
	</div>



</body>
</html>