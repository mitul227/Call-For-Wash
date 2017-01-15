<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account</title>
<link href="${pageContext.request.contextPath}/resources/css/account.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/drop_dwn.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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
        <div class="col-lg-8 col-lg-offset-3 col-md-offset-3 col-md-8 main">
                <h1>Welcome ${name} !</h1>
                <br>
                <a href="/callforwash/home/place_order"><button type="submit" class="btn btn-lg btn-success btns"><span class="glyphicon glyphicon-shopping-cart"></span> &nbsp;Place Order</button></a>
				&nbsp;&nbsp;
                <button id="rate_btn" class="btn btn-lg btn-info btns"><span class="	glyphicon glyphicon-usd"></span> &nbsp;View Rates</button>
				&nbsp;&nbsp;
                <a href="/callforwash/home/view_orders"><button type="submit" class="btn btn-lg btn-info btns"><span class="glyphicon glyphicon-repeat"></span> &nbsp;View Order History</button></a>
                <div id="rate_card">
                	<table class="table table-bordered">
                		<tr>
                			<td>Lower</td>
                			<td><c:out value="${prices.lowers}"/></td>
                		</tr>
                		<tr>
                			<td>Upper</td>
                			<td><c:out value="${prices.uppers}"/></td>
                		</tr>
                		<tr>
                			<td>Towel</td>
                			<td><c:out value="${prices.towels}"/></td>
                		</tr>
                	</table>
            </div>
     	</div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/account.js"></script>
</body>
</html>