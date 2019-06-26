document.write("<script type='text/javascript' src='/Foodi/js/feed.js'></script>");
document.write("<script type='text/javascript' src='/Foodi/js/lightBoxFeed.js'></script>");
document.write("<script type='text/javascript' src='/Foodi/js/dateFormat.js'></script>");

$(document).ready(function(){
	getFeedList(successList);
	lightBoxClickEvent(".detail_btn");
})

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



