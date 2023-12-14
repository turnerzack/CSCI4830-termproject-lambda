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
datamodel.Bid,
datamodel.Contractor"%>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Current Bids</title>
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
        <p>Bid Viewer</p>
    </div>
</div>
<div class="whitebox">
<%
	
    List<Bid> bids = UtilDB.listBids(Integer.parseInt((String) request.getParameter("ID")));
    List<Contractor> contractors = UtilDB.listContractors();
  %>
 <% if (bids.size() > 0) {%>

  <h2 align="center"></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	</tr>
	<tr bgcolor="#FFFFFF">
		<td><b> BidID </b></td>
		<td><b> Value </b></td>
		<td><b> Company Name </b></td>
		<td><b> Company Email </b></td>
		<td><b> Company Phone Number </b></td>
		<td><b> Company Address </b></td>
	</tr>
	<%
	try{ 
		for(Bid bid : bids) {
			Contractor currentContractor = null;
			for( Contractor contractor: contractors)
			{
				if(bid.getContractorPointer().equals(contractor.getEmail()))
				{
					currentContractor = contractor;
					break;
				}
			}
			if(bid.getStatus().equals("Accepted"))
			{
				%>
				<tr bgcolor="#FFFFFF">

				<td> <%=bid.getId()%> </td>
				<td> <%=bid.getAmount()%> </td>
				<td> <%=currentContractor.getBusiness()%> </td>
				<td> <%=currentContractor.getEmail()%> </td>
				<td> <%=currentContractor.getPhone()%> </td>
				<td> <%=currentContractor.getAddress()%> </td>

				</tr>

				<% 
			}
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
	 <a href="/ContractOne/Customer-Home.jsp" >Click Here To Return To Customer Home</a>
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