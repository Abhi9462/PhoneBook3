<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ContactManagement</title>
</head>
<body>
	<div>
		<p>${msg}</p>
	</div>
	<h1>PhoneBookApplication</h1>

     <h3>UserList</h3>

		<table>
			<tr>
				
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>PhoneNumber</th>
			</tr>


			<c:forEach var="contact" items="${UserList}">
				<tr>

					<td>${contact.userID}</td>
					<td>${contact.userName}</td>
					<td>${contact.userEmail}</td>
					<td>${contact.userPhone}</td>

					<td><a
						href="ControllerServlet?action=deleteUser&contactID=<c:out value='${contact.userID}'/>">Delete</a>/</td>
					<td><a
						href="ControllerServlet?action=editUser&contactID=<c:out value='${contact.userID}'/>">Update</a></td>
			</c:forEach>

		</table>
	</form>



</body>
</html>