document.write("<script type='text/javascript' src='/Foodi/js/dateFormat.js'></script>");
var ntfSum = 0;

$(document).ready(function(){
	notifyList();
	notifyChat();
	
	setInterval(function(){
		notifyChkNew();
		notifyChat();
	}, 8000);
	
	$(document).on('click', ".notCheck", function(){
		notifyUpdateChk();
	});
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
			var ntfChk = 0;
			$.each(data, function(index, item){
				ntfSum++;
				if(item.notifyChk == 'false'){
					ntfChk++;
				}
				
				var html;
				if(item.notifyChk == 'false'){
					html = '<li class="notCheck">';
				}else{
					html = '<li>';
				}
					html += 	'<b>'+item.notifyMsg+'</b><br>'
						 +		'<label>'+item.notifyDate.substr(0, 16)+'</label>'
						 + '</li>';
				
				$("#ntfList").prepend(html).trigger("create");
				console.log(item.notifyDate);
			});
			var text;
			if(ntfSum > 99){
				text = '99+';
			}else{
				text = ntfSum;
			}
			$("#notifyNum").text(text);
		}
	});
}

function notifyUpdateChk(){
	
}

function notifyChat(){
	$.ajax({
		url: '/Foodi/chat/notify',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function successHandler(data){
			var text;
			if(Number(data) > 99){
				text = '99+';
			}else{
				text = data;
			}
			$("#chatNum").text(text);
		}
	});
}

$(document).on("click", function(event) {
    $("#ntfBox").hide();
})

