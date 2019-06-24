<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/Foodi/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/Foodi/js/newsFeed.js"></script>
<link rel="stylesheet" href="/Foodi/css/all.css">
<style type="text/css">

body{
	background-color: gray;
}

 

 #nfList{
    margin-bottom:20px;

	border-color: black;
 }
 .cont{
	padding:5px; 
	margin-bottom:10px;	
 	border:thin;
 	background-color: white;
 }
 
 .fnd{
 	margin-left:90px;
 }
 .fnd1, .fnd2, .fnd3{
 	width : 200px;
 	height: 50px;
 	text-align: center;
 	margin-bottom:30px;
 }
 
</style>
<title>Insert title here</title> 
</head>
<body>
	<%-- <jsp:include page="notify.jsp"></jsp:include>
	
	
	<table border="1" id="nfList">
		<tr>
			<td>피드번호</td>
			<td>ID</td>
			<td>내용</td>
			<td>피드이미지</td> 
			<td>피드 나머지 이미지들</td>
			<td>좋아요</td> 
			<td>피드 위치</td>
			<td>피드 작성 날짜</td>
			<td>피드 수정 날짜</td>
			<td>피드 공개 여부</td>
			<td>좋아요</td>
			<td>쿡</td>
			<td>댓글</td>
		</tr>
	</table>
	<h3>댓글</h3>
	<br>
	<div>
		<div id="nfrList">
			<c:forEach var="ReplyVO" items="${replyList}">
				<div>
					<b>${ReplyVO.userId }</b><span style="font-size: 6px;">${ReplyVO.replyDate}</span>
					<p>${ReplyVO.replyContent }</p>
				</div>
			</c:forEach>
		</div>
 
		<form action="feed/newsfeed.jsp" method="post">
			이름 : <input type="text" name="userId"><br> 내용 <br>
			<textarea cols="40" rows="2" name="feedContent"></textarea>
			<br> <input type="hidden" name="feedNo" value="${ReplyVO.feedNo}">
			<input type="submit" value="작성">
		</form>
	</div>
	

 
 <table border="1" id="nfrList">
 	<tr>
 		
 		<td>댓글번호</td>
 		<td>글번호</td>
 		<td>댓글제목</td>
 		<td>댓글내용</td>
 
 	</tr> 	
 </table> --%>
 
 	<nav>
		메뉴바 들어 갈 곳 
	</nav>
	<section> 
		<article id="left" class="side">
			<h3>Recent Writer</h3>
		</article>
		
		<article id="middle">  
 		<div id="nfList">
	</div>
 <div class="view">
 <div class="cont">
 <h2>글 상세 보기</h2>
	<div>
		<div>피드번호</div>
		<div>ID</div>
		<div>내용</div>
		<div>피드이미지</div>
		<div>피드 나머지 이미지</div>
		<div>좋아요</div>
		<div>피드 위치</div>
		<div>피드 작성 날짜</div>
		<div>피드 수정 날짜</div>
		<div>피드 공개 여부</div>
		<div>좋아요</div>
		<div>쿡</div>
		<div>댓글</div> 
	</div>
  <table border="1" id="nfrList">
 	<tr>
 		
 		<td>댓글번호</td>
 		<td>글번호</td>
 		<td>댓글제목</td>
 		<td>댓글내용</td>
 
 	</tr> 	
 </table>  
 	
 </div>
 <a href="newsfeedDetail.do?feedNo=${feedVO.feedNo}">상세</a>
</div>
		</article> 
		<article id="right" class="side">
			우측
		</article>		
	</section> 
	
<!-- <script type="text/javascript">
$(function() {
	$(".cont").hide(function(){
    $(".sbn_view").on("click", function() {
        $(this).closest(".view").find(".cont").slideToggle();
    });
    }); 
}); 
</script> -->
</body>
</html>