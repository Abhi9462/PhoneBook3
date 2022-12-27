<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBook</title>

</head>

<body bgcolor="grey">

<center>
<center style="background-color: burlywood;
    border: solid 2px;
    width: 380px;
    height: 313px;
    border-radius: 40px;">

		<h1 align="center">PhoneBook</h1>
		<h4>Login</h4>


		<form action="<%=request.getContextPath()%>/ControllerServlet"
			method="post">
			<div><p>${msg}</p></div>
			
			<table>				
				<tr>
					<td><label>Email</label></td>
					<td><input type="email" name="Email"
						placeholder="Please Enter Email"></td>
				</tr>
				
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="Password"
						placeholder="Please Enter Password"></td>
				</tr>
				
				
				<tr>
					<td>
						<button>
							<input type="hidden" name="action" value="login"> SUBMIT
						</button>

					</td>
				</tr>
			</table>
			<label>If do not have an account, please </label>
			<td><a href="SignUp.jsp">Click here</a></td><td>
		</form>
	</center>
	</center>
</body>
</html>

</body>
</html>


