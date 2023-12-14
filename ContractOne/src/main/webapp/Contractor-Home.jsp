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
datamodel.Job,
datamodel.Bid,
datamodel.Contractor"%>
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
        <style>
    .div-2 {
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
        <p>Contractor Home Page</p>
    </div>
    <a href="/ContractOne/SettingsBridge" >Profile</a>
</div>
			<div class="div-1">
				
				<h2>Currently Available Jobs</h2>
			</div>
			  <div class="whitebox">
  <%
	List<Job> allJobs = UtilDB.listAllJobs();
    List<Job> activeJobs = UtilDB.listJobs();
    String title;
    String descr;
    List<Bid> allBids = UtilDB.listBids();
	String email = (String) session.getAttribute("email");
	List<Job> jobs = UtilDB.listJobs(email);
    List<Bid> currBids = new ArrayList<>();
    List<Bid> archBids = new ArrayList<>();
   	Integer contID;

  %>
  
  <% if (jobs.size() > 0) {%>

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
		for(Job currJob: jobs) {
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
	<label for="newsletter">Which job would you like to learn more about?</label>
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
<div class="div-1">
				
				<h2>Your Active Bids</h2>
			</div>
			  <div class="whitebox">
  <%
   	for (Contractor cont : UtilDB.listContractors()) {
   		if (Objects.equals(cont.getEmail(), email)) {
   			contID = cont.getId();
   			break;
   		}
   	}
   	
   	for (Bid curr : allBids) {
   		if (Objects.equals(curr.getContractorPointer(), email)) {
   			if (Objects.equals(curr.getStatus(), "open")) {
   				currBids.add(curr);
   			}
   			else {
   				archBids.add(curr);
   			}
   		}
   	} 
   	if (currBids.size() > 0) {%>
  <h2 align="center"></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	</tr>
	<tr bgcolor="#FFFFFF">
		<td><b> BidID </b></td>
		<td><b> Job Title </b></td>
		<td><b> Job Description </b></td>
		<td><b> Amount </b></td>
		<td><b> Status </b></td>
	</tr>
	<%
	try {
		for(Bid curr: currBids) {
			Integer pointer = curr.getJobPointer();
			Job job = null;
			for (Job x : allJobs) {
				if (Objects.equals(pointer, x.getId()) && Objects.equals(x.getStatus(), "open")) {
					job = x;
					break;
				}
			}
		%>
		<tr bgcolor="#FFFFFF">
		
		<td> <%=curr.getId()%> </td>
		<td> <%=job.getTitle()%> </td>
		<td> <%=job.getJobDescription()%> </td>
		<td> <%=curr.getAmount()%> </td>
		<td> <%=curr.getStatus()%> </td>
		
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

<div class="div-1">
				<h2>Your Archived Bids</h2>
			</div>

			  <div class="whitebox">
  <%
   	if (archBids.size() > 0) {%>
  <h2 align="center"></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	</tr>
	<tr bgcolor="#FFFFFF">
		<td><b> BidID </b></td>
		<td><b> Job Title </b></td>
		<td><b> Job Description </b></td>
		<td><b> Amount </b></td>
		<td><b> Status </b></td>
	</tr>
	<%
	try {
		for(Bid curr: archBids) {
			Integer pointer = curr.getJobPointer();
			Job job = null;
			for (Job x : allJobs) {
				if (Objects.equals(pointer, x.getId())) {
					if (Objects.equals(x.getStatus(), "open")) {
						x.setStatus("archived");
					}
					job = x;
					break;
				}
			}
		%>
		<tr bgcolor="#FFFFFF">
		
		<td> <%=curr.getId()%> </td>
		<td> <%=job.getTitle()%> </td>
		<td> <%=job.getJobDescription()%> </td>
		<td> <%=curr.getAmount()%> </td>
		<td> <%=curr.getStatus()%> </td>
		
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