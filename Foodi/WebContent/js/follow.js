
//list follow
function followList(key, successFunction){
	$.ajax({
		url: '/Foodi/follow/listSearch',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"flwSearchKey" : key},
		success: function(data){
			//data return followerList, followingList
			successFunction(data);
		}
	});
}


//insert follow
function followInsert(resId, $this, successFunction){
	$.ajax({
		url: '/Foodi/follow/insert',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"resId": resId},
		success: function(data){
			//data return resId
			successFunction(data, $this);
		}
	});
}

//delete follow
function followDelete(resId, $this, successFunction){
	$.ajax({
		url: '/Foodi/follow/delete',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"resId": resId},
		success: function(data){
			//data return resId
			successFunction(data, $this);
		}
	});
}

//insert notification
function notificationInsertFollow(resId, successFunction){
	$.ajax({
		url: '/Foodi/notify/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"resId":resId, "type":"follow"},
		success: function(data){
			//data return none
			successFunction(data);
		}
	});
}