import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UtilDB;
import datamodel.Customer;
import datamodel.Contractor;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }
    
    /**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)a
   	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		Customer fCustomer = null;
		Contractor fContractor = null;
		List<Customer> customers = UtilDB.listCustomers();
		List<Contractor> contractors = UtilDB.listContractors();

		if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			for (Customer tmpCustomer : customers) {
				if (Objects.equals(tmpCustomer.getPassword(), password)) {
					System.out.println(tmpCustomer.getName());
					fCustomer = tmpCustomer;
					break;
				}
			}
			if (fCustomer == null) {
				for (Contractor tmpContractor : contractors) {
					if (Objects.equals(tmpContractor.getPassword(), password)) {
						fContractor = tmpContractor;
						break;
					}
				}
			}
			if (fCustomer != null) {
				response.sendRedirect("Customer-Home.html");
			} else if (fContractor != null) {
				response.sendRedirect("Contractor-Home.html");
			} else {
				System.out.println("Error, invalid login information");	
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
