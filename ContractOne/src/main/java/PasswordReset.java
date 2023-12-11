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
		String oldPassword = request.getParameter("oldPW");
		String newPassword = request.getParameter("newPW");
		System.out.println(email + ", " + oldPassword + ", " + newPassword);
		Boolean matchFound = false;
		List<Customer> customers = UtilDB.listCustomers();
		List<Contractor> contractors = UtilDB.listContractors();		
		Session session = UtilDB.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		try {			
			for (Customer tmpCustomer : customers) {
				if (Objects.equals(tmpCustomer.getEmail(), email) && Objects.equals(tmpCustomer.getPassword(), oldPassword)) {
					matchFound = true;
					Customer customer = (Customer)session.load(Customer.class, tmpCustomer.getId());
					customer.setPassword(newPassword);
					session.update(customer);
					break;
				}
			}
			if (!matchFound) {
				for (Contractor tmpContractor : contractors) {
					if (Objects.equals(tmpContractor.getEmail(), email) && Objects.equals(tmpContractor.getPassword(), oldPassword)) {
						matchFound = true;
						Contractor contractor = (Contractor)session.load(Contractor.class, tmpContractor.getId());
						contractor.setPassword(newPassword);
						session.update(contractor);
						break;
					}
				}
			}
			if (matchFound) {
				response.sendRedirect(Login);
			}
			else {
				response.sendRedirect(PasswordReset);
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
