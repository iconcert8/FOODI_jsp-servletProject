var firstCnt = 0;
var secondCnt = 0;

$(document).ready(function(){
	htgList();
	
	$('.arrowRight').on('click', function(){
		$parent = $(this).parent();
		$ul = $parent.find("ul");
		if($ul.css("width") > '1280px'){
			console.log($ul.css("left"));
			if($ul.css("left") == '0px'){
				$ul.animate({
					left:"-1280px"
				}, 1000)
			}
		}
	});
	$('.arrowLeft').on('click', function(){
		$parent = $(this).parent();
		$ul = $parent.find("ul");
		if($ul.css("width") > '1280px'){
			if($ul.css("left") < '0px'){
				$ul.animate({
					left:"0px"
				}, 1000)
			}		
		}
		
		
	});

});
function htgList(){
	$.ajax({
		url: '/Foodi/tag/listHTG',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		error: function(error){console.log(error);},
		success: function(data){
			if(data[1] == null){
				htgFeedList1("");
				$("#firstH3").html("#최근피드");			
				$("#secondH3").html("#최근피드");			
			}else{
				htgFeedList1(data[0].tagName, $("#firstUl"));
				$("#firstH3").html(data[0].tagName);
				htgFeedList2(data[1].tagName, $("#secondUl"));
				$("#secondH3").html(data[1].tagName);
			}
		}
	});
}
function htgFeedList(tagName){
	$.ajax({
		url: '/Foodi/feed/listTagFeed',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {'tagName':tagName},
		error: function(error){console.log(error);},
		success: function(data){
			$.each(data, function(index, item){
				if(firstCnt < 8){
					firstCnt++;
					var html = 
						'<li>' +
						'<div>'+
						item.feedImg+'<br>'+
						item.feedContent+
						'</div>'+
						'<div>'+
						item.userId+
						'</div>'+
						'</li>';
					$("#firstUl").append(html).trigger("create");					
				}else{
					secondCnt++;
					var html = 
						'<li>' +
						'<div>'+
						item.feedImg+'<br>'+
						item.feedContent+
						'</div>'+
						'<div>'+
						item.userId+
						'</div>'+
						'</li>';
					$("#secondUl").append(html).trigger("create");
				}
			});
			if(firstCnt > 4){
				$("#firstUl").css("width", "2560px");				
			}
			if(secondCnt > 4){
				$("#secondUl").css("width", "2560px");				
			}
		}
	});
}
function htgFeedList1(tagName, $ul){
	$.ajax({
		url: '/Foodi/feed/listTagFeed',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {'tagName':tagName},
		error: function(error){console.log(error);},
		success: function(data){
			$.each(data, function(index, item){
				firstCnt++;
				var html = 
					'<li>' +
						'<div>'+
							item.feedImg+'<br>'+
							item.feedContent+
						'</div>'+
						'<div>'+
							item.userId+
						'</div>'+
					'</li>';
				$ul.append(html).trigger("create");
			});
			if(firstCnt > 4){
				$ul.css("width", "2560px");				
			}
		}
	});
}
function htgFeedList2(tagName, $ul){
	$.ajax({
		url: '/Foodi/feed/listTagFeed',
		type: 'get',
		dataType: 'json',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {'tagName':tagName},
		error: function(error){console.log(error);},
		success: function(data){
			$.each(data, function(index, item){
				secondCnt++;
				var html = 
					'<li>' +
					'<div>'+
					item.feedImg+'<br>'+
					item.feedContent+
					'</div>'+
					'<div>'+
					item.userId+
					'</div>'+
					'</li>';
				$ul.append(html).trigger("create");
			});
			if(secondCnt > 4){
				$ul.css("width", "2560px");				
			}
		}
	});
}