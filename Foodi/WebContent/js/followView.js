document.write("<script type='text/javascript' src='/Foodi/js/follow.js'></script>");

$(document).ready(function(){
	
	followList(null, listView);	
	
	//follow search
	$(document).on("click", "#flwSearch", function(){
		var key = $("input[name=flwSearch]").val();
		followList(key, listView);
	});
	
	//followerList follow
	$(document).on("click", "#flrList .nofln",function(){
		//add following
		var resId = $(this).val();
		followInsert(resId, $(this), flrFollow);
		notificationInsertFollow(resId, function(){});
	});
	
	//followerList follow cancel
	$(document).on("click", "#flrList .fln", function(){
		var resId = $(this).val();
		followDelete(resId, $(this), flrFollowCancel);
	});
	
	//followingList follow cancel
	$(document).on("click","#flnList .fln", function(){
		var resId = $(this).val();
		followDelete(resId, $(this), flnFollowCancel);
	});
	
	//followingList follow refollow
	$(document).on("click","#flnList .nofln", function(){
		var resId = $(this).val();
		followInsert(resId, $(this), flnFollow);
		notificationInsertFollow(resId, function(){});
	});
	
});

function listView(data){
	$("#flrList").empty();
	$("#flnList").empty();
	$.each(data, function(index, item){
		if(index == 0){
			$.each(item, function(index2, item2){
				if(item2.isFollow){
					var html = '<li value='+item2.userId+'>';
					html += 	'<label>'+item2.userId+'</label> ';
					html += 	'<button flr="'+item2.userId+'" class="fln"';
					html += 		' value="'+item2.userId+'">팔로잉</button>';
					html += '</li>';
					$("#flrList").append(html).trigger("create");
				}else{
					var html = '<li value='+item2.userId+'>';
					html += 	'<label>'+item2.userId+'</label> ';
					html += 	'<button flr="'+item2.userId+'" class="nofln"';
					html += 		' value="'+item2.userId+'">팔로우</button>';
					html += '</li>';
					$("#flrList").append(html).trigger("create");
				}
			});					
		}else{
			$.each(item, function(index2, item2){
				var html = '<li fln="'+item2.userId+'" value='+item2.userId+'>';
				html += 	'<label>'+item2.userId+'</label> ';
				html += 	'<button class="fln" value="'+item2.userId+'">팔로잉</button>';
				html += '</li>';
				$("#flnList").append(html).trigger("create");
			});	
		}
	});
}


function flrFollow(data, $this){
	var li = 'li[fln='+$this.val()+']';
	$(li).remove();
	
	$this.removeClass("nofln").addClass("fln").html("팔로잉");		
	
	var $flnList = $("#flnList");
	var html = '<li fln="'+$this.val()+'" value="'+$this.val()+'">';
		html += 	'<label>'+$this.val()+'</label> ';
		html += 	'<button class="fln" name="userId" value="'+$this.val()+'">'+'팔로잉</button>';
		html += '</li>';
		
	$flnList.prepend(html).trigger("create");	
}

function flrFollowCancel(data, $this){
	$this.removeClass("fln").addClass("nofln").html("팔로우");
	var li = 'li[fln='+$this.val()+']';
	$(li).remove();
}

function flnFollowCancel(data, $this){
	$this.removeClass("fln").addClass("nofln").html("팔로잉 취소");	
	var button = 'button[flr='+$this.val()+']';
	$(button).removeClass("fln").addClass("nofln").html("팔로우");
}

function flnFollow(data, $this){
	$this.removeClass("nofln").addClass("fln").html("팔로잉");
	var button = 'button[flr='+$this.val()+']';
	$(button).removeClass("nofln").addClass("fln").html("팔로잉");
}