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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		String userID = request.getParameter("Uid");
		String pass = request.getParameter("pass");

		HttpSession session = request.getSession();
		session.setAttribute("UserID", userID);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from register");
			String id = null;
			String password = null;
			boolean success = true;
			while (rs.next()) {
				id = rs.getString(1);
				password = rs.getString(3);

				if (id.equalsIgnoreCase(userID) && password.equals(pass)) {
					RequestDispatcher rd = request.getRequestDispatcher("ProductHomePage.jsp");
					rd.forward(request, response);
				} else {
					success = false;
				}
			}
			if (!success) {
				pw.println("<b>Invlaid Username or Password !</b>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
