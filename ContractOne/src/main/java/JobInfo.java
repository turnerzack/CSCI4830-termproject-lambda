import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*; 
import javax.servlet.http.*;

import util.UtilDB;
import util.Info;
import datamodel.Bid;
import datamodel.Job;

/**
 * Servlet implementation class JobInfo
 */
@WebServlet("/JobInfo")
public class JobInfo extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String name = request.getParameter("name");
		List<Job> jobs = UtilDB.listAllJobs();
		List<Bid> bids = UtilDB.listBids(email);
		Job currentJob = null;
		if(name.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher(ContractorHome);
			rd.forward(request, response);
			response.sendRedirect(ContractorHome);
		}
		for( Job job : jobs)
		{
			if (job.getId() == Integer.parseInt(name) && job.getStatus().equalsIgnoreCase("open"))
			{
				currentJob = job;
				for(Bid bid : bids)
				{
					if(job.getId() == bid.getJobPointer())
					{
						currentJob = null;
						break;
					}
				}
				break;
			}
		}
		if (currentJob == null)
		{
			response.sendRedirect(ContractorHome);
		}
		else
		{
			
			session.setAttribute("name", request.getParameter("name"));
			RequestDispatcher rd = request.getRequestDispatcher(JobInfo);
			rd.forward(request, response);
			response.sendRedirect(JobInfo);
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
