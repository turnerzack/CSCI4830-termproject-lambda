import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		Customer fCustomer = null;
		Contractor fContractor = null;
		List<Customer> customers = UtilDB.listCustomers();
		List<Contractor> contractors = UtilDB.listContractors();

		if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			for (Customer tmpCustomer : customers) {
				if (Objects.equals(tmpCustomer.getEmail(), email) && Objects.equals(tmpCustomer.getPassword(), password)) {
					fCustomer = tmpCustomer;
					break;
				}
			}
			if (fCustomer == null) {
				for (Contractor tmpContractor : contractors) {
					if (Objects.equals(tmpContractor.getEmail(), email) && Objects.equals(tmpContractor.getPassword(), password)) {
						fContractor = tmpContractor;
						break;
					}
				}
			}
			if (fCustomer != null) {
				session.setAttribute("email", request.getParameter("email"));
				RequestDispatcher rd = request.getRequestDispatcher(CustomerHome);
				rd.forward(request, response);
				response.sendRedirect(CustomerHome);
			} else if (fContractor != null) {
				session.setAttribute("email", request.getParameter("email"));
				RequestDispatcher rd = request.getRequestDispatcher(ContractorHome);
				rd.forward(request, response);
				response.sendRedirect(ContractorHome);
			} else {
				response.sendRedirect(Login);
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
