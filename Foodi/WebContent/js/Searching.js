$(document).ready(function(){
	
	
	$(document).on("click","#ssgbtn", function(){
		var searchKeyword=$('#searchKeyword').text();
		ssgInsert(searchKeyword,$(this));
	});
	
});














//insert follow
function ssgInsert(searchKeyword, $this){
	$.ajax({
		url: '/Foodi/search/ssg',
		type: 'post',
		data: {"searchKeyword": searchKeyword},
		error: function(error){console.log(error);},
		success: function(data){
			//data return resId
			$(this).val('complete');
			alert("ok");
		}
	});
}