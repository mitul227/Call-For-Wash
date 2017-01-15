/**
 * 
 */

$(document).ready(function(){
    $("#new_pass").focusout(function(){
        check_password();
    });

    $("#new_pass_confirm").focusout(function(){
        check_password_eq();
    });

    function check_password(){
    	$("#error_pass_new").text("");
        $("#error_password").text("");
        $("#error_pass_eq").text("");
        if($("#new_pass").val().length < 6){
            $("#error_pass_new").text("Password should at least be 6 characters long");
            return false;
        }
        return true;
    }
    
    function check_password_eq(){
    	$("#error_pass_new").text("");
    	$("#error_password").text("");
        $("#error_pass_eq").text("");
        if($("#new_pass").val() != $("#new_pass_confirm").val()){
            $("#error_pass_eq").text("Passwords do not match");
            //$("#password").addClass("error_box");
            return false;
        }
        return true;
    }
    
    function check_password_curr(){
        $("#error_password").text("");
        if($("#curr_pass").val().length == 0){
            $("#error_password").text("Enter Old Password");
            //$("#password").addClass("error_box");
            return false;
        }
        return true;
    }

    $("form").submit(function(){
        if(check_password_curr() && check_password() && check_password_eq() ){
            return true;
        }
        else{
            return false;
        }
    });
});