<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<style type="text/css">
input {
	apperance: none;
	-webkit-apperance: none;
}

/* �巡�� ����� ������ ���� ǥ�� */
#space {
	width: 500px;
	height: 50px;
	background-color: lightgray;
}

li {
	display: inline;
}
</style>

</head>
<body>
	<form action="feed/feedInsert.do" method="post"
		enctype="multipart/form-data">
		<ul>
			<li>�ۼ���</li>
			<li><%-- ${userId } --%></li>
		</ul>
		<ul>
			<li>����</li>
			<li><textarea row="10" cols="50" name="feedContent"></textarea></li>
		</ul>
		<ul>
			<li>�±� </li>
			<li><input type="text" name="tag"></li>
		</ul>
		<ul>
			<li>�⺻����</li>
			<li><input type="file" name="feedImg"></li>
		</ul>
		<ul>
			<li>�߰�����</li>
			<li><input multiple="multiple" id="space" type="file" name="feedImgs[]"></li>
		</ul>
		<ul>
			<li>��ġ</li>
			<li><input type="text" name="feddLoc"></li>
		</ul>
		<ul>
			<li><input type="submit" value="�ۼ��ϱ�"></li>
			<li><a href="#">���ư���(������������)</a></li>
		</ul>
	</form>

</body>
</html>