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
        <title>Contract One Customer Home</title>
        <!-- Bootstrap core CSS -->
        <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i" rel="stylesheet">  
        <!-- Custom styles for this template -->
        <link href="css/main.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <style>
    .div-2 {
        width: 50%; /* You can adjust the width as needed */
        margin: 0 auto; /* This centers the div horizontally */
        /* Additional styles if needed */
    }
    .why {
        width: 50%; /* You can adjust the width as needed */
        margin: 0 auto; /* This centers the div horizontally */
        /* Additional styles if needed */
    }
</style>
    </head>
    <body class="content">
        <header>
			<div id="header">
    <div id="header-content">
        <h1></h1>
        <p>Customer Home Page</p>
    </div>
    <a href="/ContractOne/SettingsBridge" >Profile</a>
</div>
<div class = "why">
<form action = "CreateJob" method = "post">
	<label for="newsletter">To Post a New Job, Fill Out the Form Below</label>
		<br><br>
		<div class="full-width">
      <label for="title">Name of the Job</label>
      <input id="title" type="text" name = "title" />
    </div>
    <br>
    <div class="full-width">
      <label for="message">Description of the Job</label>
      <textarea id="message" name = "message"></textarea>
    </div>
    <br>
    <div class="full-width">
      <button type="submit">Send Response</button>
      <button type="reset">Clear Form</button>
    </div>
  </form>
  </div>
<br><br>
			<div class="div-1">
				<h2>Review All Current and Past Jobs Below</h2>
			</div>
			  <div class="whitebox">
    <h1>Current Jobs</h1>
  <%
	List<Job> allJobs = UtilDB.listPersonalJobs((String) session.getAttribute("email"));
	List<Job> openJobs = new ArrayList<>();
	List<Job> closedJobs = new ArrayList<>();
	
	if (allJobs.size() > 0) {
		for(Job currJob: allJobs) {
			if (currJob.getStatus().equals("open")) {
				openJobs.add(currJob);
			}
			else {
				closedJobs.add(currJob);
			}
		}
	}
  %>
  <% if (openJobs.size() > 0) {%>

  <h2 align="center"></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	</tr>
	<tr bgcolor="#FFFFFF">
		<td><b> JobID </b></td>
		<td><b> Title </b></td>
		<td><b> Description </b></td>
		<td><b> Status </b></td>
	</tr>
	<%
	try{ 
		for(Job currJob: openJobs) {
		%>
		<tr bgcolor="#FFFFFF">

		<td> <%=currJob.getId()%> </td>
		<td> <%=currJob.getTitle()%> </td>
		<td> <%=currJob.getJobDescription()%> </td>
		<td> <%=currJob.getStatus()%> </td>

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
    <h1>Past Jobs</h1>
   <%
   if (closedJobs.size() > 0) { %>
   <table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	</tr>
	<tr bgcolor="#FFFFFF">
		<td><b> JobID </b></td>
		<td><b> Title </b></td>
		<td><b> Description </b></td>
		<td><b> Status </b></td>
	</tr>
	<%
	try{ 
		for(Job currJob: closedJobs) { %>
		<tr bgcolor="#FFFFFF">
		
		<td> <%=currJob.getId()%> </td>
		<td> <%=currJob.getTitle()%> </td>
		<td> <%=currJob.getJobDescription()%> </td>
		<td> <%=currJob.getStatus()%> </td>

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

  	</div>
	<div class="div-2">
	<form action="GetBids" method="post">
	<label for="newsletter">Which Job would you like to delete/view bids for?</label>
		<br><br>
		<div class="full-width">
      <label for="ID">JobID</label>
      <input id="ID" type="text" name = "ID" />
    </div>
    <div class="action-button">
      <button type="submit">Send Response</button>
      <button type="reset">Clear Form</button>
    </div> 
  </form>
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