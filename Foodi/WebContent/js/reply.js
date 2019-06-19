



//'feed' should be like this
//var reply = '{"feedNo": feedNo, "replyContent":replyContent}';
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