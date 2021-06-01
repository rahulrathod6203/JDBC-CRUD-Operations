package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
			
			int productID;
			String pName;
			int quant;
			int price;
			RequestDispatcher rd = request.getRequestDispatcher("ViewProducts.jsp");
			rd.include(request, response);
			pw.print("<br>");
			pw.print("<b>The Products are listed below :</b><br><br>");
			while (rs.next()) {
					productID = rs.getInt(1);
					pName=rs.getString(2);
					quant = rs.getInt(3);
					price = rs.getInt(4);
					
			pw.print("Product ID:"+productID+"  Product Name:"+pName+"  Quantity:"+quant+"  Price:"+price+"<br>");
			
						
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
