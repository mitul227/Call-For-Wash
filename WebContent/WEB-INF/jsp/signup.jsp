<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<link href="${pageContext.request.contextPath}/resources/css/front.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/jquery/jquery-ui.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<div class="container-fluid">
	<div class="row main">
        <div class="col-lg-12">
            Call-For-Wash
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-4">
        	<div class="signup">
            	<h1>Sign Up</h1><br>
            	<div class="signup_form">
                	<form action="/callforwash/signup" method="post">
                    	<div class="form-group">
                        	<input class="form-control" placeholder="Name" type="text" name="name" id="name">
                        	<p id="error_name" class="error"></p>
                        	<form:errors path="user.name" class="error"/><br>
                        	<input class="form-control" placeholder="Number" type="text" name="phone_no" id="mobile">
                        	<p id="error_mobile" class="error"></p>
                        	<form:errors path="user.phone_no" class="error"/><br>
		                	<input class="form-control" placeholder="Password" type="password" name="password" id="password">
		                	<p id="error_password" class="error"></p>
		                	<form:errors path="user.password" class="error"/><br>
                        	<textarea class="form-control" rows=5 cols=40 name="address" placeholder="Address" id="address"></textarea>
                        	<p id="error_address" class="error"></p>
                        	<form:errors path="user.address" class="error"/><br><br>
		                	<button type="submit" class="btn btn-primary">Sign Up</button>
                    	</div>
                	</form>
            	</div>
        	</div>
    		<p class="error_exists">${Msg }</p>
        </div>
        <div class="col-lg-4 col-md-4">
        	<img src="${pageContext.request.contextPath}/resources/images/or2.jpg">
        </div>
        <div class="col-lg-4 col-md-4">
        	<a href="/callforwash/"><button class="btn-success btn-lg acc_btn" type="button">Log In</button></a>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/signup.js"></script>
</body>
</html>