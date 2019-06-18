

//insert qook
function qookInsert(userId, feedNo, $this, successFunction){
	$.ajax({
		url: '/Foodi/qook/insert',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"userId": userId, "feedNo":feedNo},
		success: function(data){
			successFunction(data, $this);
		}
	});
}

//delete qook
function qookDelete(userId, feedNo, $this, successFunction){
	$.ajax({
		url: '/Foodi/qook/delete',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"userId": userId, "feedNo":feedNo},
		success: function(data){
			successFunction(data, $this);
		}
	});
}

//insert notification
function notificationInsertQook(userId, feedNo, successFunction){
	$.ajax({
		url: '/Foodi/notify/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"userId":userId, "feedNo":feedNo, "type":"qook"},
		success: function(data){
			successFunction(data);
		}
	});
}