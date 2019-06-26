document.write("<script type='text/javascript' src='/Foodi/js/follow.js'></script>");

$(function() {
	$("#feedBarButton").click(function() {
		$("#feedBar").toggleClass("hidden");
		event.preventDefault();
	});
	
	var userId = $("#flwBtn").attr("userId");
	
	isFollow($("#flwBtn").attr("userId"), function(data){
		var html = '';
		
		if(data.info.isFollow == ""){
			html += '<button class="nofln" value="'+userId+'">팔로우';
		}else{
			html += '<button class="fln" value="'+userId+'">팔로우 취소';
		}
		html += '</button>';
		
		$("#flwBtn").append(html).trigger("create");
	});
	
	//followerList follow
	$(document).on("click", ".nofln",function(){
		//add following
		var resId = $(this).val();
		followInsert(resId, $(this), function(data, $this){
			$this.removeClass("nofln").addClass("fln").html("팔로우취소");
		});
		notificationInsertFollow(resId, function(){});
	});
	
	//followerList follow cancel
	$(document).on("click", ".fln", function(){
		var resId = $(this).val();
		followDelete(resId, $(this), function(data, $this){
			$this.removeClass("fln").addClass("nofln").html("팔로우");
		});
	});
});
