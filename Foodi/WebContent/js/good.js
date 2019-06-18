

//insert good
function goodInsert(feedNo, $this, successFunction){
	$.ajax({
		url: '/Foodi/good/insert',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"feedNo":feedNo},
		success: function(data){
			successFunction(data, $this);
		}
	});
}

//delete good
function goodDelete(feedNo, $this, successFunction){
	$.ajax({
		url: '/Foodi/good/delete',
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
function notificationInsertGood(resId, feed, successFunction){
	$.ajax({
		url: '/Foodi/notify/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"resId":resId, "feed":feed, "type":"good"},
		success: function(data){
			successFunction(data);
		}
	});
}