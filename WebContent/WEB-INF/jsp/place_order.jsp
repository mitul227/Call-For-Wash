<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place Order</title>
<link href="${pageContext.request.contextPath}/resources/css/account.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/drop_dwn.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/jquery/jquery-ui.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<div class="top_bar navbar navbar-fixed-top">
    <div class="container-fluid">
        <div class="row">
        	<div class="col-lg-12">
            	<div class="col-lg-4 col-md-4 heading">
                	Call-For-Wash
            	</div>
            	<div class="col-lg-offset-10 col-sm-offset-9 col-md-offset-10 col-xs-offset-6">
                	<div class="drop_down">
                    	<div class="drop_btn"><span class="glyphicon glyphicon-user"></span> &nbsp;<span class="glyphicon glyphicon-menu-down"></span></div>
                        	<div class="drop_content">  
                            	<a href="/callforwash/logout"><span class="glyphicon glyphicon-off"></span> &nbsp;&nbsp;Log Out</a>
                        	</div>
                	</div>
            	</div>
        	</div>
    	</div>
	</div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-2 col-md-2 left_bar sidebar-nav-fixed affix">
            <a href="/callforwash/home"><h3 id="home"><span class="glyphicon glyphicon-home"></span> &nbsp;Home</h3></a>
            <legend style="color: #000000"></legend>
            <a href="/callforwash/home/details"><h3 id="details"><span class="glyphicon glyphicon-list-alt"></span> &nbsp;Details</h3></a>
            <legend></legend>
            <a href="/callforwash/home/password"><h3 id="password"><span class="glyphicon glyphicon-eye-close"></span> &nbsp;Password</h3></a>
            <legend></legend>
        </div>
        <div class="col-lg-8 col-md-8 col-lg-offset-3 col-md-offset-3 main">
        	<h1>Place Order</h1><br>
        	<form action="/callforwash/home/order_placed" method="post" class="col-lg-12 col-lg-offset-1">
        		<div class="row">
        			<div class="form-group col-lg-6 col-md-6">
        				<select name="serviceType" class="form-control" id="service">
        					<option value="" hidden>Select Service</option>
                        	<option  value="Dry Cleaning">Dry Cleaning</option>
                        	<option value="Wash And Iron">Wash And Iron</option>
                    	</select>
                	</div>
                	<div class="col-lg-6 col-md-6">
                		<p id="error_service" class="error"></p>
                		<form:errors path="order.serviceType" class="error" />
                	</div>
                </div>
                <div class="row">
                	<div class="form-group col-lg-6 col-md-6">
                		<b>Address</b>
                		<textarea rows="5" name="address" class="form-control" id="address">${userAddress }</textarea>
                	</div>
                	<div class="col-lg-6 col-md-6">
                		<p class="error" id="error_address"></p>
                		<form:errors path="order.address" class="error" />
                	</div>
                </div>
                <div class="row">
                	<div class="form-group col-lg-6 col-md-6">
                		<b>Number</b>
                		<input class="form-inline form-control" type="text" value=${phoneNo } name="phoneNo" readonly>
                	</div>`
                </div>
                <div class="row">
                	<div class="form-group col-lg-6 col-md-6">
                		<b>Pickup Date</b>
                		<input class="form-control" id="pickup_date" name="pickupDate" readonly>
                	</div>
                	<div class="col-lg-6 col-md-6">
                		<p class="error" id="error_date"></p>
                		<form:errors path="order.pickupDate" class="error" />
                	</div>
                </div>
                <div class="row">
                	<div class="form-group col-lg-6 col-md-6">
                		<b>Pickup Time</b>
                        <select name="pickupTime" class="form-control" id="time">
				        	<option value="" hidden>Pickup Time</option>
				            <option value="8:00  - 10:00 am" id="1">&nbsp;8:00 &nbsp; - 10:00 am</option>
				            <option value="10:00 - 12:00 am" id="2">10:00 &nbsp;- 12:00 am</option>
				            <option value="12:00 - 2:00 pm" id="3">12:00 &nbsp;- &nbsp;2:00 &nbsp;pm</option>
				            <option value="2:00  - 4:00 pm" id="4">&nbsp;2:00 &nbsp; - &nbsp;4:00 &nbsp;pm</option>
				            <option value="" id="5" hidden>Booking Slots for today are closed</option>
			            </select>
                   	</div>
                 	<div class="col-lg-6 col-md-6">
                     	<p class="error" id="error_time"></p>
                        <form:errors path="order.pickupTime" class="error" />
                    </div>
                </div>
                <br>
                <div class="row">
                	<button type="submit" class="btn btn-primary" style="margin:15px">Submit</button>
                </div>
        	</form>
        </div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/account.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/place_order.js"></script>
</body>
</html>