$(document).ready(function(){
	
	//follow search
	$(document).on("click", "#flwSearch", function(){
		$.ajax({
			url: '/Foodi/follow/listSearch',
			type: 'get',
			dataType: 'json',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {"flwSearchKey" : $("input[name=flwSearch]").val()},
			success: successHandler
		});
		function successHandler(data){
			console.log(data);
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
	});
	
	//followerList follow
	$(document).on("click", "#flrList .nofln",function(){
		//add following
		$.ajax({
			url: '/Foodi/follow/insert',
			type: 'get',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {"userId": $(this).val()},
			success: successHandler
		});
		var $this = $(this);
		var val = $(this).val();
		function successHandler(data){
			$this.removeClass("nofln").addClass("fln").html("팔로잉");		
			var $flnList = $("#flnList");
			var html = '<li fln="'+val+'" value="'+val+'">';
				html += 	'<label>'+val+'</label> ';
				html += 	'<button class="fln" name="userId" value="'+val+'">'+'팔로잉</button>';
				html += '</li>';
			$flnList.prepend(html).trigger("create");
		}
		
		//add notification
		notifyInsert(val);
		
		
		
	});
	//followerList follow cancel
	$(document).on("click", "#flrList .fln", function(){
		$.ajax({
			url: '/Foodi/follow/delete',
			type: 'get',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {"userId": $(this).val()},
			success: successHandler
		});
		var $this = $(this);
		var val = $(this).val();
		function successHandler(data){
			$this.removeClass("fln").addClass("nofln").html("팔로우");
			var li = 'li[fln='+val+']';
			$(li).remove();
		}
	});
	
	
	//followingList follow cancel
	$(document).on("click","#flnList .fln", function(){
		$.ajax({
			url: '/Foodi/follow/delete',
			type: 'get',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {"userId": $(this).val()},
			success: successHandler
		});
		var $this = $(this);
		var val = $(this).val();
		function successHandler(data){
			$this.removeClass("fln").addClass("nofln").html("팔로잉 취소");	
			var button = 'button[flr='+val+']';
			$(button).removeClass("fln").addClass("nofln").html("팔로우");
		}
	});
	//followingList follow refollow
	$(document).on("click","#flnList .nofln", function(){
		$.ajax({
			url: '/Foodi/follow/insert',
			type: 'get',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {"userId": $(this).val()},
			success: successHandler
		});
		var $this = $(this);
		var val = $(this).val();
		function successHandler(data){
			$this.removeClass("nofln").addClass("fln").html("팔로잉");
			var button = 'button[flr='+val+']';
			$(button).removeClass("nofln").addClass("fln").html("팔로잉");
		}
		
		//add notification
		notifyInsert(val);
		
	});
	
});

function notifyInsert(resId){
	$.ajax({
		url: '/Foodi/notify/insert',
		type: 'get',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data: {"resId":resId, "type":"follow"},
		success: function successHandler(data){
			alert("팔로우 함");
		}
	});
}