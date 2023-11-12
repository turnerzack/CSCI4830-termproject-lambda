

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PasswordReset
 */
@WebServlet("/PasswordReset")
public class PasswordReset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordReset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    try 
	    {
	    	DBConnection.getDBConnection();
	        connection = DBConnection.connection;
	        String selectSQL = "UPDATE userlist SET password = ? WHERE email LIKE ?";
	        preparedStatement = connection.prepareStatement(selectSQL);
	        preparedStatement.setString(1, request.getParameter("password"));
	        preparedStatement.setString(2,  request.getParameter("email"));
	        int rs = preparedStatement.executeUpdate();
	        preparedStatement.close();
	    }
	    catch (SQLException se) 
	    {
	    	response.sendRedirect("PasswordReset.html");
		} 
	    catch (Exception e) 
	    {
	    	response.sendRedirect("PasswordReset.html");
		} 
	    finally 
	    {
	    	if (preparedStatement != null)
	    	{
	    		response.sendRedirect("PasswordReset.html");
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
