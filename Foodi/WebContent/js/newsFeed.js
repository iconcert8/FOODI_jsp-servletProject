document.write("<script type='text/javascript' src='/Foodi/js/good.js'></script>");
document.write("<script type='text/javascript' src='/Foodi/js/qook.js'></script>");
document.write("<script type='text/javascript' src='/Foodi/js/reply.js'></script>");
document.write("<script type='text/javascript' src='/Foodi/js/dateFormat.js'></script>");

$(document).ready(function(){
	getList()
	
	$(document).on('click', '.detail_btn',function(){
		getFeed($(this).val());
		$("#lightBox").removeClass("black");	
		$("#lightBox").addClass("light");	
	}); 
	$(document).on('click', '#close',function(){
		$('#feedInfoBox').empty();
		$('#replyBox').empty();
		$("#lightBox").removeClass("light");	
		$("#lightBox").addClass("black");	
	});
	
	$(document).on('click', '#replySend', function(){
		var feedNo = $(this).val();
		var feedContent = $(this).attr("feedcontent");
		var replyContent = $("#replyText").val();
		var resId = $(this).attr("resid");
		replyInsert(feedNo, feedContent, replyContent, resId, function(feedNo){
			$("#replyBox").empty();
			$("#replyText").empty();
			replyGet(feedNo, successReply);
		});
	});
	
	$(document).on('click', '.isNotGood', function(){
		var $this = $(this);
		var feedNo = $this.val();
		goodInsert(feedNo, $this, function(data, $this){
			$this.removeClass("isNotGood").addClass("isGood");
			var resId = $this.attr("resid");
			var feedNo = $this.val();
			var feedContent = $this.attr("feedcontent");
			var feed = '{"feedNo":"'+feedNo+'", "feedContent": "'+feedContent+'"}';
			notificationInsertGood(resId, feed, function(){console.log("insert good notify ok");});			
		});
	})
	$(document).on('click', '.isGood', function(){
		var $this = $(this);
		var feedNo = $this.val();
		goodDelete(feedNo, $this, function(data, $this){$this.removeClass("isGood").addClass("isNotGood");});
	})
	$(document).on('click', '.isNotQook', function(){
		var $this = $(this);
		var feedNo = $this.val();
		qookInsert(feedNo, $this, function(data, $this){
			$this.removeClass("isNotQook").addClass("isQook");
			var resId = $this.attr("resid");
			var feedNo = $this.val();
			var feedContent = $this.attr("feedcontent");
			var feed = '{"feedNo":"'+feedNo+'", "feedContent": "'+feedContent+'"}';
			notificationInsertQook(resId, feed, function(){console.log("insert qook notify ok");});
		});
	})
	$(document).on('click', '.isQook', function(){
		var $this = $(this);
		var feedNo = $this.val();
		qookDelete(feedNo, $this, function(data, $this){$this.removeClass("isQook").addClass("isNotQook");});
	})
})

function getList(){
	$.ajax({
		url : '/Foodi/feed/newsfeedList.do',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		success : successList,
		error: function(error){console.log(error);}

	});  
}

function getFeed(feedNo){
	$.ajax({
		url : '/Foodi/feed/get',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"feedNo" : feedNo},
		error: function(error){console.log(error);},
		success : successFeed

	});
}

function successList(data){ 
	$.each(data, function(index, item){
		var html ='<li class="feed">'
				+	'<div class="feed_top">'
				+		'<a href="/Foodi/timeline/timeline?userId=${'+item.userId+'}"><img alt="ProfImg" src="'+item.userImg+'" class="feed_userimg"/></a>'
				+		'<a href="/Foodi/timeline/timeline?userId=${'+item.userId+'}"><label class="feed_userid">'+item.userId+'</label></a>'				
				+		'<div class="feed_date">'+item.feedDate+'</div>'
				+		'<div class="feed_content">'+item.feedContent+'</div>'
				+	'</div>'
				+	'<div class="feed_middle">'
				+		'<img alt="no images" src="'+item.feedImg+'" class="feed_img"/>'
				+	'</div>'
				+	'<div class="feed_bottom">';
			if(item.isGood == ""){
				html += '<button class="isNotGood" value="'+item.feedNo+'" resid="'+item.userId+'" feedcontent="'+item.feedContent+'">좋아요</button>';
			}else{
				html += '<button class="isGood" value="'+item.feedNo+'" resid="'+item.userId+'" feedcontent="'+item.feedContent+'">좋아요</button>'
			}
			if(item.isQook == ""){
				html += '<button class="isNotQook" value="'+item.feedNo+'" resid="'+item.userId+'" feedcontent="'+item.feedContent+'">쿡</button>';
			}else{
				html += '<button class="isQook" value="'+item.feedNo+'" resid="'+item.userId+'" feedcontent="'+item.feedContent+'">쿡</button>';				
			}
			html+=		'<button class="detail_btn" value="'+item.feedNo+'">상세보기</button>'
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
	var html='<div class="reply_top">'
		+		'<a href="/Foodi/timeline/timeline?userId=${'+data.userId+'}"><img alt="ProfImg" src="'+data.userImg+'" class="feed_userimg"/></a>'
		+		'<a href="/Foodi/timeline/timeline?userId=${'+data.userId+'}"><label class="feed_userid">'+data.userId+'</label></a>'				
		+		'<div class="feed_date">'+data.feedDate+'</div>'
		+		'<div class="feed_content">'+data.feedContent+'</div>'
		+	'</div>'
		+	'<div class="reply_middle">'
		+		'<img alt="no images" src="'+data.feedImg+'" class="feed_img"/>'
		+	'</div>'
		+	'<div class="reply_bottom">';
	if(data.isGood == ""){
		html += '<button class="isNotGood" value="'+data.feedNo+'" resid="'+data.userId+'" feedcontent="'+data.feedContent+'">좋아요</button>';
	}else{
		html += '<button class="isGood" value="'+data.feedNo+'" resid="'+data.userId+'" feedcontent="'+data.feedContent+'">좋아요</button>'
	}
	if(data.isQook == ""){
		html += '<button class="isNotQook" value="'+data.feedNo+'" resid="'+data.userId+'" feedcontent="'+data.feedContent+'">쿡</button>';
	}else{
		html += '<button class="isQook" value="'+data.feedNo+'" resid="'+data.userId+'" feedcontent="'+data.feedContent+'">쿡</button>';				
	}
		html +=	'</div>'
		+	'<div>'
		+		'<textarea id="replyText"></textarea>'+'<button id="replySend" value="'+data.feedNo+'" resid="'+data.userId+'" feedcontent="'+data.feedContent+'">작성</button>'
		+	'</div>';
	$("#feedInfoBox").append(html).trigger("create");
	
	replyGet(data.feedNo, successReply);
}
 
function successReply(data){
	$.each(data, function(index, item){
		var html= '<p>'
			+		'<b>'+item.userId +'</b>'+'<label> '+new Date(item.replyDate.time).format("yyyy/MM/dd HH:mm") +'</label><br>'
			+		'<label>'+item.replyContent +'</label>'
			+ '</p>';
		$("#replyBox").append(html).trigger("create");
	});	
}  



