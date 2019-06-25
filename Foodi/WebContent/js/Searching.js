

$(document).ready(function(){
	var ssg = [];
	$('.tagSSG').each(function(i, item) {
		ssg.push($(item).find('input').attr('name'));
	});
	
	$.ajax({
		url : '/Foodi/search/ssgcheck',
		type : 'post',
		data : {
			"ssglist" : ssg.toString()
		},
		dataType : 'json',
		success : function(data) {
			console.log('ssg check success');
			
		},
		error : function(data) {
			console.log(data);
		}
	})

	$(document).on("click",".tagSSG input[type=button]", function(){
		var tagName=$(this).attr('name');
		ssgInsert(tagName,$(this));
	});
	
});


//insert follow
function ssgInsert(tagName, element){
	$.ajax({
		url: '/Foodi/search/ssg',
		type: 'post',
		data: {"tagName": tagName},
		error: function(error){console.log(error);},
		success: function(data){
			console.log('ssg : ' + data);
			element.removeClass('ssgbtn');
		}
	});
}