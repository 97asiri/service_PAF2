<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Update</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.4.1.min.js"></script>
<script src="Components/login.js"></script>

	<link rel="stylesheet" href="Views/style.css" type="text/css"/>
</head>
<body>


	<div class="container">
		<h1 class="label">Login</h1>
		
		
		<form class="login_form" id="formLogin" name="formLogin">
			<div class="font">Email or Phone</div>
			<input id="new_pw_email" name="new_pw_email" type="text" class="form-control form-control-sm">
			
			<div class="font font2">Password</div>
			<input id="new_pw_password" name="new_pw_password" type="text" class="form-control form-control-sm">
			
			<div class="font font2">New Password</div>
			<input id="new_pw_new_password" name="new_pw_new_password" type="text" class="form-control form-control-sm">
			
			<br><br>
			<input id="btnSave" name="btnSave" type="button" value="Login" class="btn btn-primary"> 
			<input type="hidden" id="hidIDSave" name="hidIDSave" value="">
			
			<br>
			<a href="home.jsp"><input type="button" value="Home page" class="btn btn-primary"></a>
			<br>
		
		</form>
		
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		
		
	</div>	







</body>
</html>