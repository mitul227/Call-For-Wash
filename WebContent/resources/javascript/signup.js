/**
 * 
 */

$(document).ready(function(){
	
	//$(".con").fadeIn("fast");
	$("img").show('slide',{direction:'left'},1000);
	
    $("#name").focusout(function(){
        check_name();
    });

    $("#mobile").focusout(function(){
        check_mobile()
    });

    $("#password").focusout(function(){
        check_password();
    });

    $("#address").focusout(function(){
        check_address()
    });

    function check_name(){
        $("#error_name").text("");
        if($("#name").val().length == 0){
            $("#error_name").text("Name cannot be blank");
            //$("#name").addClass("error_box");
            return false;
        }
        return true;
    }

    function check_mobile(){
        $("#error_mobile").text("");
        if($("#mobile").val().length != 10){
            $("#error_mobile").text("Enter a 10 digit Mobile Number");
            //$("#mobile").addClass("error_box");
            return false;
        }
        else{
            var mob = $("#mobile").val();
            if(isNaN(mob)){
            	$("#error_mobile").text("Please Enter a valid Mobile Number");
                return false;
            }
            return true;
        }
    }

    function check_password(){
        $("#error_password").text("");
        if($("#password").val().length < 6){
            $("#error_password").text("Password should at least be 6 characters long");
            //$("#password").addClass("error_box");
            return false;
        }
        return true;
    }

    function check_address(){
        $("#error_address").text("");
        if($("#address").val().length == 0){
            $("#error_address").text("Address cannot be blank");
            //$("#address").addClass("error_box");
            return false;
        }
        return true;
    }

    $("form").submit(function(){
        if(check_name() && check_mobile() && check_password() && check_address()){
            return true;
        }
        else{
            return false;
        }
    });
});