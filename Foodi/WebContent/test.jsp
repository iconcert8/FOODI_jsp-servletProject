<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.js"></script>
<style type="text/css">
  .cont {display:none}

</style>
<script type="text/javascript">

/* 	$('button').colorbox({
		transition : 'fade',
		opactity : 0.0,
		onOpen : function(){
			alert('실행되었습니다.');
		},
		onClose : function(){
			alert('닫힙니다.');
		} 
	}); */
}); 
</script>
<title>Insert title here</title>
</head>
<body>
<!-- 	<h1>Header-0</h1>
	<h1>Header-1</h1>
	<h1>Header-2</h1>
	
	<br><br>
	
	<div>
		<h1>Header 1</h1>
		<p>Paragraph</p>
	</div>
	<div> 
		<h1>Header 2</h1>
		<p>Paragraph</p>
	</div>
	<div>
		<h1>Header 3</h1>
		<p>Paragraph</p>
	</div> -->
<div class="view">
시발
<div class="cont">내용</div>
<button type="button" class="sbn_view">내용보기</button>
</div>


<script>
$(function() {
    $(".sbn_view").on("click", function() {
        $(this).closest(".view").find(".cont").slideToggle();
    });
});
</script>
 
</body>
</html>