/**
 * 
 */
$(document).ready(function(){
	
//	$(".main").animate({
//		wordSpacing:'+=50px',
//		fontSize:'+=5px',
//	},
//	{
//		duration:5000,
//		easing:"linear",
//	});
	
	
	$(".main").show('slide',{direction:'up'});
	
	$("#rate_btn").click(function(){
		$("#rate_card").dialog({
			title: "Rates",
			modal: true,
			draggable:false,
		});
	});
	
	$(".btns").hover(function(){
		$(this).animate({
			marginTop:'-=20px',
		},"fast");
	},
	function(){
		$(this).animate({
			marginTop:'+=20px',
		},"fast");
	});
	
    $(".drop_down").hover(function(){
        $(".drop_content").slideToggle("fast");
        $(".drop_down").toggleClass("show");
    });

    $("h3").hover(function(){
        $(this).animate({
            //fontSize:'+=5px',
            marginLeft:'+=23px',
        },"fast");
    },
    function(){
        $(this).animate({
            //fontSize:'-=5px',
            marginLeft:'-=23px',
        },"fast");
    });
});