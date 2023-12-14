import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamodel.Bid;
import util.UtilDB;
import util.Info;

/**
 * Servlet implementation class UpdateJob
 */
@WebServlet("/UpdateJob")
public class UpdateJob extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if(request.getParameter("status").equals("archive") && !(request.getParameter("ID") == null))
		{
			UtilDB.updateJob(Integer.parseInt((String)session.getAttribute("ID")), request.getParameter("status"));
			UtilDB.updateBid(Integer.parseInt((String)session.getAttribute("ID")));
		}
		else if (request.getParameter("ID") == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher(CustomerHome);
			rd.forward(request, response);
			response.sendRedirect(CustomerHome);
		}
		else
		{
			UtilDB.updateJob(Integer.parseInt((String)session.getAttribute("ID")), request.getParameter("status"));
			List<Bid> bids = UtilDB.listBids(Integer.parseInt((String) session.getAttribute("ID")));
			for (Bid bid : bids)
			{
				UtilDB.updateBid(bid.getId(), "Rejected");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(CustomerHome);
		rd.forward(request, response);
		response.sendRedirect(CustomerHome);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
