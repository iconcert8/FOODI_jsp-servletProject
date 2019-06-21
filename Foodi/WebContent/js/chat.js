/**
 * 
 */

//var request = new Request();
//var resId = request.getParameter("resId");
var resId = '';
var lastNo = 0;
var setAsyncTime = 1000;
var asyncInterval;


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
				selectUser();
			}
		},
		error: function() {
			console.log('first fail');
		},
		complete: function() {
			resList(resId);
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
			if(!asyncInterval) {
				async();
			}
		},
		complete : function () {
			console.log('reqMsg post done');
		}
	});
}

//person list
function resList(resId, newUser) {
	$.ajax({
		type : "post",
		url : "reslist",
//     			data : {"resId" : resId},
		data : {
			"resId" : resId,
			"new" : newUser
		},
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
					div.append('<span class="resSelected">' + item.selected + '</span>');
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
			
			$('#chatView').empty();
			
			$.each(data, function(i, item) {				
				drawMsg(i, item, data);
			});
		},
		error : function (data) {
			console.log('chatView get fail');
			setTimeout(chatView, 5000);
		}
	});	
}

//대화상대 정보
function selectUser() {
	$.ajax({
		type: "post",
        url: "resInfo",
        data: {"resId" : resId},
        dataType : "json",
        success: function (data) {
			console.log('selectUser success');
			drawResInfo(data);
			
			chatView();	
			resList(resId);
			if(!asyncInterval) {
				async();
			}
		},
		error : function (data) {
			console.log('cselectUser fail');
		}
	});
}

//상대 정보 draw
function drawResInfo(data) {
	$('#resInfo').empty();
	if(data.userImg) {
		$('<img alt="profile image" src="upload_thumbImg/' + data.userImg + '"></img>').appendTo('#resInfo');
	}
	$('<span class="resId">' + data.userId + '</span><br>').appendTo('#resInfo');
	$('<span class="resNick">' + data.userNick + '</span><br><hr>').appendTo('#resInfo');
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

var date = [];

// message 그리기
function drawMsg(i, item, data) {
	dateT = item.chatDate.split(":");
	dateDay = dateT[0] + '년 ' + dateT[1] + '월 ' + dateT[2] + '일';
	if(!date.includes(dateDay)) {
		date.push(dateDay);
		$('<div class="dateDay"></div>').text(dateDay).appendTo('#chatView');
	}
	
	if(parseInt(item.chatDel)) {
		dateTime = (dateT[3] < 12 ? '오전 ' + dateT[3] : '오후 ' + (dateT[3] - 12)) + ':' + dateT[4];
		if(resId == item.reqId) {
			var divres = $('<div class="res"></div>');
			divres.append(item.reqId + '/test To : ' + item.resId + '<br>')
				.append('<input type="hidden" class="chatNo" value="' + item.chatNo + '"></input>')
				.append('<span class="resMsg">' + item.chatMsg + '&nbsp;</span>')
				.append('<span class="date">' + dateTime + '&nbsp;</span>');
			if(parseInt(item.chatChk)){
				divres.append('<span class="read">' + item.chatChk + '</span>');
			}
			divres.appendTo('#chatView');
		} else {
			var divuser = $('<div class="user"></div>');
			divuser.append(item.reqId + '/test To : ' + item.resId + '<br>')
				.append('<input type="hidden" class="chatNo" value="' + item.chatNo + '"></input>');
			if(parseInt(item.chatChk)){
				divuser.append('<span class="read">' + item.chatChk + '&nbsp;</span>');
			}
			divuser.append('<span class="date">' + dateTime + '&nbsp;</span>')
				.append('<span class="resMsg">' + item.chatMsg + '</span>&nbsp;<button value="del" class="delete">del</button>')
				.appendTo('#chatView');
		}
	}
	if(data.length -1 == i) {
		lastNo = item.chatNo;
		console.log('lastNo : ' + lastNo);
		date = [];
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
			asyncInterval = setTimeout(function() {
				async();
			}, setAsyncTime);
		}
	}); 
}

function clickList() {

}

//이벤트 리스너생성
$(function() {
	//클릭 이벤트
	$(document).on('click', '#resList > div', function() {
		var res = $(this).text();
		resId = res;
		selectUser();
	});
	
//	enter키
	$('textarea[name="chatMsg"]').keydown(function(event) {
//		키코드 이벤트 유무 검사
		var keyCode = event.keyCode ? event.keyCode : event.which;
		if (keyCode == 13) {
			event.preventDefault();
            reqMsg();
        }
	});
	
//	사용자 검색
	$('#search').keyup(function(event) {
		var keyCode = event.keyCode ? event.keyCode : event.which;
		if (keyCode == 13) {
			event.preventDefault();
			searchCheck($(this).val());
        }
	});
	
//	검색 자동완성
	$('#search').autocomplete({
		 source: function( request, response ) {
			 $.ajax({
				type : 'post',
				url : 'searchFollow',
				dataType : 'json',
				data : { keyword : request.term },
				success: function(data) {
					response(data);
				},
				error: function () {
					console.log('search fail');
				}			
			});
		},
//		select: function( event, selected ) {
//	        console.log(selected.item.value);
//	        searchCheck(selected.item.value);
//	    }
	});
})

//새로운 대화상대 추가 검사
function searchCheck(keyword) {
	$.ajax({
		url: 'searchCheck',
		type: 'post',
		dataType : 'json',
		data : { 'resId' : keyword },
		success : function(data) {
			if(data) {
				if(data.resId) {
					resId = data.resId;
					selectUser();
				} else {
					clearTimeout(asyncInterval);
					asyncInterval = null;
					resId = data.userId;
					drawResInfo(data);
					$('#chatView').empty();
					resList(null, data.userId);
				}
			} else {
				clearTimeout(asyncInterval);
				asyncInterval = null;
				$('#resInfo').empty();
				$('#chatView').empty();
				$('#resInfo').html('<span>Follow목록에 없는 ID입니다.</span>');
			}
		}
	})
	
}

//var selectMsg;
//삭제버튼
$(document)
// 마우스 오른쪽 버튼 메뉴
//.on("contextmenu", '.resMsg', function(event) { 
//    event.preventDefault();
//    selectMsg = event.target;
//    $('.custom-menu').hide();
//    $("<div class='custom-menu'><ul><li id='delete'>삭제</li></ul></div>")
//        .appendTo("body")
//        .css({top: event.pageY + "px", left: event.pageX + "px"});
//}).on("click", function(event) {
//    $("div.custom-menu").hide();
//})
.on('click', '#chatView .delete', function(event) {
	var del = confirm("Do you want to delete message?");
	if(del) {
		$.ajax({
			type : 'post',
			url : 'delete',
			data : {
				'chatNo' : $(this).parent().find('input.chatNo').val()
			},
			success: function(data) {
				console.log(data);
			}
		});
		$(this).parent().hide();
	}
});

first();

