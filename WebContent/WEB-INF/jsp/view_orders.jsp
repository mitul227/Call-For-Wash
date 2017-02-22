<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/account.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/drop_dwn.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
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
        <div class="col-md-offset-4 details">
        	<c:set var="er" value="${Msg }" />
        	<c:out value="${er }"/>
        </div>
        <c:if test="${empty er}">
        	<div class="col-lg-9 col-md-9 col-lg-offset-3 col-md-offset-3 main">
        		<h1>Order History</h1><br>
        		<table class="table table-bordered table-striped">
        			<tr>
        				<th>Order ID</th>
        				<th>Service Type</th>
        				<th>PickUp Date</th>
        				<th>PickUp Time</th>
        				<th>Ordered On</th>
        				<th>Status</th>
        				<th>Bill</th>
        			</tr>
        			<c:forEach var="order" items="${orderList}" varStatus="status">
        				<tr>
        					<td>${order.orderId }</td>
        					<td>${order.serviceType}</td>
        					<td>${order.pickupDate }</td>
        					<td>${order.pickupTime }</td>
        					<td>${order.orderedOn }</td>
        					<td>${order.status }</td>
        					<td>${order.bill }</td>
        				</tr>
        			</c:forEach>
        		</table>
        	</div>
        </c:if>
  	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/account.js"></script>
</body>
</html>