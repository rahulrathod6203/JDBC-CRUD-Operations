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

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
	
		String userID = request.getParameter("Uid");
		String fullname = request.getParameter("fullname");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
			PreparedStatement stmt=con.prepareStatement("insert into register values(?,?,?,?)");
			stmt.setString(1,userID);
			stmt.setString(2,fullname); 
			stmt.setString(3,pass); 
			stmt.setString(4,email);
			
			 
			int i=stmt.executeUpdate();  
			pw.print("<b>Registered Successfully</b>");  
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			rd.include(request, response);
		
			}catch(Exception e) {
					System.out.println(e);
					
			}  
		
	}

}
