<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css">
</style>
</head>
<body>
		<div>
		<h1>Login Form</h1>
		<form action="Login" method="post">
		
			<label for="UserID">User ID:</label><br> 
			<input type="text" id="id" name="Uid" required><br> 
			
			<label for="Password">Password:</label><br> 
			<input type="password" id="pass" name="pass" required><br><br>
			
			<input type="submit" value="Submit"><br><br>
			<a id="link" href="index.jsp">Go back</a>
			
		</form>
	</div>
</body>
</html>