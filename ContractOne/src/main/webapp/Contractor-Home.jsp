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
        <p>Contractor Home Page</p>
    </div>
</div>
			<div class="div-1">
				
				<h2>See All Current Jobs Below</h2>
			</div>
			  <div class="whitebox">
  <%
	List<Job> allJobs = UtilDB.listJobs();
	List<Job> openBids = new ArrayList<>();
	List<Job> closedBids = new ArrayList<>();
	
	
  %>
  <% if (allJobs.size() > 0) {%>

  <h2 align="center"></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	</tr>
	<tr bgcolor="#FFFFFF">
		<td><b> JobID </b></td>
		<td><b> Title </b></td>
		<td><b> Customer Email </b></td>
	</tr>
	<%
	try{ 
		for(Job currJob: allJobs) {
		%>
		<tr bgcolor="#FFFFFF">
		
		<td> <%=currJob.getId()%> </td>
		<td> <%=currJob.getTitle()%> </td>
		<td> <%=currJob.getEmail()%> </td>
		
		</tr>

		<% 
		}
	} catch (Exception e) {
		e.printStackTrace();
	} %>
		</table>
	<% } 
	else {
	%> None <%}%>
 <br>
  </div>
  
<div class="div-2">
<form action="JobInfo" method="post">
	<label for="newsletter">Which Job would you like to learn more about?</label>
		<br><br>
		<div class="full-width">
      <label for="name">JobID</label>
      <input id="name" type="text" name = "name" />
    </div>
    <div class="action-button">
      <button type="submit">Send Response</button>
      <button type="reset">Clear Form</button>
    </div> 
  </form>
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