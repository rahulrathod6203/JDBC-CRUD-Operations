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

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		int product_ID = Integer.parseInt(request.getParameter("Pid"));
		String product_Name = request.getParameter("Pname");
		int quantity = Integer.parseInt(request.getParameter("quant"));
		int price = Integer.parseInt(request.getParameter("price"));

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
			PreparedStatement stmt = con.prepareStatement("update products_info set ProductName=?,Quantity=?,Price=? where productID=?");
			
			stmt.setString(1, product_Name);
			stmt.setInt(2, quantity);
			stmt.setInt(3, price);
			stmt.setInt(4, product_ID);
			
			stmt.executeUpdate();

			RequestDispatcher rd = request.getRequestDispatcher("UpdateProducts.jsp");
			rd.include(request, response);
			pw.println("<h2><center>Product Updated Successfully</center></h2>");
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
