<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
			<div class="col-md-10 col-lg-10">
				<table class="table table-bordered table-striped">
					<c:forEach var="order" items="${orderList }" varStatus="status">
						<tr>
							<th>Order ID</th>
							<td>${order.orderId }</td>
						</tr>
						<tr>
							<th>Service Type</th>
							<td>${order.serviceType }</td>
						</tr>
						<tr>
							<th>Name</th>
							<td>${order.name }</td>
						</tr>
						<tr>
							<th>Address</th>
							<td>${order.address }</td>
						</tr>
						<tr>
							<th>Mobile</th>
							<td>${order.phoneNo }</td>
						</tr>
						<tr>
							<th>Ordered On</th>
							<td>${order.orderedOn }</td>
						</tr>
						<tr>
							<th>Pick Up Date</th>
							<td>${order.pickUpDate }</td>
						</tr>
						<tr>
							<th>Pick Up Time</th>
							<td>${order.pickUpTime }</td>
						</tr>
						<tr>
							<th>Status</th>
							<td>${order.status }</td>
						</tr>
						<tr>
							<th>Bill</th>
							<td>${order.bill }</td>
						</tr>
						<c:set var="status" scope="session" value="${order.status }"/>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<c:set var="string" scope="session" value="${orderList[0].orderId}" />
			<div class="col-lg-offset-2 col-md-offset-2 col-lg-10 col-md-10">
				<c:if test="${status eq 'pending'}">
					<form action="/callforwash/admin/home/view_orders/${string }" method="post" class="form-inline">
						<c:if test="${fn:endsWith(string,'1') eq true}">
							<input type="text" name="bill" placeholder="Bill" class="form-control" value="0" readonly required>
						</c:if>
						<c:if test="${fn:endsWith(string,'1') eq false}">
							<input type="text" name="bill" placeholder="Bill" class="form-control" required>
						</c:if>
						<button name="btn" type="submit" value="complete" class="btn btn-success">Complete Order</button>
						<br><br>
						<button name="btn" type="submit" value="cancel" class="btn btn-danger">Cancel Order</button>
						<br><br>
					</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>