

$(document).ready(function(){
	var ssg = [];
	$('.tagSSG').each(function(i, item) {
		ssg.push($(item).find('input').attr('name'));
	});
	
	if(ssg) {
		$.ajax({
			url : '/Foodi/search/ssgcheck',
			type : 'post',
			data : {
				"ssglist" : ssg.toString()
			},
			dataType : 'json',
			success : function(data) {
				console.log('ssg check success');
				$.each(data, function(i, elt) {
					$('.tagSSG').each(function(i, item) {
						if($(item).find('span.ssgName').text() == elt) {
							$(item).find('input').val('SSG').removeClass('ssgbtn').addClass('selectedSSG');
						}
					});
				});
			},
			error : function(data) {
				console.log(data);
			},
			complete : function() {
				ssg = [];
			}
		});
	}
	

	$(document).on("click",".tagSSG .ssgbtn", function(){
		var tagName=$(this).attr('name');
		ssgInsert(tagName,$(this));
	}).on("mouseenter",".tagSSG .selectedSSG", function(){
		$(this).val('SSG취소');
	}).on("mouseleave",".tagSSG .selectedSSG", function(){
		$(this).val('SSG');
	}).on("click",".tagSSG .selectedSSG", function(){
		var tagName=$(this).attr('name');
		ssgDelete(tagName,$(this));
	});
	
});


//insert ssg follow
function ssgInsert(tagName, element){
	$.ajax({
		url: '/Foodi/search/ssg',
		type: 'post',
		data: {"tagName": tagName},
		error: function(error){console.log(error);},
		success: function(data){
			console.log('ssg : ' + data);
			element.val('SSG').removeClass('ssgbtn').addClass('selectedSSG');
		}
	});
}

//delete ssg
function ssgDelete(tagName, element){
	$.ajax({
		url: '/Foodi/search/ssgCancel',
		type: 'post',
		data: {"tagName": tagName},
		error: function(error){console.log(error);},
		success: function(data){
			console.log('ssg : ' + data);
			element.val('SSG하기').removeClass('selectedSSG').addClass('ssgbtn');
		}
	});
}
