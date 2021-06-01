<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error | Login Page</title>
<link rel="stylesheet" href="CRUDoperations.css">
</head>
<body>
		<h3>Invalid Username or Password ! Please Try again.</h3>
		<div>
		<h2>Login Form</h2>
		<form action="Login" method="post">
		
			<label for="UserID">User ID:</label><br> 
			<input type="text" id="id" name="Uid" required><br> 
			
			<label for="Password">Password:</label><br> 
			<input type="password" id="pass" name="pass" required><br><br>
			
			<input type="submit" value="Submit">
			<a href="index.jsp">Go back</a>
			
		</form>
	</div>
</body>
</html>