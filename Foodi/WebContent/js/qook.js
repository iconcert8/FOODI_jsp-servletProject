

//insert qook
function qookInsert(feedNo, $this, successFunction){
	$.ajax({
		url: '/Foodi/qook/insert',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"feedNo":feedNo},
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
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"feedNo":feedNo},
		success: function(data){
			successFunction(data, $this);
		}
	});
}

//'feed' should be like this
//var feed = '{"feedNO":feedNO, "feedContent": feedContent, "feedImg":feedImg}';

//insert notification
function notificationInsertQook(resId, feed, successFunction){
	$.ajax({
		url: '/Foodi/notify/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"resId":resId, "feed":feed, "type":"qook"},
		success: function(data){
			successFunction(data);
		}
	});
}