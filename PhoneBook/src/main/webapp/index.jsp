<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBook</title>
 <style>
 .abhi{
    text-align: center;
    border: solid 5px;
    width: 255px;
    height: 450px;
    background-color: orange; 
    border-radius: 10px;
 }
 
 </style>
</head>


<body bgcolor="grey">
<center>
<div class="abhi">
<div><p>${msg}</p></div>
<a href="UploadImage.jsp" ><img  src="${pageContext.request.contextPath}/uploads/${user1.image}" style="border-radius: 50%; width: 80px; height: 80px">

</a>

<h4>Welcome To PhoneBook ${user1.userName}</h4>
UserID: ${user1.userID}


<br><br>
<form action="./ContactForm.jsp">
<button> <input type="hidden" ></input>AddContact</button>
</form>
<br>
<form action="./ControllerServlet ">
<button> <input type="hidden" name="action" value="list"></input>ContactList</button>
</form>
<br>
<form action="./UserProfile.jsp">
<button> <input type="hidden" ></input>Profile</button>

</form>

<br>
<form action="./UpdatePassword.jsp">
<button> <input type="hidden"></input>ChangePassword</button>

</form>

<br>
<a href="ControllerServlet?action=logout">Logout</a>
</div>
</center>
</body>

</html>



