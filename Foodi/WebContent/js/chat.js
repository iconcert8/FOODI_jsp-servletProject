/**
 * 
 */

var request = new Request();
var resId = request.getParameter("resId");
var lastNo = 0;
var setAsyncTime = 1000;

//get방식 parameter 가져오기
function Request() {
	var requestParam = "";
	this.getParameter = function (param) {
		var url = decodeURI(location.href);
		
		var paramArr = (url.substring(url.indexOf('?') + 1, url.length)).split('&');
		
		for(var i=0; i < paramArr.length; i++) {
			var temp = paramArr[i].split("=");
			
			if(temp[0].toUpperCase() == param.toUpperCase()) {
				requestParam = paramArr[i].split("=")[1];
				break;
			}
		}
		return requestParam;
	}
}

function reqMsg() {
	let chatTest = $('textarea[name="chatMsg"]');
	
	var sendMsg = {
		"chatMsg" : chatTest.val(),
		"resId" : resId
	}
	console.log(sendMsg);
	
	chatTest.val('');
	
	$.ajax({
		type: "post",
		url: "send",
		data : sendMsg,
		dataType: "json",
		error: function () {
			 console.log('reqMsg post fail');
		},
		success: function(data) {
			console.log('reqMsg post success');
			updateView(data);
		},
		complete : function () {
			console.log('reqMsg post done');
		}
	});
}

function resList() {
	$.ajax({
		type : "post",
		url : "reslist",
//     			data : {"resId" : resId},
		data : "resId="+ resId,
		dataType: "json",
		success : function (data) {
			console.log('resList success');
			$.each(data, function(i, item) {
				var div = $('<div></div>');
// 						if(i.chatImg != null) {
// 							div.append('<img src="'+ i.chatImg +'"/>');
// 						}
				if(item.resId != null) {
					div.append('<span>' + item.resId + '</span>');
					div.appendTo('#resList');
				} else if(item.selected != null){
					div.append('<span class="resSelected">' + item.selected + ' / selected</span>');
					div.appendTo('#resList');
				}
			})
		},
		error : function() {
			console.log('resList fail');
		}
	});
}



function chatView() {
	$.ajax({
		type: "get",
        url: "get",
        data: {"resId" : resId},
        dataType : "json",
        success: function (data) {
			console.log('chatView get success');
			
//			임시처리
			$('#chatView').empty();
			
			$.each(data, function(i, item) {				
				drawMsg(i, item, data);
			});
			async();
		},
		error : function (data) {
			console.log('chatView get fail');
			setTimeout(resMsg, 5000);
		}
	});	
}

function updateView(data) {
	$.each(data, function(i, item) {
		if(item.chatNo > lastNo) {
			drawMsg(i, item, data);
		}
	});
}

function updateCheckRead(data) {
	$.each(data, function(i, item) {
		if($('.user > .read').last().css('display') != 'none') {
//			보낸사람이 상대방이면
//			console.log('reqId : ' + item["reqId"] + ', resId : ' + resId);
			if(item.reqId == resId) {		
				$('.user > .read').text('0');
				$('.user > .read').hide();
//			상대방이 읽은것이 확인되면
			} else if(item.chatChk == 0) {
				$('.user > .read').text('0');
				$('.user > .read').hide();
			}
		}
	});
}

// message 그리기
function drawMsg(i, item, data) {
	if(resId == item.reqId) {				
		$('<div class="res"></div>').append(item.reqId + '/test To : ' + item.resId + '<br>')
			.append('<span class="resMsg">' + item.chatMsg + '&nbsp;</span>')
			.append('<span class="date">' + item.chatDate + '&nbsp;</span>')
			.append('<span class="read">' + item.chatChk + '</span>')
			.appendTo('#chatView');
	} else {
		$('<div class="user"></div>').append(item.reqId + '/test To : ' + item.resId + '<br>')
		.append('<span class="read">' + item.chatChk + '&nbsp;</span>')
		.append('<span class="date">' + item.chatDate + '&nbsp;</span>')
		.append('<span class="resMsg">' + item.chatMsg + '</span>')
		.appendTo('#chatView');
	}
	if(data.length -1 == i) {
		lastNo = item.chatNo;
		console.log('lastNo : ' + lastNo);
	}
	if($('.res > .read').last().css('display') != 'none') {
		if($('.res > .read').last().text() == 0) {
			$('.res > .read').hide();
		}
	}
}

function async() {
	$.ajax({
		type : "get",
		url : "async",
		data : {
			"lastNo" : lastNo,
			"resId" : resId
		} ,
		dataType : "json",
		success: function(data) {
			console.log('async success');
			if(data != null) {
				updateView(data);
				updateCheckRead(data);
			}
		},
		error: function() {
			console.log('async fail');
		},
		complete: function() {
			setTimeout(function() {
				async();
			}, setAsyncTime);
		}
	});
}

//클릭 이벤트
$(function() {
	$(document).on('click', '#resList > div', function() {
		let res = $(this).text();
		console.log(res);
		location.href = 'view?resId='+res;
	});
	
	$('textarea[name="chatMsg"]').keydown(function(event) {
		if (event.keyCode == 13) {
			event.preventDefault();
            reqMsg();
        }
	})
})

resList();
chatView();