/**
 * 
 */
$(document).ready(function(){
	//$(".con").fadeIn("fast");
	
	$("#msg").show('slide',{direction:'left'},3700);
	
	//$(".name").show('slide',{direction:'left'},1000);
	
	$("img").show('slide',{direction:'left'},1200);
	//$(".name").show('bounce');
	
//	$("#msg").fadeIn(2000);
//	
//	$("#msg").animate({
//		marginLeft:'+=300px',
//		//height:'+=50px',
//		fontSize:'+=30px',
//	},
//	{
//		duration:1000,
//		easing:"linear",
//	});
	
	
//	$("p").hover(function(){
//		$(this).animate({
//			//marginTop:'-=100px',
//			fontSize:'+=30px',
//			//width:'+=130px'
//		});
//	},
//	function(){
//		$(this).animate({
//			//marginTop:'+=100px',
//			fontSize:'-=30px',
//			//width:'-=130px'
//		});
//	});
	
	
	var mob = true;
	var pass = true;
	$("form").submit(function(){
		$("#wrong_info").text("");
		$("#error_mob").text("");
		$("#error_pass").text("");
		mob = check_mob();
		pass = check_pass();
		if(mob && pass){
			return true;
		}
		else{
			return false;
		}
	});
	function check_mob(){
		if($("#mobile_log").val().length == 0){
            $("#error_mob").text("Field cannot be left blank");
            return false;
        }
		else{
			var mob = $("#mobile_log").val();
            if(isNaN(mob)){
            	$("#error_mob").text("Please Enter a valid Mobile Number");
                return false;
            }
            return true;
		}
	}
	function check_pass(){
		if($("#password_log").val().length == 0){
            $("#error_pass").text("Field cannot be left blank");
            return false;
        }
		else{
			return true;
		}
	}
	
	/*$(".acc_btn").click(function(){
		if($(".login").dialog( "isOpen" )){
			$(".login").dialog( "close" );
		}
		$(".signup").dialog({
			width:'500px',
			show:'slideDown',
			hide:'slideUp',
			//modal:true,
			position: { my: "center", at: "top", of: window, collision:"fit" }
		});
        //$(".login").hide();
        //$(".acc_btn").hide();
        //$(".signup").fadeIn("fast");
        //$(".log_btn").fadeIn("fast");
    });

    $(".log_btn").click(function(){
    	if($(".signup").dialog( "isOpen" )){
			$(".signup").dialog( "close" );
		}
    	$(".login").dialog({
			width:'500px',
			show:'slideDown',
			hide:'slideUp',
			//modal:true,
			//position: { my: "center", at: "center", of: window }
		});
        //$(".signup").hide();
        //$(".log_btn").hide();
        //$(".login").fadeIn("fast");
        //$(".acc_btn").fadeIn("fast");
    });*/
	
});