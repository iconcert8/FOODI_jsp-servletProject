/**
 * 
 */

//var request = new Request();
//var resId = request.getParameter("resId");
var resId = '';
var lastNo = 0;
var setAsyncTime = 1000;

//get방식 parameter 가져오기
/*function Request() {
	var requestParam = "";
	this.getParameter = function (param) {
		var url = decodeURI(location.href);
		
		var paramArr = (url.substring(url.indexOf('?') + 1, url.length)).split('&');
		
		for(var i=0; i < paramArr.length; i++) {
			var temp = paramArr[i].split("=");
			
			if(temp[0].toUpperCase() == param.toUpperCase()) {
				requestParam = paramArr[i].split("=")[1];
				console.log('resId : ' + requestParam);
				break;
			}
		}
		return requestParam;
	}
}*/

function first() {
	$.ajax({
		type: "get",
		url: "first",
		success: function (data) {
			console.log('first success');
			resId = data;
			if(resId) {
				chatView();
			}
		},
		error: function() {
			console.log('first fail');
		},
		complete: function() {
			resList();
		}
	});
}

//send Msg
function reqMsg() {
	let chatTest = $('textarea[name="chatMsg"]');
	
	var sendMsg = {
		"chatMsg" : chatTest.val(),
		"resId" : resId,
		"lastNo" : lastNo
	}
	console.log(sendMsg);
	
//	전송후 비우기
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

//person list
function resList() {
	$.ajax({
		type : "post",
		url : "reslist",
//     			data : {"resId" : resId},
		data : "resId="+ resId,
		dataType: "json",
		success : function (data) {
			console.log('resList success');
			$('#resList').empty();
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

//select
function chatView() {
	$.ajax({
		type: "post",
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
			setTimeout(chatView, 5000);
		}
	});	
}

//check read update
function updateCheckRead(data) {
	$.each(data, function(i, item) {
		if($('.user > .read').last().css('display') != 'none') {
//			보낸사람이 상대방이면
//			console.log('reqId : ' + item["reqId"] + ', resId : ' + resId);
			if(item.reqId == resId) {		
				$('.user > .read').text('0');
				$('.user > .read').hide();
//			자신이보낸 메세지를 상대방이 읽은것이 확인되면
			} else if(item.chatChk == 0) {
				$('.user > .read').text('0');
				$('.user > .read').hide();
			}
		}
	});
}


//draw check
function updateView(data) {
	$.each(data, function(i, item) {
		if(item.chatNo > lastNo) {
			drawMsg(i, item, data);
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

// 지속적 요청
function async() {
	$.ajax({
		type : "post",
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

function search() {
	
}


//검색 자동완성
//$( "#tags" ).autocomplete({
// source: availableTags
//});

//이벤트 리스너생성
$(function() {
	//클릭 이벤트
	$(document).on('click', '#resList > div', function() {
		var res = $(this).text();
		resId = res;
		chatView();
		resList();
	});
	
//	enter키
	$('textarea[name="chatMsg"]').keydown(function(event) {
//		키코드 이벤트 유무 검사
		var keyCode = event.keyCode ? event.keyCode : event.which;
		if (keyCode == 13) {
			event.preventDefault();
            reqMsg();
        }
	})
	
	$('#search').keydown(function(event) {
		var keyCode = event.keyCode ? event.keyCode : event.which;
		if (keyCode == 13) {
			event.preventDefault();
            search();
        } else {
        	
        }
	})
})

//오른쪽버튼 메뉴
$(document).on("contextmenu", '.resMsg', function(event) { 
    event.preventDefault();
    $('.custom-menu').hide();
    $("<div class='custom-menu'><ul><li>복사</li><li>삭제</li></ul></div>")
        .appendTo("body")
        .css({top: event.pageY + "px", left: event.pageX + "px"});
}).on("click", function(event) {
    $("div.custom-menu").hide();
});

first();

