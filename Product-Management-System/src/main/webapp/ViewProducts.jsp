<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products</title>
<link rel="stylesheet" href="CRUDoperations.css">
</head>
<body>
		<jsp:include page="/ProductHomePage.jsp">
			<jsp:param name="firstName" value="Enter First Name" />
        	<jsp:param name="lastName" value="Enter Last Name" /> 
        </jsp:include>
        
		<h1>View Products</h1>
		<div>
		<form action="viewProduct" method="post">
	
		<input type="submit" value="View all Products">
			
			
		</form>
	</div>
</body>
</html>