/**
 * 
 */
$(document).ready(function(){
	$(".drop_down").hover(function(){
        $(".drop_content").slideToggle("fast");
        $(".drop_down").toggleClass("show");
    });
	
	$(".msg").show('slide',{direction:'right'},2000);
});