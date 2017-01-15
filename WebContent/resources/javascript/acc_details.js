/**
 * 
 */

$(document).ready(function(){
    $("#name").focusout(function(){
        check_name();
    });

    $("#mobile").focusout(function(){
        check_mobile()
    });

    $("#address").focusout(function(){
        check_address()
    });

//    $("button").click(function(e){
//    	//e.preventDefault();
//    	$("#dialog_confirm").dialog({
//    		buttons : {
//    			"OK" : function(){
//    				
//    			},
//    			"CANCEL" : function(){
//    				$(this).dialog("close");
//    			}
//    		},
//    		title:"Confirm",
//    		draggable:false,
//    		modal:true,
//    	});
//    });
    
    function check_name(){
        $("#error_name").text("");
        if($("#name").val().length == 0){
            $("#error_name").text("Name cannot be blank");
            return false;
        }
        return true;
    }

    function check_mobile(){
        $("#error_mobile").text("");
        if($("#mobile").val().length != 10){
            $("#error_mobile").text("Enter a 10 digit Mobile Number");
            return false;
        }
        else{
            var mob = $("#mobile").val();
            if(isNaN(mob)){
            	$("#error_mobile").text("Enter a valid Mobile Number");
                return false;
            }
            return true;
        }
    }

    function check_address(){
        $("#error_address").text("");
        if($("#address").val().length == 0){
            $("#error_address").text("Address cannot be blank");
            return false;
        }
        return true;
    }

    $("form").submit(function(){
        if(check_name() && check_mobile() && check_address()){
            return true;
        }
        else{
            return false;
        }
    });
});