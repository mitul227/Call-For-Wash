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
					<a href="/callforwash/admin/home/view_users"><li class="list-group-item"><span class="glyphicon glyphicon-user"></span> View Users</li></a>
					<a href="/callforwash/admin/home/view_users/search"><li class="list-group-item"><span class="glyphicon glyphicon-search"></span> Search User</li></a>
				</ul>
			</div>
			<div class="col-lg-offset-1 col-md-offset-1 col-lg-8 col-md-8">
				<form action="/callforwash/admin/home/view_users/search" method="post" class="form-inline">
					<input class="form-control" type="text" name="phoneNo" placeholder="Mobile No"> 
					<button class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Search</button>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-offset-3 col-md-offset-3 col-lg-8 col-md-8">
				<div>
					<c:set var="msg" value="${Msg }"/>
					<c:out value="${Msg }"/>
				</div>
				<c:if test="${empty msg }">
					<table class="table table-bordered">
						<tr>
							<th>Phone No</th>
							<th>Name</th>
							<th>Address</th>
						</tr>
						<c:forEach var="user" items="${user }" varStatus="status">
							<tr>
								<td><a href="${user.phoneNo }">${user.phoneNo }</a></td>
								<td>${user.name }</td>
								<td>${user.address }</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>