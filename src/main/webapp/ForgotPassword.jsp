<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Fee Management </title>       
         <link rel="icon" type="image/x-icon" href="./images/TCA_LOGO.png">
        <link rel="stylesheet" href="./ForgotPassword.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>

    <header>
        <img src="images/Circle_logo-01.png" class="logodesign">
        <a href="#" class="logo">TECHNO COMP ACADEMY</a>

        <nav>
            <ul>
                <li><a href="./LoginPage.html">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </header>
    <body>
    <div class="container">
    	<div class="wrapper">
    		<div class="title"><span>Reset Password</span></div>
    			<form action="./ForgotPassword">
    				<div class="row">
        				<i class="fas fa-user p-3"></i>
        				<input type="text" placeholder="Username" name="for-username" required>
      				</div>
      				<div class="row">
        				<i class="fas fa-lock p-3"></i>
        				<input type="password" placeholder="New Password" name="for-password" required>
      				</div>
      				<div class="row">
        				<i class="fas fa-lock p-3"></i>
        				<input type="password" placeholder="Re-Enter Password" name="for-re-password" required>
      				</div>
      				<h5 style="margin-top:0px;margin-bottom:8px;font-weight: bold;color:green;">${message}</h5>
                	<h5 style="margin-top:0px;margin-bottom:8px;font-weight: bold;color:red;">${error}</h5>
     				<div class="row button">
        				<input type="submit" value="Submit">
     				</div>
    			</form>
    			</div>
     </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
    
 	<footer>
        <div class="foterContainer">
            <div class="socialIcons">
                <a href="https://www.facebook.com/sachinsirs.techno.comp.academy/" target="_blank"><i class="fa-brands fa-facebook"></i></a>
                <a href="https://www.instagram.com/technocompacademy/" target="_blank"><i class="fa-brands fa-instagram"></i></a>
                <a href="https://www.linkedin.com/in/techno-comp-academy/" target="_blank"><i class="fa-brands fa-linkedin"></i></a>
                <a href="https://www.youtube.com/channel/UC_3hjQALQWzDNFb92xJnRqw" target="_blank"><i class="fa-brands fa-youtube"></i></a>
            </div>
        </div>
        <h3>Copyright 2023 &copy; Techno Comp Academy. All Rights Reserved.</h3>
    </footer>
</html>