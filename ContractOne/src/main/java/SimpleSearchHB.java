import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Employee;
import util.Info;
import util.UtilDB;
import javafx.application.*;


@WebServlet("/SimpleSearchHB")
public class SimpleSearchHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;
   
   

   public SimpleSearchHB() {
      super();
      
      
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();
      
      

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
          "<html>\n" + //
          "<head>");
      out.println("<title>" + title + "</title>");
      out.println("<style>");
      out.println("body {");
      out.println("  background-image: url('images/bg-banner.png');"); // Specify the path to your background image
      out.println("  background-repeat: no-repeat;");
      out.println("  background-size: cover;"); // Adjust background size as needed
      out.println("}");
      out.println("</style>");
      out.println("</head>\n" + //
          "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<Employee> listEmployees = null;
      if (keyword != null && !keyword.isEmpty()) {
         listEmployees = UtilDB.listEmployees(keyword);
      } else {
         listEmployees = UtilDB.listEmployees();
      }
      display(listEmployees, out);
      out.println("</ul>");
      out.println("<div style='text-align: left;'><a href='/" + projectName + "/" + searchWebName + "'>Search Data</a></div>" +
    		    "<div style='text-align: center;'><a href='/" + projectName + "/" + searchWebName + "'>Search Data</a></div>" +
    		    "<div style='text-align: right;'><a href='/" + projectName + "/" + searchWebName + "'>Search Data</a></div>");

      
      out.println("</body></html>");
   }

   void display(List<Employee> listEmployees, PrintWriter out) {
      for (Employee employee : listEmployees) {
         System.out.println("[DBG] " + employee.getId() + ", " //
               + employee.getName() + ", " //
               + employee.getAge());

         out.println("<li>" + employee.getId() + ", " //
               + employee.getName() + ", " //
               + employee.getAge() + "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
