<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Successful</title>
<link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/drop_dwn.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/order_placed.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/jquery/jquery-ui.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<div class="container-fluid">
    <div class="row top_bar">
        <div class="col-lg-12 col-md-12 col-sm-12">
            <div class="col-lg-4 col-md-6 col-sm-8 col-xs-10 heading">
               Order Placed
            </div>
            <div class="col-lg-2 col-md-2">
            	<a href="/callforwash/home"><button type="submit" class="btn btn-lg home"><span class="glyphicon glyphicon-home"></button></a>
            </div>
            <div class="col-lg-offset-10 col-md-offset-10 col-sm-offset-6">
                <div class="drop_down">
                    <div class="drop_btn"><span class="glyphicon glyphicon-user"></span> &nbsp;<span class="glyphicon glyphicon-menu-down"></span></div>
                        <div class="drop_content">
                            <a href="/callforwash/logout"><span class="glyphicon glyphicon-off"></span> &nbsp;&nbsp;Log Out</a>
                        </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-10 col-md-10 col-lg-offset-1 col-md-offset-1">
        	<div class="row">
        		<div class="col-lg-4 col-md-4">
        			<h1>Congratulations !</h1>
        		</div>
            	<div class="col-lg-8 col-md-8">
            		<p class="msg">${Msg }</p>
            	</div>
            </div>
            <h3>Order Details</h3>
            <table class="table table-bordered table-striped">
                <tr>
                    <td><b>Order ID</b></td>
                    <td>${order.order_id}</td>
                </tr>
                <tr>
                    <td><b>Phone Number</b></td>
                    <td>${order.phone_no}</td>
                </tr>
                <tr>
                    <td><b>Service</b></td>
                    <td>${order.service_type}</td>
                </tr>
                <tr>
                    <td><b>Address</b></td>
                    <td>${order.address}</td>
                </tr>
<!--                 <tr> -->
<!--                     <td><b>Order Items</b></td> -->
<%--                     <td>${order.description}</td> --%>
<!--                 </tr> -->
                <tr>
                    <td><b>Pickup Date</b></td>
                    <td>${order.pickup_date}</td>
                </tr>
                <tr>
                    <td><b>Pickup Time</b></td>
                    <td>${order.pickup_time}</td>
                </tr>
<!--                 <tr> -->
<!--                     <td><b>Bill</b></td> -->
<%--                     <td>Rs ${order.bill}</td> --%>
<!--                 </tr> -->
            </table>
            <br>
            <a href="/callforwash/home/place_order"><button type="button" class="btn btn-success btn-lg">Place Another Order</button></a>
        </div>
        
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/order_placed.js"></script>
</body>
</html>