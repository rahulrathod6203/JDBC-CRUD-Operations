<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.io.PrintWriter"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
		<jsp:include page="/ProductHomePage.jsp">
			<jsp:param name="firstName" value="Enter First Name" />
        	<jsp:param name="lastName" value="Enter Last Name" /> 
        </jsp:include>
        
		<h2>View Products</h2>
		<div>
		<form action="viewProduct" method="post">
	
		<input type="submit" value="View all Products">
				
		</form>
	</div>
	
</body>
</html>













