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
datamodel.Bid"%>
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
				
				<h2>Review All Current and Past Bids Below</h2>
			</div>
			  <div class="whitebox">
    <h1>Current Bids</h1>
  <%
	List<Bid> allBids = UtilDB.listBids();
	List<Bid> openBids = new ArrayList<>();
	List<Bid> closedBids = new ArrayList<>();
	
	
  %>
  <% if (allBids.size() > 0) {%>

  <h2 align="center"></h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	</tr>
	<tr bgcolor="#FFFFFF">
		<td><b> Bid Id </b></td>
		<td><b> Job Id </b></td>
		<td><b> Amount </b></td>
		<td><b> Contractor </b></td>
	</tr>
	<%
	try{ 
		for(Bid currBid: allBids) {
		%>
		<tr bgcolor="#FFFFFF">

		<td> <%=currBid.getId()%> </td>
		<td> <%=currBid.getJobPointer()%> </td>
		<td> <%=currBid.getAmount()%> </td>
		<td> <%=currBid.getContractorPointer()%> </td>

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
	 <a href="/ContractOne/Job-Info.jsp" >Click Here To See Active Jobs</a>
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