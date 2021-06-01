<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
		<div>
		<h1>Register Form</h1>
		<form action="Register" method="post">
		
			<label for="UserID">User ID :</label><br> 
			<input type="text" id="id" name="Uid" required><br> 
		
			<label for="Username">Full name :</label><br> 
			<input type="text" id="id" name="fullname" required><br> 
			
			<label for="Password">Password :</label><br> 
			<input type="password" id="pass" name="pass" required><br>
			
			<label for="Email">Email :</label><br> 
			<input type="email" id="email" name="email" required><br><br>
			
			<input type="submit" value="Register"><br><br>
			<a id="link" href="index.jsp">Go back</a>
			
		</form>
	</div>
</body>
</html>