<%@page import="com.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<script src="Components/jquery-3.6.0.min.js"></script>
        <script src="Components/user.js"></script>
		<title>User Management</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col">
					<h1>Accounts Management</h1>
					<form id="formItem" name="formItem" method="POST" action="user.jsp">
						

						CustomerfName: 
						<input 
							id="CustomerfName"
							name="CustomerfName" 
							type="text" 
							class="form-control form-control-sm"
						><br>

						CustomerlName: 
						<input 
							id="CustomerlName" 
							name="CustomerlName" 
							type="text" 
							class="form-control form-control-sm"
						><br>

						AccountNumber: 
						<input 
							id="AccountNumber" 
							name="AccountNumber" 
							type="text" 
							class="form-control form-control-sm"
						><br>
						
						CustomerNIC: 
						<input 
							id="CustomerNIC" 
							name="CustomerNIC" 
							type="text" 
							class="form-control form-control-sm"
						><br>
						
						CustomerEmail: 
						<input 
							id="CustomerEmail" 
							name="CustomerEmail" 
							type="text" 
							class="form-control form-control-sm"
						><br>
						
						CustomerPhone: 
						<input 
							id="CustomerPhone" 
							name="CustomerPhone" 
							type="text" 
							class="form-control form-control-sm"
						><br>

						<input 
							id="btnSave" 
							name="btnSave" 
							type="button" 
							value="Save" 
							class="btn btn-primary"
						>

						<input type="hidden" name="hidCustomerIDSave" id="hidCustomerIDSave" value="">
					</form>
				
					<br>
					<div id="alertSuccess" class="alert alert-success">
						
					</div>
					<div id="alertError" class="alert alert-danger"></div>
					<br>
					<div id="divItemGrid">
					<%
					user item = new user(); 
									out.print(item.readUser());
					%>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>