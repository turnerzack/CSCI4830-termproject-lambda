import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.UtilDB;
import datamodel.Job;

/**
 * Servlet implementation class JobInfo
 */
@WebServlet("/JobInfo")
public class JobInfo extends HttpServlet {
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
		List<Job> jobs = UtilDB.listJobs();
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
			response.sendRedirect("Contractor-Home.jsp");
		}
		else
		{
			session.setAttribute("job", currentJob);
			response.sendRedirect("Job-Info.jsp");
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
