package Subhra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**.
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pwt = response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subhra","root","Rinku@123");
			String uid = request.getParameter("ip");
			String pwd = request.getParameter("pw");
			PreparedStatement pst = con.prepareStatement("select user_id from login where user_id=? and password=?");
			pst.setString(1, uid);
			pst.setString(2, pwd);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
			else {
				pwt.println("<font color=red size=18>Login Failed !! <br>");
				pwt.println("<a href=login.jsp>Try again!!</a>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
