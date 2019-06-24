$(document).ready(function(){
	getList()

})

function getList(){
	$.ajax({
		url : 'feed/newsfeedList.do',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"feedNo" : "feedNo"},
		success : successHandler,
		error: function(error){console.log(error);}

	}); 

	$.ajax({
		url : 'feed/newsfeedReply.do',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"feedNo" : "12"},
		success : successFootler,
		error: function(error){console.log(error);}

	});
 
} 

function successHandler(data){ 
	//배열 , 키
	$.each(data, function(index, item){

		var html = '<div class="view">'; 
		html += '<div class="cont">';
		html += '<div class="fn1">' + item.feedNo + '</div>';
		html += '<div class="fn2">' + item.userId + '</div>';
		html += '<div class="fn3">' + item.feedContent + '</div>';
		html += '<div class="fn4">' + item.feedImg + '	</div>';
		html += '<div class="fn5">' + item.feedImgs + '</div>';
		html += '<div class="fn6">' + item.feedGoodCount + '</div>';
		html += '<div class="fn7">' + item.feedLoc + '</div>';
		html += '<div class="fn8">' + item.feedDate + '</div>';
		html += '<div class="fn9">' + item.feedUpdate + '</div>';
		html += '<div class="fn10">' + item.feedLock + '</div>'; 
		html += '<table border="1" class="fnd">';
		html += '<tr>';
		html += '<td class="fnd1"><button value="good" >좋아요</button></td>';
		html += '<td class="fnd3"><button class="sbn_view" value="reply">댓글</button></td>';
		html += '<td class="fnd2"><button value="qook">쿡</button></td>';		
		html += '<input type="button" class="sbn_view1" value="상세페이지">';
		html +=  '<a href="feed/newsfeedDetail.do?feedNo=' + item.feedNo + '">상세</a>';
		html += '</tr>'; 
		html +=	'</table>'; 
		html += '</div>';
		html += '<br><br>';
		$('#nfList').append(html).trigger("create");
	}); 	 

} 
 
function successFootler(data){
	$.each(data, function(index, item){
		var html = '<tr>'; 
		html += '<td>' + item.feedNo + '</td>';
		html += '<td>' + item.replyNo + '</td>';
		html += '<td>' + item.userId + '</td>';
		html += '<td>' + item.feedContent + '</td>';
		html += '</tr>';
		$('#nfrList').append(html).trigger("create");

	});	
}  
			


