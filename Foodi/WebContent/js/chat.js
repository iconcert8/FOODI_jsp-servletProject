/**
 * 
 */

var request = new Request();
var resId = request.getParameter("resId");
var lastNo = 0;

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
			console.log(data);
			
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
	$.each(data, function(i, elt) {
		if(elt.chatNo > lastNo) {
			drawMsg(i, elt, data);
		}
		if(elt.reqId == resId) {
			$('.user > .read').text('0');
			$('.user > .read').hide();
		} else if(elt.chatChk == 0) {
			$('.user > .read').text('0');
			$('.user > .read').hide();
		}
	})
	
}

// message 그리기
function drawMsg(i, item, data) {
	if(resId == item.reqId) {				
		$('<div class="res"></div>').append(item.reqId + '/test To : ' + item.resId + '<br>')
			.append('<span class="resMsg">' + item.chatMsg + '</span>&nbsp;')
			.append('<span class="date">' + item.chatDate + '</span>&nbsp;')
			.append('<span class="read">' + item.chatChk + '</span>')
			.appendTo('#chatView');
	} else {
		$('<div class="user"></div>').append(item.reqId + '/test To : ' + item.resId + '<br>')
		.append('<span class="read">' + item.chatChk + '</span>&nbsp;')
		.append('<span class="date">' + item.chatDate + '</span>&nbsp;')
		.append('<span class="resMsg">' + item.chatMsg + '</span>')
		.appendTo('#chatView');
	}
	if(data.length -1 == i) {
		lastNo = item.chatNo;
		console.log('lastNo : ' + lastNo);
		console.log(typeof lastNo);
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
			}
		},
		error: function() {
			console.log('async fail');
		},
		complete: function() {
			setTimeout(function() {
				async();
			}, 5000);
		}
	}); 
}

resList();
chatView();