<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Reset Password</title>
        <!-- Bootstrap core CSS -->
        <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i" rel="stylesheet">  
        <!-- Custom styles for this template -->
        <link rel="icon" href="images/logo.png"/>
        <link href="css/style.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="content">
        <header>
			<img src="images/logo.png" alt="Girl in a jacket" style="width:300px;height:100px;">
            <div class="logo text-center" img src="images/logo.png">
                <h2></h2>
            </div>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-6 col-xs-offset-3 col-xs-6 width-100">
                    <form action="PasswordReset" method="post">
                        <div class="PasswordReset">
                            <input class="form-control placeholder-fix" type="text" placeholder="Email" name="email" required="">
                            <input class="form-control placeholder-fix" type="text" placeholder="Old Password" name="oldPW" required="">
                            <input class="form-control placeholder-fix" type="text" placeholder="New Password" name="newPW" required="">
                        </div>
                       <div class="action-button">
                            <button class="btn-block" type="submit">Reset Password</button> 
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <ul class="page-links">
                    <li><a href="SignUp.jsp">Sign Up</a></li>
                    <li><a href="Login.jsp">Login</a></li>
                </ul>
              
                <div class="copyright-box">
                    <div class="copyright">
						<a>&copy; 2023 All Rights Reserved. Designed by <strong>ContractOne</strong></a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>