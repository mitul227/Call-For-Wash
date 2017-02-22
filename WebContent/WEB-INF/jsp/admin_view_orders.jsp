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
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 col-md-2 sidebar-nav-fixed">
				<ul class="list-group">
					<a href="/callforwash/admin/home/view_orders"><li class="list-group-item"><span class="glyphicon glyphicon-shopping-cart"></span> View Orders</li></a>
					<a href="/callforwash/admin/home/view_orders/search"><li class="list-group-item"><span class="glyphicon glyphicon-search"></span> Search Order</li></a>
				</ul>
			</div>
			<div class="col-lg-10 col-md-10">
				<table class="table table-bordered table-striped">
					<tr>
						<th>Order ID</th>
						<th>Name</th>
						<th>Mobile</th>
						<th>Service Type</th>
						<th>Address</th>
						<th>Status</th>
					</tr>
					<c:forEach var="order" items="${orderList }" varStatus="status">
						<tr>
							<td><a href="view_orders/${order.orderId }">${order.orderId }</a></td>
							<td>${order.name }</td>
							<td>${order.phoneNo }</td>
							<td>${order.serviceType }</td>
							<td>${order.address }</td>
							<td>${order.status }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>