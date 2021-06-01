<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Products</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
		<!--To include another JSP in the current page...  --> 
		<jsp:include page="/ProductHomePage.jsp">
			<jsp:param name="firstName" value="Enter First Name" />
        	<jsp:param name="lastName" value="Enter Last Name" /> 
        </jsp:include>
        
		<h2>Add Products</h2>
		
		<div id="add">		
		<form action="AddProduct" method="post">
			
			<label >Product ID :</label><br> 
			<input type="text" name="Pid" required><br> 
		
			<label >Product name :</label><br> 
			<input type="text"  name="Pname" required><br> 
			
			<label >Quantity :</label><br> 
			<input type="text" name="quant" required><br>
			
			<label >Price :</label><br> 
			<input type="text"  name="price" required><br><br>
			
			<input type="submit" value="Add Product">
			
		</form>
	</div>
</body>
</html>