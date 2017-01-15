<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/not_found.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="main col-md-offset-2 col-lg-offset-2">
				<img src="${pageContext.request.contextPath}/resources/images/noResult.png" />
				<br><br>
				Couldn't find what you were looking for<br><br>
				<a href="/callforwash"><button class="btn btn-lg btn-success">Go To Home</button></a>	
			</div>
		</div>
		
	</div>
</body>
</html>