<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Management</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body bgcolor="grey">

<nav class="navbar navbar-expand-lg navbar-light success">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="./Navbar.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Dropdown </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="./UserProfile.jsp">Profile</a> <a
							class="dropdown-item" href="./ContactForm.jsp">AddContact</a>
							<a class="dropdown-item" href="./ControllerServlet?action=list">ContactList</a>
							<a class="dropdown-item" href="./UpdateProfile.jsp?">UpdateProfile</a>
							<a class="dropdown-item" href="./UpdatePassword.jsp">ChangePassword</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="ControllerServlet?action=logout">Logout</a>
					</div></li>
				<li class="nav-item"><a class="nav-link disabled" href="#"
					tabindex="-1" aria-disabled="true">Disabled</a></li>
					
					
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				
				<img  src="${pageContext.request.contextPath}/uploads/${user1.image}" style="border-radius: 50%; width: 80px; height: 80px">


			</form>
		</div>
	</nav>

	<center>
		<c:if test="${user1==null}">
			<%
			request.setAttribute("msg", "Please login...");
			RequestDispatcher rd = request.getRequestDispatcher("LoginUser.jsp");
			rd.forward(request, response);
			%>
		</c:if>

		<center
			style="border: solid 3px; width: 314px; height: 294px; border-radius: 30px; background-color: cadetblue;">
			<h1 align="center">PhoneBook</h1>
			<h4>Add New Contact</h4>

			<form action="<%=request.getContextPath()%>/ControllerServlet"
				method="post">
				<table>
					<tr>
						<td><input type="hidden" name="userID"
							value="${user1.userID}"></td>
					</tr>

					<tr>
						<td><label>Name</label></td>
						<td><input type="text" name="Name"
							placeholder="Please Enter Name"></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><input type="email" name="Email"
							placeholder="Please Enter Email"></td>
					</tr>
					<tr>
						<td><label>Address</label></td>
						<td><input type="text" name="Address"
							placeholder="Please Enter Address"></td>
					</tr>
					<tr>
						<td><label>Phone</label></td>
						<td><input type="number" name="Phone"
							placeholder="Please Enter Phone Number"></td>
					</tr>
				</table>
				<button>
					<input type="hidden" name="action" value="insert"> SUBMIT
				</button>
				<a href="ControllerServlet?action=logout">Logout</a>
			</form>
		</center>
	</center>
</body>
</html>