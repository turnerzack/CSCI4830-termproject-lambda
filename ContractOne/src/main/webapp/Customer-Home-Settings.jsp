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
datamodel.Customer"%>
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
        <p>Customer Profile Page</p>
    </div>
    <a href="/ContractOne/Customer-Home.jsp" >Home</a>
</div>
			<div class="div-1">
				
				<h2>Profile Information</h2>
			</div>
			  <div class="whitebox">
			
			<%Customer customer = UtilDB.getCustomer((String) session.getAttribute("email")); %>
			
			<p>Name: <%=customer.getName()%></p>
			<p>Address: <%=customer.getAddress()%></p>
			<p>Phone number: <%=customer.getPhone()%></p>
			<p>Email: <%=customer.getEmail()%></p>
			<p>Description: <%=customer.getDescription()%></p>
			
			</div>
			<div class="container">
			</div>
            <div class="logo text-center">
                <h2></h2>
            </div>
            <div class="div-2">
	<form action="UpdateProfile" method="post">
	<label for="newsletter">Enter your updated information</label>
		<br><br>
		<div class="full-width">
      <label for="newUser">Name</label>
      <input id="newUser" type="text" name = "newUser" />
    </div>
    <div class="full-width">
      <label for="newAddress">Address</label>
      <input id="newAddress" type="text" name = "newAddress" />
    </div>
    <div class="full-width">
      <label for="newPhone">Phone Number</label>
      <input id="newPhone" type="text" name = "newPhone" />
    </div>
    <div class="full-width">
      <label for="newEmail">Email</label>
      <input id="newEmail" type="text" name = "newEmail" />
    </div>
    <div class="full-width">
      <label for="newDescription">Description</label>
      <input id="newDescription" type="text" name = "newDescription" />
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