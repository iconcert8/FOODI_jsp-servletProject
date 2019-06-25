

//insert qook
function qookInsert(feedNo, $this, successFunction){
	$.ajax({
		url: '/Foodi/qook/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"feedNo":feedNo},
		error: function(error){console.log(error);},
		success: function(data){
			successFunction(data, $this);
		}
	});
}

//delete qook
function qookDelete(feedNo, $this, successFunction){
	$.ajax({
		url: '/Foodi/qook/delete',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"feedNo":feedNo},
		error: function(error){console.log(error);},
		success: function(data){
			successFunction(data, $this);
		}
	});
}


//'feed' should be like this
//var feed = '{"feedNo":"feedNo", "feedContent": "feedContent"}';
//insert notification
function notificationInsertQook(resId, feed, successFunction){
	$.ajax({
		url: '/Foodi/notify/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"resId":resId, "feed":feed, "type":"qook"},
		error: function(error){console.log(error);},
		success: function(data){
			successFunction(data);
		}
	});
}