

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamodel.Contractor;
import datamodel.Customer;
import util.UtilDB;
import util.Info;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		Customer customer = UtilDB.getCustomer(email);
		Contractor contractor = UtilDB.getContractor(email);
		String newUser = request.getParameter("newUser");
		String newAddress = request.getParameter("newAddress");
		String newPhone = request.getParameter("newPhone");
		String newEmail = request.getParameter("newEmail");
		String newDescription = request.getParameter("newDescription");
		if(customer != null && (newEmail.isEmpty() || UtilDB.validateEmail(newEmail)) )
		{
			if(newUser.isEmpty())
			{
				newUser = customer.getName();
			}
			if(newAddress.isEmpty())
			{
				newAddress = customer.getAddress();
			}
			if(newPhone.isEmpty())
			{
				newPhone = customer.getPhone();
			}
			if(newEmail.isEmpty())
			{
				newEmail = customer.getEmail();
			}
			if(newDescription.isEmpty())
			{
				newDescription = customer.getDescription();
			}
			UtilDB.updateCustomer(new Customer(customer.getId(), newUser, newAddress, newPhone, newEmail, newDescription, customer.getPassword()), email);
			session.setAttribute("email", newEmail);
			RequestDispatcher rd = request.getRequestDispatcher("Customer-Home.jsp");
			rd.forward(request, response);
			response.sendRedirect("Customer-Home.jsp");
		}
		else if(contractor != null && (newEmail.isEmpty() || UtilDB.validateEmail(newEmail)))
		{
			if(newUser.isEmpty())
			{
				newUser = contractor.getBusiness();
			}
			if(newAddress.isEmpty())
			{
				newAddress = contractor.getAddress();
			}
			if(newPhone.isEmpty())
			{
				newPhone = contractor.getPhone();
			}
			if(newEmail.isEmpty())
			{
				newEmail = contractor.getEmail();
			}
			if(newDescription.isEmpty())
			{
				newDescription = contractor.getDescription();
			}
			UtilDB.updateContractor(new Contractor(contractor.getId(), newUser, newAddress, newPhone, newEmail, newDescription, contractor.getPassword()), email);
			session.setAttribute("email", newEmail);
			RequestDispatcher rd = request.getRequestDispatcher("Contractor-Home.jsp");
			rd.forward(request, response);
			response.sendRedirect("Contractor-Home.jsp");
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
