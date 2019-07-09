$("body").on("click", ".addCard", function(){
	$.post("/addCard", function(fragment){
		$("#playerHands").replaceWith(fragment);
	});
});