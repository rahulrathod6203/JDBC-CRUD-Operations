<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Products</title>
<link rel="stylesheet" href="CRUDoperations.css">
</head>
<body>
		<jsp:include page="/ProductHomePage.jsp">
			<jsp:param name="firstName" value="Enter First Name" />
        	<jsp:param name="lastName" value="Enter Last Name" /> 
        </jsp:include>
        
		<h1>Delete Product</h1>
		
		<div>
		<form action="deleteProducts" method="post">
		
			<label >Product ID :</label>
			<input type="text" name="Pid" required><br><br>
			
			<input type="submit" value="Delete Product">
			
			
		</form>
	</div>
</body>
</html>