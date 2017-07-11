

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
var xmlHttp;
xmlHttp = GetXmlHttpObject();
function forgotPassword(){
	
	if(xmlHttp == null){
		alert("Your browser doesn not support AJAX");
		return;
	}
	var userID = document.getElementById("userID").value
	var newPassword	= document.getElementById("newPassword").value;
	var securityAns = document.getElementById("securityAns").value;
	var query =  "userID="+ userID +"&newPassword=" + newPassword+ "&securityAns=" + securityAns;
	xmlHttp.onreadystatechange = function stateChanged(){
		if( xmlHttp.readyState == 4 ){
			var json = JSON.parse(xmlHttp.responseText);
			document.getElementById("result").innerHTML = json.updateMessage;
			document.getElementById("myForm").reset();
			
		}
	};
	xmlHttp.open("POST", "ForgotPassword.htm", true);
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlHttp.send(query);
	return false;
}
function GetXmlHttpObject(){
	var xmlHttp = null;
	try{
		xmlHttp = new XMLHttpRequest();
	}catch(e){
		try{
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}
</script>

<style>
.content:before {
	content: "";
	position: fixed;
	left: 0;
	right: 0;
	z-index: -1;
	display: block;
	background-image: url("./././images/password.jpg");
	width: 100%;
	height: 100%;
	-webkit-filter: blur(1px);
	-moz-filter: blur(1px);
	-o-filter: blur(1px);
	-ms-filter: blur(1px);
	filter: blur(1px);
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

.navbar {
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 15px;
	padding-right: 15px;
	border: 0;
	border-radius: 0;
	margin-bottom: 0;
	font-size: 13px;
	letter-spacing: 2px;
}

.navbar li a, .navbar .navbar-brand {
	color: #ff0000 !important;
}

.vertical-right{
    padding-top: 10px;
      border-color: #000000;
      background-color:rgba(0,0,0,.3);
      color: #fff;
      height: 250px;
      width: 300px;
}

.content {
	position: fixed;
	left: 0;
	right: 0;
	z-index: 0;
}
  .jumbotron label{
    color: #000000;
}

.a{
   font-size: 55px;
   
}

.white, .white a {
  color: #fff;
}
</style>
</head>
<body>

	<div class="content">
		<nav class="navbar navbar-default" style="background-color: #FFFAF0">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<img src="images/marvel.jpeg" class="img-rounded" alt="Cinque Terre"
					width="200" height="50" style="padding-right: 25px">

			</div>
			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav navbar-right">

					<li><a href="#">Marvel Bank Home</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Customer Care</a></li>
					<li><a href="#">Find Atm/Branch</a></li>
				</ul>
			</div>
		</div>
		</nav>
		<div class='row' style='padding-top: 30px'></div>
		<div class='row-lg-4' align="center">
			<div class='col-lg-4' align="center">





				<form onsubmit="return forgotPassword()" method='post' id='myForm'>

					<c:out value="${requestScope.userId}"></c:out>

					<div class='row' align='center'>
						<div class='col' align='center' style="background-color: #000000">
							<br> <span class="glyphicon glyphicon-lock white"></span><font color="#ffffff" > Update your password
							</font>
						</div>
					</div>

					<br>
					
					<div class='col-lg-5' align='left'>
						<label for='userID'><font color="#ffffff">User Id:</font></label>

					</div>
					<div class='col-lg-6' style='padding-right: 10px'>
						
               <input type="text" class="form-control" id='userID' placeholder="UserID" required><br>
   </div>
					<div class='col-lg-6' align='left'>
						<label for='securityQue'><font color="#ffffff">Who was your childhood Hero?</font></label>

					</div>
					<div class='col-lg-6' style='padding-right: 10px'>
						
               <input type="password" class="form-control" id='securityAns' placeholder="Answer" required><br>
   </div>
					
					


					<div class='col-lg-5' align='left'>
						<label for="password"><font color="#ffffff">New Password:</font></label>
					</div>
					<div class='col-lg-6'style= 'padding-right:10px'>
                 <input type="password" class="form-control" id='newPassword' placeholder="New password" required><br>
                 </div>
					<div class='col'>
							
						<br> <input type='submit' class='btn btn-info' value='Update'>
					</div>
					
				</form>
				<span id="result" ></span>
			</div>
			

<div>
</div>

	</div>

	</div>

</body>
</html>