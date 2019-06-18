$(function() {
	$("#menuButton").click(function() {
		$("#menuBar").toggleClass("hidden");
		event.preventDefault();
	});
})