function readURL(input) {
	
	$("#feedImg").change(function() {
		readURL(this);
	});

	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$("#preview").attr("src", e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

$(function() {
	$("#feedImg").change(function() {
		readURL(this);
	});
})