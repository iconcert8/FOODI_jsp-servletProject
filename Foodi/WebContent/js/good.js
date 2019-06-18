
//var feed = {"feedNO":feedNO, "feedContent": feedContent, "feedImg":feedImg};
//insert good
function goodInsert(userId, feed, $this, successFunction){
	$.ajax({
		url: '/Foodi/good/insert',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"userId": userId, "feed":feed},
		success: function(data){
			successFunction(data, $this);
		}
	});
}

//delete good
function goodDelete(resId, feedNo, $this, successFunction){
	$.ajax({
		url: '/Foodi/good/delete',
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
function notificationInsertGood(userId, feedNo, successFunction){
	$.ajax({
		url: '/Foodi/notify/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"userId":userId, "feedNo":feedNo, "type":"good"},
		success: function(data){
			successFunction(data);
		}
	});
}