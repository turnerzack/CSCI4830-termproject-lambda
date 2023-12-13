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
		String name = request.getParameter("name");
		List<Job> jobs = UtilDB.listAllJobs();
		Job currentJob = null;
		for( Job job : jobs)
		{
			if (job.getId() == Integer.parseInt(name))
			{
				currentJob = job;
				
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
			RequestDispatcher rd = request.getRequestDispatcher(ViewBids);
			rd.forward(request, response);
			response.sendRedirect(ViewBids);
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
