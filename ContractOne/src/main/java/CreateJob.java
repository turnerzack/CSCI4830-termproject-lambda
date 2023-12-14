import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.UtilDB;
import util.Info;

/**
 * Servlet implementation class CreateJob
 */
@WebServlet("/CreateJob")
public class CreateJob extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String title = request.getParameter("title");
		String description = request.getParameter("message");
		if(!title.isEmpty() && !description.isEmpty())
		{
			UtilDB.createJob(title, email, description);
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
