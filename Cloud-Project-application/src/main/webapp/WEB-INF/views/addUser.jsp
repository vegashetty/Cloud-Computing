
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CreateUserLogin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
    src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
 <script>
 var xmlHttp = GetXmlHttpObject();
 function saveUser(){
		
		
		if(xmlHttp == null){
			alert("Your browser doesnt support ajax");
		}
		var firstName = document.getElementById("firstName").value;
		var lastName = document.getElementById("lastName").value;
		var userID = document.getElementById("userID").value;
		var email = document.getElementById("email").value;
		var address = document.getElementById("address").value;
		var zipCode = document.getElementById("zipCode").value;
		var category = document.getElementById("category").value;
		var status = document.getElementById("status").value;
		var query = "firstName=" + firstName  + "&lastName=" + lastName 
		+"&userID=" +userID + "&email=" + email + "&address="+ address+"&zipCode=" + zipCode + "&category="+category+
		"&status="+status;
		
		xmlHttp.onreadystatechange = function stateChange(){
			if(xmlHttp.readyState == 4){
				var json = JSON.parse(xmlHttp.responseText);
				document.getElementById("result").innerHTML = json.useradded;
				document.getElementById("userForm").reset();
			}
		};
		xmlHttp.open("POST","addUser.htm",true);
		xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlHttp.send(query);
		return false;
	}
function GetXmlHttpObject(){
	 var xmlHttp = null;
     try
     {
         // Firefox, Opera 8.0+, Safari
         xmlHttp = new XMLHttpRequest();
     } catch (e)
     {
         // Internet Explorer
         try
         {
             xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
         } catch (e)
         {
             xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
         }
     }
     return xmlHttp;
}
</script>
<body>
<h2 align='center'>Welcome To Create User Page</h2><hr>
<div class='container'>
<div class='row'>
<div class ='col'>
<span id="result"></span>
<form  id='userForm' onsubmit="return saveUser()">
<table class='userTable' align='center'>
<tr>
<td><h3>FirstName: </h3></td>
<td><h3><input type='text' class='form-control'  id="firstName" onchange='stringInputValidations(document.userForm.firstName)' required="true"></h3></td>
</tr>
<tr>
<td><h3>LastName: </h3></td>
<td><h3><input type='text' class='form-control' name="lastName" id="lastName" onchange = 'stringInputValidations(document.userForm.lastName)'required="true"></h3></td>
</tr>
<tr>
<td><h3>UserID: </h3></td>
<td><h3><input type='text'  class='form-control' id="userID" required="true" /></h3></td>
</tr>
<tr>
<td><h3>Email: </h3></td>
<td><h3><input type='text'  class='form-control' id="email" required="true" /></h3></td>
</tr>

<tr>
<td><h3>Address: </h3></td>
<td><h3><input type='text'  class='form-control' id="address" required="true" /></h3></td>
</tr>
<tr>
<td><h3>ZipCode: </h3></td>
<td><h3><input type='text'  class='form-control' id="zipCode" required="true" /></h3></td>
</tr>

<tr>
<td><h3>Status: </h3></td>
<td><h3><input type='text'  class='form-control' id="status" required="true" /></h3></td>
</tr>
<tr>
<td><h3>Category: </h3></td>
<td>
<select class="form-control" id="category">
<option value="ADMIN">ADMIN</option>
<option value="EMPLOYEE">EMPLOYEE</option>
<option value="CUSTOMER">CUSTOMER</option>

</select>
</td>
</tr>
<br></br>
<br></br>
</table>
<br></br>
<input type='submit' value='CREATE' class='btn btn-info' align='center'>
<a href="login.htm" class="btn btn-default">Return to Login</a>
</form>
</div>
</div>
</div>

</body>
</html>