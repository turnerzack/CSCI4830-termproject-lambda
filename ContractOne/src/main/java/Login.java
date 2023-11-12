

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the session, add argument `true` to create a session if one is not yet created.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
	         DBConnection.getDBConnection();
	         connection = DBConnection.connection;
	         String selectSQL = "SELECT * FROM userlist WHERE email LIKE ?";
	         String completed = request.getParameter("email");	         
	         preparedStatement = connection.prepareStatement(selectSQL);
	         preparedStatement.setString(1, completed);
	         rs = preparedStatement.executeQuery();
		}
	    catch (SQLException se) 
	    {
	    	se.printStackTrace();
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    } 
	    finally 
	    {
	    	try 
	    	{
	    		if (preparedStatement != null)
	    			{
	    			preparedStatement.close();
	    			}
	        } 
	    	catch (SQLException se2) 
	    	{
	        
	    	}
	     }
		try {
			rs.next();
			String password = request.getParameter("password");
			if (rs.getString("password") == password)
			{
				if (rs.getString("usertype") == "Contractor")
				{
					response.sendRedirect("contractor");
				}
				else
				{
					response.sendRedirect("customer");
				}
			}
			else
			{
				response.sendRedirect("Login.html");
			}
		} catch (SQLException e) {
			response.sendRedirect("Login.html");
		}
		
		HttpSession session = request.getSession(true);

		session.setAttribute("email", request.getParameter("email"));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
