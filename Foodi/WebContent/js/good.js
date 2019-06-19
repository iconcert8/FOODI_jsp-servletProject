

//insert good
function goodInsert(feedNo, $this, successFunction){
	$.ajax({
		url: '/Foodi/good/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"feedNo":feedNo},
		error: function(error){console.log(error);},
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
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"feedNo":feedNo},
		error: function(error){console.log(error);},
		success: function(data){
			successFunction(data, $this);
		}
	});
}



//'feed' should be like this
//var feed = '{"feedNo":feedNo, "feedContent": feedContent}';

//insert notification
function notificationInsertGood(resId, feed, successFunction){
	$.ajax({
		url: '/Foodi/notify/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"resId":resId, "feed":feed, "type":"good"},
		error: function(error){console.log(error);},
		success: function(data){
			successFunction(data);
		}
	});
}