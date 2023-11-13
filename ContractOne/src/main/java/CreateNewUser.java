

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class CreateNewUser
 */
@WebServlet("/CreateNewUser")
public class CreateNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		
		Connection connection = null;
		String insertSQL = "INSERT INTO userlist (email, password, usertype) values (?, ?, ?)";
		
		try {
	         DBConnection.getDBConnection();
	         connection = DBConnection.connection;
	         PreparedStatement preparedStmt = connection.prepareStatement(insertSQL);
	         preparedStmt.setString(1, email);
	         preparedStmt.setString(2, password);
	         preparedStmt.setString(3, usertype);
	         preparedStmt.execute();
	      } 
		
		catch (Exception e) 
		{
	         e.printStackTrace();
	    }
		
		if (usertype == "Customer")
		{
			insertSQL = "INSERT INTO customer (id, name, address, phone, email, description, ) values (default, ?, ?, ?, ?, ?)";
			try {
		         DBConnection.getDBConnection();
		         connection = DBConnection.connection;
		         PreparedStatement preparedStmt = connection.prepareStatement(insertSQL);
		         preparedStmt.setString(1, name);
		         preparedStmt.setString(2, address);
		         preparedStmt.setString(3, phone);
		         preparedStmt.setString(4, email);
		         preparedStmt.setString(5, description);
		         preparedStmt.execute();
		      } 
			
			catch (Exception e) 
			{
		         e.printStackTrace();
		    }
		}
		else
		{
			insertSQL = "INSERT INTO contractor (id, name, address, phone, email, description) values (default, ?, ?, ?, ?, ?)";
			try {
		         DBConnection.getDBConnection();
		         connection = DBConnection.connection;
		         PreparedStatement preparedStmt = connection.prepareStatement(insertSQL);
		         preparedStmt.setString(1, name);
		         preparedStmt.setString(2, address);
		         preparedStmt.setString(3, phone);
		         preparedStmt.setString(4, email);
		         preparedStmt.setString(5, description);
		         preparedStmt.execute();
		      } 
			
			catch (Exception e) 
			{
		         e.printStackTrace();
		    }
		}
		response.sendRedirect("Login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
