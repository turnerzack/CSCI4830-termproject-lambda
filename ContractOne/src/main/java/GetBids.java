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
import datamodel.Job;
import util.Info;
import util.UtilDB;

/**
 * Servlet implementation class GetBids
 */
@WebServlet("/GetBids")
public class GetBids extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBids() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("ID", request.getParameter("ID"));
		String forward = ViewJob;
		List<Job> jobs = UtilDB.listAllJobs();
		if(request.getParameter("ID").isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher(CustomerHome);
			rd.forward(request, response);
			response.sendRedirect(CustomerHome);
		}
		for (Job job : jobs)
		{
			if(job.getId() == Integer.parseInt((String) request.getParameter("ID")) && job.getStatus().equals("open"))
			{
				forward = ViewBids;
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		response.sendRedirect(forward);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
