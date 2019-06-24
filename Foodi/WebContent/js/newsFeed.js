$(document).ready(function(){
	getList()
	
	$(document).on('click', '.detail',function(){
		getFeed($(this).val());
		$("#lightBox").removeClass("black");	
		$("#lightBox").addClass("light");	
	}); 
	$(document).on('click', '#close',function(){
		$('#lightBox').empty();
		$("#lightBox").removeClass("light");	
		$("#lightBox").addClass("black");	
	});
	
	$(document).on('click', '#replySend', function(){
		var feedNo = $(this).val();
		var replyContent = $("#replyText").val();
		insertReply(feedNo, replyContent);
	});
})

function getList(){
	$.ajax({
		url : 'feed/newsfeedList.do',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		success : successList,
		error: function(error){console.log(error);}

	});  
}

function getFeed(feedNo){
	$.ajax({
		url : 'feed/get',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"feedNo" : feedNo},
		error: function(error){console.log(error);},
		success : successFeed

	});
}

function getReply(feedNo){
	$.ajax({
		url : 'feed/getReply',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"feedNo" : feedNo},
		error: function(error){console.log(error);},
		success : successReply

	});
}

function insertReply(feedNo, replyContent){
	$.ajax({
		url : 'feed/insertReply',
		type : 'get', 
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"feedNo" : feedNo, "replyContent":replyContent},
		error: function(error){console.log(error);},
		success : function(){}
	});
}

function successList(data){ 
	$.each(data, function(index, item){
		var html ='<li>'
				+	'<div>'
				+		'<div>'+item.userImg+'</div>'
				+		'<label>'+item.userId+'</label>'
				+	'</div>'
				+	'<div>'
				+		'<label>'+item.feedContent+'</label>'
				+		'<div>'+item.feedImg+'</div>'
				+	'</div>'
				+	'<button class="detail" value="'+item.feedNo+'">상세보기</button>'
				+	'<div>'
				+		'<button>좋아요</button>'+'<button class="detail" value="'+item.feedNo+'">댓글</button>'+'<button>쿡</button>'
				+	'</div>'
				+ '</li>';
		var writer ='<li>'
				+		'<div>'
				+			'<div>'+item.userImg+'</div>'
				+			'<label>'+item.userId+'</label>'
				+		'</div>'
				+	'</li>';
		$('#nfList').append(html).trigger("create");
		$('#wtrList').append(writer).trigger("create");
	}); 	 

}

function successFeed(data){
	var html='<b id="close">X</b>'
		+	'<div>'
		+		'<div>'+data.userImg+'</div>'
		+		'<label>'+data.userId+'</label>'
		+	'</div>'
		+	'<div>'
		+		'<label>'+data.feedContent+'</label>'
		+		'<div>'+data.feedImg+'</div>'
		+	'</div>'
		+	'<div>'
		+		'<button>좋아요</button>'+'<button>쿡</button>'
		+	'</div>'
		+	'<div>'
		+		'<input type="text" id="replyText">'+'<button id="replySend" value="'+data.feedNo+'">작성</button>'
		+	'</div>';
	$("#lightBox").append(html).trigger("create");
	
	getReply(data.feedNo);
}
 
function successReply(data){
	var html='<div>';
	$.each(data, function(index, item){
		html+= '<p>'
			+		'<b>'+item.userId +'</b>'+'<label> '+new Date(item.replyDate.time).format("yyyy/MM/dd HH:mm") +'</label><br>'
			+		'<label>'+item.replyContent +'</label>'
			+ '</p>';
	});	
	html += '</div>';
	$("#lightBox").append(html).trigger("create");
}  


Date.prototype.format = function(f) {
    if (!this.valueOf()) return " ";
 
    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    var d = this;
     
    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
        switch ($1) {
            case "yyyy": return d.getFullYear();
            case "yy": return (d.getFullYear() % 1000).zf(2);
            case "MM": return (d.getMonth() + 1).zf(2);
            case "dd": return d.getDate().zf(2);
            case "E": return weekName[d.getDay()];
            case "HH": return d.getHours().zf(2);
            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
            case "mm": return d.getMinutes().zf(2);
            case "ss": return d.getSeconds().zf(2);
            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
            default: return $1;
        }
    });
};
String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};


