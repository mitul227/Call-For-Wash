<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-offset-4 col-md-offset-4 col-lg-4 col-md-4">
				<h1>Admin Log In</h1>
				<form action="/callforwash/admin/login" method="POST">
					<div class="form-group">
						Username <input type="text" name="username" class="form-control"><br>
						Password <input type="password" name="password" class="form-control"><br>
						<button class="btn btn-primary" type="submit">Log In</button><br><br>
						<p>${error }</p>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>