<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Web App</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
body {
 background-color: azure;
}
</style>	
	
</head>
<body>
	<div class="container-fluid">
		<h2 class="text-center m-4">Welcome to Web App Using Spring MVC</h2>
		<div class="row">
		<div class="container card col-md-8 m-auto p-4">
			<h3 class="text-center m-2 p-1">User Registration Form</h3>
			<form method="post" action="saveUser" modelAttribute="newUser">
			  <div class="row">
				<div class="form-group col-md-6">
					<label for="exampleInputEmail">Email address</label> <input
						type="email" class="form-control" id="exampleInputEmail"
						name="email" placeholder="Enter email">
				</div>
				<div class="form-group col-md-6">
					<label for="exampleInputMobile">Mobile No.</label> <input
						type="text" class="form-control" id="exampleInputMobile"
						name="mobile" placeholder="Enter Mobile.no.">
				</div>
				<div class="form-group  col-md-6">
					<label for="exampleInputUsername">Username</label> <input
						type="text" class="form-control" id="exampleInputUsername"
						name="username" placeholder="Enter Username">
				</div>
				<div class="form-group  col-md-6">
					<label for="exampleInputPassword">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword"
						name="password" placeholder="Enter Password">
				</div>
				<div class="form-group  col-md-12 text-center">
				     <button type="submit" class="btn btn-primary">Register</button>
				</div>
			   </div>	
			</form>
		</div>
		<div class="container card col-md-6  mt-4 p-4">
			<h3 class="text-center m-2 p-1">User Details</h3>
			<table class="table  table-striped">
				<thead>
					<tr>
						<th scope="col">Username</th>
						<th scope="col">Mobile</th>
						<th scope="col">EmailId</th>
						<th scope="col">Option</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${userList}" var="userdata">
					<tr>
						<td>${userdata.username}</td>
						<td>${userdata.mobile}</td>
						<td>${userdata.email}</td>
						<td><a href="remove?username=${userdata.username}"><i class="fa fa-close"></i></a></td>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
		</div>
	   </div>	
	</div>
</body>
</html>