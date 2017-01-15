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
                <h1><b>Change Password</b></h1><br>
                <form action="/callforwash/home/password" method="post" class="col-lg-12">
                    <div class="form-group">
                        Current Password
                        <input id="curr_pass" type="password" class="form-control" name="curr_pass">
                        <p id="error_password" class="error"></p>
                        <p class="error">${Msg_pwd }</p>
		                <form:errors path="acc.curr_pass" class="error"/>
                    </div>
                    <div class="form-group">
                        New Password
                        <input id="new_pass" type="password" class="form-control" name="new_pass">
                        <p id="error_pass_new" class="error"></p>
		                <form:errors path="acc.new_pass" class="error"/>
                    </div>
                    <div class="form-group">
                        Confirm Password
                        <input id="new_pass_confirm" type="password" class="form-control" name="new_pass_confirm">
                        <p id="error_pass_eq" class="error"></p>
		                <form:errors path="acc.new_pass_confirm" class="error"/>
		                <p class="error">${Msg_pwd_conf }</p>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-success btn-lg">Change Password</button>
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
<script src="${pageContext.request.contextPath}/resources/javascript/acc_pass.js"></script>
</body>
</html>