

function replyGet(feedNo, successReply){
	$.ajax({
		url : '/Foodi/feed/getReply',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"feedNo" : feedNo},
		error: function(error){console.log(error);},
		success : successReply
	});
}

function replyInsert(feedNo, feedContent, replyContent, resId, successFunction){
	$.ajax({
		url : '/Foodi/feed/insertReply',
		type : 'get', 
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"feedNo" : feedNo, "replyContent":replyContent},
		error: function(error){console.log(error);},
		success: function(data){
			successFunction(feedNo);
			var reply = '{"feedNo": "'+feedNo+'", "feedContent":"'+feedContent+'", "replyContent":"'+replyContent+'"}';
			notificationInsertReply(resId, reply, function(){});
		}
	});
}

//'feed' should be like this
//var reply = '{"feedNo": feedNo, "feedContent":feedContent, "replyContent":replyContent}';
//insert notification
function notificationInsertReply(resId, reply, successFunction){
	$.ajax({
		url: '/Foodi/notify/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"resId":resId, "reply":reply, "type":"reply"},
		error: function(error){console.log(error);},
		success: function(data){
			successFunction(data);
		}
	});
}