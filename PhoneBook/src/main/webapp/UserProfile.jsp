<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserProfile</title>
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
</head>
<body>
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

<a href="UploadImage.jsp" ><img  src="${pageContext.request.contextPath}/uploads/${user1.image}" style="border-radius:50%; width: 100px; height: 80px">

</a>

<c:if test="${user1==null}">
<%request.setAttribute("msg", "Please login...");
RequestDispatcher rd=request.getRequestDispatcher("LoginUser.jsp");
rd.forward(request, response);%></c:if>

<form action="<%=request.getContextPath()%>/index.jsp"
		method="post">

		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>PhoneNumber</th>
			</tr>



		 	
				<tr>

					 <td>${user1.userID}</td>
					<td>${user1.userName}</td>
					<td>${user1.userEmail}</td>
					<td>${user1.userPhone}</td>
					</tr>
                 
					

		</table>
	</form>
	<a href="ControllerServlet?action=logout">Logout</a>
</body>
</html>