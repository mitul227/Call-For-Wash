<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <div class="col-lg-4 col-md-4 col-lg-offset-3 col-md-offset-3">
            <div class="details">
                <h1><b>Details</b></h1><br>
                <form action="/callforwash/home/details" method="post" class="col-lg-12">
                    <div class="form-group">
                        Name
                        <input id="name" type="text" class="form-control" value="${name}" name="name">
                        <p id="error_name" class="error"></p>
                        <form:errors path="acc.name" class="error"/>              
                    </div>
                    <div class="form-group">
                        Phone number
                        <input id="mobile" type="text" class="form-control" value="${phone_no}" name="phone_no">
                        <p id="error_mobile" class="error"></p>
                        <form:errors path="acc.phone_no" class="error"/>
                        <p class="error">${Msg }</p>
                    </div>
                    <div class="form-group">
                        Address
                        <textarea rows="5" name="address" class="form-control" id="address">${user_address }</textarea>
                        <p id="error_address" class="error"></p>
                        <form:errors path="acc.address" class="error"/>
                    </div>
                    <br>
                    <button class="btn btn-success btn-lg">Save Changes</button>
<!--                     <div id="dialog_confirm"> -->
<!--                     	Are you Sure ? -->
<!--                     </div> -->
                    <br><br>
                    <p class="succ">${Msg_chng }</p>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/account.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/acc_details.js"></script>
</body>
</html>