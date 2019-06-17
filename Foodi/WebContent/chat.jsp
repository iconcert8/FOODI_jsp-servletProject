<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>messenger</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
     <script src="https://npmcdn.com/axios/dist/axios.min.js"></script>
    <script type="text/javascript">
    	function reqMsg() {
    		let chatTest = $('textarea[name="chatMsg"]');
    		let resId = $('input[name="res"]').val();
    		let sendMsg = {
    			"chatMsg" : chatTest.val(),
    			"res" : resId
    		}
    		console.log(sendMsg);
    		
    		$.ajax({
    			type: "post",
    			url: "send",
    			data : sendMsg,
    			dataType: "text",
    			seccess: function (data) {
    				console.log('post success');
				},
				error: function () {
					 console.log('post fail');
				},
				complete : function () {
					console.log('post done');
				}
    		});	
    	}
    	
    	function resMsg() {
    		$.ajax({
    			type: "get",
                url: "async",
                success: function (data) {
					console.log('get success');
    				resMsg();
				},
				error : function (data) {
					console.log('get fail');
    				setTimeout(resMsg, 5000);
				}
			});	
    	}
    	
    	function resList() {
    		$.ajax({
    			type : "post",
    			url : "reslist",
    			dataType: "json",
    			success : function (data) {
    				console.log('resList success');
					$.each(data, function(i, item) {
						console.log('each execute' + item);
						var div = $('<div></div>');
// 						if(i.chatImg != null) {
// 							div.append('<img src="'+ i.chatImg +'"/>');
// 						}
						div.append('<span>' + item + '</span>');
						div.appendTo('#resList');
					})
				},
				error : function() {
					console.log('resList fail');
				}
    		});
    	}
    	
    	var first;
    	function firstSelect() {
    		$.ajax({
    			type : "get",
    			url : "firstselect",
    			dataType: "text",
    			success : function (data) {
    				console.log('firstSelect success');
					first = data;
					console.log(first);
				},
				error : function() {
					console.log('firstSelect fail');
				}
				complete : function () {
					
				}
    		});
    	}
    	
    	
    	resList();
    
    </script>
</head>
<body>
	<header>
		채팅창입니다.
	</header>
	<nav>
		<c:if test="${member.userImg}">
			<img alt="profile Img" src="thum/${member.userImg }">
		</c:if>
		<span>${member.userId }</span><br>
		<span>${member.userNick }</span>
	</nav>
		<hr>
	<section>
<%-- 		<c:forEach var="chat" items="${chatList }"> --%>
<%-- 			<div>ID : ${chat.reqId } / To : ${chat.resId }<br>${chat.chatDate } &nbsp; ${chat.chatMsg } <br> --%>
<%-- 			<c:if test="${chat.chatChk >= 1 }">안읽음</c:if> --%>
<%-- 			<c:if test="${chat.chatChk < 1 }">읽음</c:if> --%>
<!-- 			</div> -->
<%-- 		</c:forEach> --%>
	</section>
	<aside id="resList">
	
	</aside>
	
	<footer>
		<form action="view" method="post">
			<textarea rows="3" cols="100" name="chatMsg" autofocus="autofocus"></textarea>
			<input type="hidden" value="def" name="res">
			<input type="button" value="send" onclick="reqMsg()">
<!-- 			<input type="submit" value="send"> -->
		</form>
	</footer>
</body>
</html>