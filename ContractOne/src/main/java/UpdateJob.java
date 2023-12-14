import java.io.IOException;
import java.util.List;

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
		UtilDB.updateJob(Integer.parseInt((String)session.getAttribute("ID")), request.getParameter("status"));
		if(request.getParameter("status").equals("archive"))
		{
			UtilDB.updateBid(Integer.parseInt((String)session.getAttribute("ID")));
		}
		else
		{
			List<Bid> bids = UtilDB.listBids(Integer.parseInt((String) session.getAttribute("ID")));
			for (Bid bid : bids)
			{
				bid.setStatus("Rejected");
			}
		}
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
