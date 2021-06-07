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

@WebServlet("/deleteProducts")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		int pID = Integer.parseInt(request.getParameter("Pid"));
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
			PreparedStatement stmt=con.prepareStatement("delete from products_info where productID=?");  
			stmt.setInt(1,pID);
			
			int i=stmt.executeUpdate();  
			
			RequestDispatcher rd = request.getRequestDispatcher("DeleteProducts.jsp");
			rd.include(request, response);
			//pw.print("<br>");
			pw.println("<h2><center>Product Deleted Successfully</center></h2>");
			}catch(Exception e) {
					System.out.println(e);
					
			} 
	}

}
