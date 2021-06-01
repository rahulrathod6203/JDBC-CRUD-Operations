<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Products</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
		<jsp:include page="/ProductHomePage.jsp">
			<jsp:param name="firstName" value="Enter First Name" />
        	<jsp:param name="lastName" value="Enter Last Name" /> 
        </jsp:include>
        
		<h2>Update Product</h2>
		
		<div>
		<form action="UpdateProduct" method="post">
		
			<label >Product ID :</label><br> 
			<input type="text" name="Pid" required><br> 
		
			<label >Product name :</label><br> 
			<input type="text"  name="Pname" required><br> 
			
			<label >Quantity :</label><br> 
			<input type="text" name="quant" required><br>
			
			<label >Price :</label><br> 
			<input type="text"  name="price" required><br><br>
			
			<input type="submit" value="Update Product">
			
			
		</form>
	</div>
</body>
</html>