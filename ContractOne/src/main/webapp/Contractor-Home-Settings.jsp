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
    </head>
    <body class="content">
        <header>
<div id="header">
    <div id="header-content">
        <h1></h1>
        <p>Contractor Profile Page</p>
    </div>
    <a href="/ContractOne/Contractor-Home.jsp" >Home</a>
</div>
			<div class="div-1">
				
				<h2>Profile Information</h2>
			</div>
			  <div class="whitebox">
			
			<%Contractor contractor = UtilDB.getContractor((String) session.getAttribute("email")); %>
			
			<p>Company name: <%=contractor.getBusiness()%></p>
			<p>Company address: <%=contractor.getAddress()%></p>
			<p>Company phone number: <%=contractor.getPhone()%></p>
			<p>Company email: <%=contractor.getEmail()%></p>
			<p>Company description: <%=contractor.getDescription()%></p>
			
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