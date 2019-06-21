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
	
	
})