import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datamodel.Contractor;
import datamodel.Customer;
import util.UtilDB;
import util.Info;

/**
 * Servlet implementation class PasswordReset
 */
@WebServlet("/PasswordReset")
public class PasswordReset extends HttpServlet implements Info{
	private static final long serialVersionUID = 1L;
     
	/**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordReset() {
        super();
    }

    /**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String email = request.getParameter("email");
		String newPassword = request.getParameter("password");
		Boolean matchFound = false;
		List<Customer> customers = UtilDB.listCustomers();
		List<Contractor> contractors = UtilDB.listContractors();
		Session session = UtilDB.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			for (Customer tmpCustomer : customers) {
				if (Objects.equals(tmpCustomer.getEmail(), email)) {
					matchFound = true;
					Customer customer = (Customer)session.get(Customer.class, tmpCustomer.getId());
					customer.setPassword(newPassword);
					session.update(customer);
					break;
				}
			}
			if (!matchFound) {
				for (Contractor tmpContractor : contractors) {
					if (Objects.equals(tmpContractor.getEmail(), email)) {
						matchFound = true;
						Contractor contractor = (Contractor)session.get(Contractor.class, tmpContractor.getId());
						contractor.setPassword(newPassword);
						session.update(contractor);
						break;
					}
				}
			}
			if (matchFound) {
				response.sendRedirect("Login.jsp");
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
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
