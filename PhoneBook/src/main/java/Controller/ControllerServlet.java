package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import ControllerService.ControllerServiceInterfaceImpl;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ControllerServiceInterfaceImpl csii = new ControllerServiceInterfaceImpl();

	public ControllerServlet() {
		super();

	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 System.out.println(session);
		
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {

		//contact
			
		case "insert":
			if (csii.insertContact(request, response))
				request.setAttribute("msg", "Contact Added");
			else
				request.setAttribute("msg", "Something went wrong..please try again");
			csii.listContact(request, response,session);

			break;

		case "delete":
			if (csii.deleteContact(request, response))
				request.setAttribute("msg", "Contact Deleted");
			else
				request.setAttribute("msg", "Something went wrong..please try again");
			csii.listContact(request, response,session);
			break;

		case "edit":
			csii.editContact(request, response);
			break;

		case "update":
			if (csii.updateContact(request, response))
				request.setAttribute("msg", "Contact updated");
			else
				request.setAttribute("msg", "Something went wrong..please try again");
			csii.listContact(request, response,session);
			break;
			
		case "list":
			
			csii.listContact(request, response,session);
			break;
			
		
			
			
			//user
		case "signup":
			if (csii.signupUser(request, response)) 
				{
				request.setAttribute("msg", "Welcome to PhoneBook..please login");
				RequestDispatcher rd=request.getRequestDispatcher("LoginUser.jsp");
				rd.forward(request, response);
				}
			else
				{
				request.setAttribute("msg", "Something went wrong..please try again");
				RequestDispatcher rd=request.getRequestDispatcher("SignUp.jsp");
				rd.forward(request, response);
				}
			
			break;

			
		case "login":
			
			
			if (csii.loginUser(request, response,session)) 
				{
				request.setAttribute("msg", "Logged in..");
				RequestDispatcher rd=request.getRequestDispatcher("Navbar.jsp");
				rd.forward(request, response);
				}
			
			else
				{
				request.setAttribute("msg", "Something went wrong..please try again");
				RequestDispatcher rd=request.getRequestDispatcher("LoginUser.jsp");
				rd.forward(request, response);
				}
			
              
			break;
			
			
		case "userList":
			csii.listUsers(request, response);
			break;
			
			
			
		case "editUser":
			csii.editUser(request, response);
			break;

		case "updateUser":
			if (csii.updateUser(request, response))
				{
				request.setAttribute("msg", "User Updated");
				RequestDispatcher rd=request.getRequestDispatcher("Navbar.jsp");
				rd.forward(request, response);
				}
			else
				request.setAttribute("msg", "Something went wrong..please try again");
			
			break;
			
		case "upload":
			csii.uploadImage(request,response);
			break;
			
		case "logout":
			csii.logout(response, session);
			break;
			
		case "changePassword":
			csii.changePassword(request,response);
			break;
			
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
