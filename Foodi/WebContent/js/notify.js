document.write("<script type='text/javascript' src='/Foodi/js/dateFormat.js'></script>");
var ntfSum = 0;
var ntfChk = 0;
$(document).ready(function(){
	notifyList();
	notifyChat();
	
	setInterval(function(){
		notifyChkNew();
		notifyChat();
	}, 8000);
	
	$(document).on('click', ".notCheck", function(){
		var $this = $(this);
		var notifyNo = $this.val();
		notifyUpdateChk(notifyNo, $this);
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
			$.each(data, function(index, item){
				ntfSum++;
				if(item.notifyChk == 'false'){
					ntfChk++;
				}
				
				var html;
				if(item.notifyChk == 'false'){
					html = '<li value="'+item.notifyNo+'" class="notCheck">';
				}else{
					html = '<li value="'+item.notifyNo+'">';
				}
					html += 	'<b>'+item.notifyMsg+'</b><br>'
						 +		'<label>'+item.notifyDate.substr(0, 16)+'</label>'
						 + '</li>';
				
				$("#ntfList").prepend(html).trigger("create");
			});
			var text;
			if(ntfChk > 99){
				text = '99+';
			}else{
				text = ntfChk;
			}
			$("#notifyNum").text(text);
		}
	});
}

function notifyUpdateChk(notifyNo, $this){
	$.ajax({
		url: '/Foodi/notify/updateChk',
		type: 'get',
		data:{'notifyNo':notifyNo},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		error: function(error){console.log(error);},
		success: function successHandler(data){
			$this.removeClass("notCheck");
			
			ntfChk -= 1;
			var text;
			if(ntfChk > 99){
				text = '99+';
			}else{
				text = ntfChk;
			}
			$("#notifyNum").text(text);
		}
	});
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

