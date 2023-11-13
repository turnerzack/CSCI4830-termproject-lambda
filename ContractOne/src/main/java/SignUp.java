import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDB;
import util.Info;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet implements Info{
	private static final long serialVersionUID = 1L;
  
	/**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
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
		
		System.out.println("Usertype = " + usertype + ".");

		if (Objects.equals(usertype, "Customer")) {
		    UtilDB.createCustomer(name, address, phone, email, description, password);
		}
		else {
		    UtilDB.createContractor(name, address, phone, email, description, password);
		}
		response.sendRedirect("Login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
