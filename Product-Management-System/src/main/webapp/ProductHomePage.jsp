<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.PrintWriter"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home | Product</title>
<link rel="stylesheet" href="ProductHomeNavbar.css">
</head>
<body>
	
	<%
		PrintWriter pw = response.getWriter();

		HttpSession httpSession = request.getSession();
		String username = (String) session.getAttribute("UserID");
		pw.println("<b>Welcome " + username + "</b>");
	%>
	
	<ul>
		<li><a class="active" href="ProductHomePage.jsp">Home</a></li>
		<li><a href="AddProducts.jsp">Add</a></li>
		<li><a href="ViewProducts.jsp">View</a></li>
		<li><a href="UpdateProducts.jsp">Update</a></li>
		<li><a href="DeleteProducts.jsp">Delete</a></li>
		<li id="lo"><a href="Logout.jsp">Logout</a></li>
	</ul>
	

		<h1 style=text-align:center;>Wellcome to Product Management System</h1> 
</body>
</html>