<!DOCTYPE html>

<%@ page import="
java.util.*,
java.io.IOException,
javax.servlet.ServletException,
javax.servlet.annotation.WebServlet,
javax.servlet.http.HttpServlet,
javax.servlet.http.HttpServletRequest,
javax.servlet.http.HttpServletResponse,
javax.servlet.http.HttpSession,
util.UtilDB,
datamodel.Job"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contract One Contractor Home</title>
        <!-- Bootstrap core CSS -->
        <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i" rel="stylesheet">  
        <!-- Custom styles for this template -->
        
        <link href="css/main.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="content">
        <header>
			<div id="header">
    <div id="header-content">
        <h1></h1>
        <p>Job Viewer</p>
    </div>
</div>
<div class="whitebox">
<%
	
    List<Job> jobs = UtilDB.listJobs();
    Job currentJob = null;
    for (Job job : jobs)
    {
    	if(job.getId() == Integer.parseInt(request.getParameter("name")))
    	{
    		currentJob = job;
    		break;
    	}
    }
  %>
 <% if (currentJob != null) {%>
	
  <h2 align="center"></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	</tr>
	<tr bgcolor="#FFFFFF">
		<td><b> <%=currentJob.getTitle()%> </b></td>
	</tr>
	<%
	
	try{ 
		%>
		<tr bgcolor="#FFFFFF">
		<td> <%=currentJob.getJobDescription()%> </td>
		</tr>
		<% 
	} catch (Exception e) {
		e.printStackTrace();
	} %>
		</table>
	<% 
	} 
 	
	else {
	%> none <% }%>
 <br>
  </div>

			
			
  
<div class="div-2">
	 <a href="/ContractOne/Contractor-Home.jsp" >Click Here To Return To Contractor Home</a>
			</div>
			<div class="container">
            </div>
            <div class="logo text-center">
                <h2></h2>
            </div>
        </header>
            <div class="row">
                <div class="copyright-box">
                    <div class="copyright">
                        <a>&copy; 2023 All Rights Reserved. Designed by <strong>ContractOne</strong></a>
                    </div>
                </div>
            </div>
    </body>
</html>