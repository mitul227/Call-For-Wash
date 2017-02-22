<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/admin.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
      			<a class="navbar-brand" href="/callforwash/admin/home"><span class="glyphicon glyphicon-home"></span></a>
    		</div>
			<ul class="nav navbar-nav">
				<li><a href="/callforwash/admin/home/view_users"><span class="glyphicon glyphicon-user"></span> Users</a></li>
				<li><a href="/callforwash/admin/home/view_orders"><span class="glyphicon glyphicon-shopping-cart"></span> Orders</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/callforwash/admin/logout" id="log"><span class="glyphicon glyphicon-off"></span> Log Out</a><li>
			</ul>
		</div>
	</div>
	
<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
		
<!-- 		</div> -->
<!-- 	</div> -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-offset-1 col-md-offset-1 col-lg-10 col-md-10 side">
				<table class="table table-bordered">
					<tr>
						<th>Total Users</th>
						<th>Total Orders</th>
						<th>Successful Orders</th>
						<th>Pending Orders</th>
						<th>Cancelled Orders</th>
						<th>Total Earnings</th>
					</tr>
					<c:forEach var="info" items="${info }" varStatus="status">
						<tr>
							<td>${info.users }</td>
							<td>${info.totalOrders }</td>
							<td>${info.succOrders }</td>
							<td>${info.pendingOrders }</td>
							<td>${info.cancelledOrders }</td>
							<td>${info.earnings }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>