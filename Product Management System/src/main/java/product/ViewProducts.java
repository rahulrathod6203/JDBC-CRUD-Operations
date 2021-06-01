package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewProduct")
public class ViewProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products_info  ");
			
			int productID = 0;
			String pName;
			int quant;
			int price;
			RequestDispatcher rd = request.getRequestDispatcher("ViewProducts.jsp");
			rd.include(request, response);
			pw.print("<br>");
			pw.print("<h2><center>The product details are listed below</center></h2>");
			//pw.print("<br>");
			pw.print("<table style='border-collapse:collapse'  border=1px  width=\"1000\"  align=\"center\">");
			
			pw.print("<tr>");
			pw.print("<th>Product ID</th>");
			pw.print("<th>Product Name</th>");
			pw.print("<th>Quantity</th>");
			pw.print("<th>Price</th>");
			pw.print("</tr>");
			while (rs.next()) {
//					productID = rs.getInt(1);
//					pName=rs.getString(2);
//					quant = rs.getInt(3);
//					price = rs.getInt(4);
				
			//pw.print("Product ID:"+productID+"  Product Name:"+pName+"  Quantity:"+quant+"  Price:"+price+"<br>");
			pw.print("<tr>");
			pw.print("<td><center>"+rs.getInt(1)+"</center></td>");
			pw.print("<td><center>"+rs.getString(2)+"</center></td>");
			pw.print("<td><center>"+rs.getInt(3)+"</center></td>");
			pw.print("<td><center>"+rs.getInt(4)+"</center></td>");
			pw.print("</tr>");
			pw.print("<tr>");
		
			
			}
			pw.print("</table>");
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
