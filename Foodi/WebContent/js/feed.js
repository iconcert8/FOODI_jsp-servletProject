
function getFeedList(successFunc){
	$.ajax({
		url : '/Foodi/feed/newsfeedList.do',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		error: function(error){console.log(error);},
		success : function(data){
			successFunc(data)
		}
	});  
}

function getFeed(feedNo, successFunc){
	$.ajax({
		url : '/Foodi/feed/get',
		type : 'get', 
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : {"feedNo" : feedNo},
		error: function(error){console.log(error);},
		success : function(data){
			successFunc(data);
		}

	});
}