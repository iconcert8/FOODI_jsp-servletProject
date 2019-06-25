$(function() {
	$("#menuButton").click(function() {
		$("#menuBar").toggleClass("hidden");
		$(".menuOnOff").toggleClass("hidden");
		event.preventDefault();
	});
	
	$("#notify").click(function(event){
		$("#notifyList").toggleClass("hidden");
		
		event.preventDefault();
	});

	
	$("#logout").click(function(event){
		request.get
	});
	
	$('#searchSpace').autocomplete({
		source : function(request, response) {
			console.log(request.term);
			$.ajax({
				type:'post',
				url:'/Foodi/search/auto',
				data: {
					"search" : request.term
				},
				dataType : 'json',
				success : function(data) {
					if(data) {
						response(data);
					}
				},
				error : function() {
					console.log('error');
				}
			});
		},
		select: function(event, item) {
			location.href = '';
		}
	});
	
});
