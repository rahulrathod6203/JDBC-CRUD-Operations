<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<style type="text/css">
body {
	background-color: cyan;
}
</style>
</head>
<body>
		<div>
		<h2>Register Form</h2>
		<form action="Register" method="post">
		
			<label for="UserID">Full name :</label><br> 
			<input type="text" id="id" name="fullname" required><br> 
			
			<label for="UserID">User ID :</label><br> 
			<input type="text" id="id" name="Uid" required><br> 
			
			<label for="Password">Password :</label><br> 
			<input type="password" id="pass" name="pass" required><br>
			
			<label for="Email">Email :</label><br> 
			<input type="email" id="email" name="email" required><br><br>
			
			<input type="submit" value="Register">
			<a href="index.jsp">Go back</a>
			
		</form>
	</div>
</body>
</html>