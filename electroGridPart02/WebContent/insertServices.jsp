<%@page import="com.ServiceDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Services</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.4.1.min.js"></script>
<script src="Components/insertServices.js"></script>

<link rel="stylesheet" href="Views/style.css" type="text/css"/>

</head>
<body>





	<div class="container">
		<h1 class="label">Insert</h1>
		
		
		<form class="login_form" id="formService" name="formService">
		
		<div class="font">Package ID</div>
			<input id="insert_Id" name="insert_Id" type="text" class="form-control form-control-sm">
		
		    <div class="font">Package Type</div>
			<input id="insert_type" name="insert_type" type="text" class="form-control form-control-sm">
			
			
			<div class="font">package Unit Price</div>
			<input id="insert_unitPrice" name="insert_unitPrice" type="text" class="form-control form-control-sm">
			
			<div class="font font2">Package Instruction</div>
			<input id="insert_Instruction" name="insert_Instruction" type="text" class="form-control form-control-sm">
			
			<div class="font">services</div>
			<input id="insert_services" name="insert_services" type="text" class="form-control form-control-sm">
			
			
			
			<br><br>
			<input id="btnSave" name="btnSave" type="button" value="insert" class="btn btn-primary"> 
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