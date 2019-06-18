var ntfSum = 0;

$(document).ready(function(){
	notifyList();
	
	setInterval(function(){
		notifyChkNew();		
	}, 8000);
	
});


function notifyChkNew(){
	$.ajax({
		url: '/Foodi/notify/checkNew',
		type: 'get',
		dataType: 'json',
		data: {"ntfSum":ntfSum},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		error: function(error){console.log(error)},
		success: function(data){
			if(data.result > 0){
				notifyList(data.result);
			}
		}
	});
}


function notifyList(startRow){
	$.ajax({
		url: '/Foodi/notify/list',
		type: 'get',
		dataType: 'json',
		data: {"startRow": startRow},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function successHandler(data){
			console.log(data);
			var ntfChk = 0;
			$.each(data, function(index, item){
				ntfSum++;
				if(item.notifyChk == 'false'){
					ntfChk++;
				}
				var html = '<li>';
					html += 	item.notifyMsg;
					html += '</li>';
				$("#ntfList").prepend(html).trigger("create");
			});
		}
	});
}