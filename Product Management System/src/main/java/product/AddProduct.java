package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		int productID = Integer.parseInt(request.getParameter("Pid"));
		String productName = request.getParameter("Pname");
		int quantity = Integer.parseInt(request.getParameter("quant"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
			PreparedStatement stmt=con.prepareStatement("insert into products_info values(?,?,?,?)");
			stmt.setInt(1,productID);
			stmt.setString(2,productName); 
			stmt.setInt(3,quantity); 
			stmt.setInt(4,price);
			 
			int i=stmt.executeUpdate();  
			
			RequestDispatcher rd = request.getRequestDispatcher("AddProducts.jsp");
			rd.include(request, response);
			//pw.print("<br>");
			pw.println("<h2><center>Product added Successfully</center></h2>");
			}catch(Exception e) {
					System.out.println(e);
					
			}  
	}

}
