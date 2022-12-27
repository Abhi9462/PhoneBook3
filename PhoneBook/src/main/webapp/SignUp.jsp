<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBook</title>
</head>

<body>

<center>

		<h1 align="center">PhoneBook</h1>
		<h4>SignUp</h4>

		<form action="<%=request.getContextPath()%>/ControllerServlet"
			method="post">
			<table>
				
				
				
				<tr>
					<td><label>Name</label></td>
					<td><input type="text" name="Name"
						placeholder="Please Enter Name"></td>
				</tr>
				
				<tr>
					<td><label>Password</label></td>
					<td><input type="text" name="Password"
						placeholder="Please Enter Password"></td>
				</tr>
				
				<tr>
					<td><label>Email</label></td>
					<td><input type="email" name="Email"
						placeholder="Please Enter Email"></td>
				</tr>
				
				<tr>
					<td><label>Phone</label></td>
					<td><input type="number" name="Phone"
						placeholder="Please Enter Phone Number"></td>
				</tr>
				
				
				<tr>
					<td>
						<button>
							<input type="hidden" name="action" value="signup"> SUBMIT
						</button>
					</td>
				</tr>
				
		</table>
			<label>If already have an account, please </label>
			<td><a href="LoginUser.jsp">Click here</a></td><td>
			
		</form>
	</center>
</body>
</html>

</body>
</html>