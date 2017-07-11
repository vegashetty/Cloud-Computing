<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Marvel Bank home Page</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  <style>
  body {

/*css for full size background image*/
  background: url("./././images/home.jpeg") no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  
  height: 100%;
  background-color: #060;
  color: #fff;
  text-align: center;
  text-shadow: 0 1px 3px rgba(0,0,0,.5);
 

      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
      color: #f5f6f7;
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  
 
  .container-fluid {
      padding-top: 20px;
      padding-bottom: 20px;
  }
  .navbar {
      padding-top: 10px;
      padding-bottom: 20px;
      padding-left: 15px
      padding-right:15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 20px;
      letter-spacing: 2px;
       background-color: transparent;
   background: transparent;
   border-color: transparent;
     
  }
 .navbar li a, .navbar .navbar-brand {
      color: #ff0000 !important;
  }

  
  </style>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" >
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     
      <img src="images/marvel.jpeg" class="img-rounded" alt="Cinque Terre" width="200" height="50" style="padding-right:25px">
      
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">

      <ul class="nav navbar-nav"  >

        <li><a href="#">About Us</a></li>
       
       

       
        <li><a href='FindAtm.htm'>Find ATM</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href='Login.htm'><span class="glyphicon glyphicon-user"></span> Login</a></li>
        <li><a href='addUser.htm'><span class="glyphicon glyphicon-user"></span> SignUp</a></li>
      <li><a href='#'><span class="glyphicon glyphicon-user"></span> Hello</a></li>
      </ul>
    </div>
  </div>

  <footer class="footer navbar-fixed-bottom"">
    <p> Hello From Other Side...Adelle <3</p>
     <p> Shape of You<3</p>
  <p> Theme Made By Team Ultron</p> 
                                             <p> Shape of You<3</p>
</footer>
</nav>


</body>
</html>
