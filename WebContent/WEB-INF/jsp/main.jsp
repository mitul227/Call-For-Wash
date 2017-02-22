<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/front.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/jquery/jquery-ui.css"
	rel="stylesheet" type="text/css">

<title>Login Page</title>
</head>
<body>
<div class="container-fluid">
    <div class="row main">
        <div class="col-lg-12 name">
            Call-For-Wash
        </div>
    </div>
    <div class="row con">
    	<div class="col-lg-4 col-md-4">
            <div class="login">
                <h1>Log In</h1><br>
                <div class="login_form">
                	<form action="/callforwash/login" method="post" id="login">
                    	<div class="form-group">     
                        	Mobile <input class="form-control" type="text" placeholder="Mobile" name="phoneNo" id="mobile_log">
                        	<p id="error_mob" class="error"></p>
                        	<form:errors path="user.phoneNo" class="error"/>
                    	</div>
                    	<div class="form-group">  
                        	Password <input class="form-control" type="password" placeholder="Password" name="password" id="password_log">
                        	<p id="error_pass" class="error"></p>
                        	<form:errors path="user.password" class="error"/>
                    	</div>
                    	<p id="wrong_info" class="error">${Msg }</p>
                    	<br><button type="submit" class="btn btn-primary">Log In</button>
                	</form>
            	</div>
        	</div>
        </div>
        <div class="col-lg-4 col-md-4">
        	<img src="${pageContext.request.contextPath}/resources/images/or1.jpg" class="">
        </div>
        <div class="col-lg-4 col-md-4">
        	<a href="/callforwash/signup"><button class="btn-success btn-lg acc_btn" type="button">Create Account</button></a>
        </div>
  	</div>
  	<div class="row">
  		<div class="col-lg-offset-4 col-md-offset-4">
  			<p id="msg" style="display:none">Get Your First Order Absolutely Free !</p>
  		</div>
  	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/login.js"></script>
</body>
</html>