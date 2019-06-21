/*$.ajax({
	"url" : "newsfeedList.do",
	"type" : "get",
	"dataType" : "json",
	"data" : {"dataType" : "init"},
	"success" : function(data){
		alert("가져온 데이터 입니다." + data);
		var str = "<select id='newsfeedList'>";
		str += "<tr >";
		$.each(data, function(i,v){
			
			str += "<td>" + v.mem_id + "</td>";
		});
		str += "</tr>";
		$("#")
	}
	
	
})*/



$(document).ready(function(){
	getList()
})

function getList(){
	$.ajax({
		url : 'feed/newsfeedList.do',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"dataType" : "init"},
		success : successHandler,
		error: function(error){console.log(error);}
		
	}); 	
}
 
function successHandler(data){
	$.each(data, function(index, item){
		var html = '<tr>';
			html += '<td>' + item.feedNo + '</td>';
			html += '<td>' + item.userId + '</td>';
			html += '<td>' + item.feedContent + '</td>';
			html += '<td>' + item.feedImg + '</td>';
			html += '<td>' + item.feedImgs + '</td>';
			html += '<td>' + item.feedGoodCount + '</td>';
			html += '<td>' + item.feedDate + '</td>';
			html += '<td>' + item.feedUpdate + '</td>';
			html += '<td>' + item.feedLock + '</td>'; 
			html += '<td><button value="good" >좋아요</button></td>';
			html += '<td><button value="qook">쿡</button></td>'
			html += '<td><button value="reply">댓글</button></td>'
			html += '</tr>';
			$('#nfList').append(html).trigger("create");
	}); 
} 



