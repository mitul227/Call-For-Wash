/**
 * 
 */

$(document).ready(function(){
	
	$("form").submit(function(){
        $("#error_service").text("");
        $("#error_address").text("");
        $("#error_date").text("");
        $("#error_time").text("");
		if( $("#service").val() == ""){
            $("#error_service").text("Please select a service");
            return false;
        }
        if( $("#address").val() == ""){
            $("#error_address").text("Please provide an address");
            return false;
        }
        if( $("#pickup_date").val() == ""){
            $("#error_date").text("Please select a pickup date");
            return false;
        }
        if( $("#time").val() == ""){
            $("#error_time").text("Please select a pickup time");
            return false;
        }
	});
	
	$("#pickup_date").datepicker({//showOn : 'both',
		dateFormat : 'dd-M-yy',
		//buttonImage : "images/calendar-128.png",
    	//buttonImageOnly: true,
		minDate : new Date(),
		maxDate : +7,
		onSelect : function(){
			$('#time').prop('selectedIndex',0);
			$("#5").hide();
			var date = new Date().getDate();
			var selectedDate = $(this).datepicker('getDate');
			if(selectedDate.getDate() == date){
				var time = new Date().getHours();
				if(time >= 8){
					$("#1").css("display","none");
				}
				if(time >= 10){
					$("#2").hide();
				}
				if(time >= 12){
					$("#3").hide();
				}
				if(time >= 14){
					$("#4").hide();
					$("#5").show();
				}
			}
			else{
				$("#1").show();
				$("#2").show();
				$("#3").show();
				$("#4").show();
			}
		}
		});
	});