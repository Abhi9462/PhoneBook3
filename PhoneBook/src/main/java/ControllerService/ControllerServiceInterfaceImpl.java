package ControllerService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Dao.ContactDaoInterfaceImpl;
import Dao.UserDaoInterfaceImpl;
import Model.Contact;
import Model.User;

public class ControllerServiceInterfaceImpl implements ControllerServiceInterface {
	ContactDaoInterfaceImpl cdii = new ContactDaoInterfaceImpl();
	UserDaoInterfaceImpl udii = new UserDaoInterfaceImpl();
	RequestDispatcher rd = null;

	@Override
	public boolean insertContact(HttpServletRequest request, HttpServletResponse response) {
		
		String contactID = request.getParameter("contactID");
        String userID=request.getParameter("userID");
		String contactName = request.getParameter("Name");
		String contactEmail = request.getParameter("Email");
		String contactAddress = request.getParameter("Address");
		String contactPhone = request.getParameter("Phone");
		System.out.println(userID +"userID");
		Contact contact = new Contact(userID,contactName, contactEmail, contactAddress, contactPhone);

		if (cdii.createContact(contact))
			return true;
		return false;

	}

	@Override
	public boolean deleteContact(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("contactID"));
		System.out.println(id + " deleteContact");

		if (cdii.deleteContact(id))
			return true;

		return false;
	}

	@Override
	public void editContact(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("contactID"));
		// System.out.println(id);
		Contact contact = cdii.searchContact(id);
		request.setAttribute("contact", contact);
		rd = request.getRequestDispatcher("update.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean updateContact(HttpServletRequest request, HttpServletResponse response) {
		Contact contact = new Contact();
		String id = request.getParameter("contactID");
		if (id == null || id.isEmpty()) {
			insertContact(request, response);
		}

		else {
			contact.setContactID(Integer.parseInt(id));
			contact.setContactName(request.getParameter("Name"));
			contact.setContactEmail(request.getParameter("Email"));
			contact.setContactAddress(request.getParameter("Address"));
			contact.setContactPhone(request.getParameter("Phone"));
			cdii.updateContact(contact);

		}
		return true;

	}

	@Override
	public void listContact(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) {
		User user=(User)httpSession.getAttribute("user1");
		
		if(user!=null) {
		ArrayList<Contact> al = cdii.contactList(user.getUserID());
		
		request.setAttribute("ContactList", al);
		rd = request.getRequestDispatcher("ContactList.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		}
		
		else
			request.setAttribute("msg", "Please login");
		rd = request.getRequestDispatcher("LoginUser.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public boolean signupUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ControllerServiceInterfaceImpl");
		String userName = request.getParameter("Name");
		String userPassword = request.getParameter("Password");
		String userEmail = request.getParameter("Email");
		String userPhone = request.getParameter("Phone");
		
		User user = new User(userName, userPassword, userEmail, userPhone);
		user.setImage("image.jpg");
		System.out.println(user);
		if (udii.signUp(user))
			return true;
		return false;

	}

	public boolean loginUser(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) throws ServletException, IOException {
		String Email = request.getParameter("Email");
		String password = request.getParameter("Password");
		
        User user=udii.loginUser(Email, password);
        System.out.println(user);
        httpSession.setAttribute("user1", user);
		if (user!= null) {
			return true;
		}
		return false;

	}

	public void listUsers(HttpServletRequest request, HttpServletResponse response) {
		
		
		ArrayList<User> al = udii.listUser();
		
		request.setAttribute("UserList", al);
		rd = request.getRequestDispatcher("UserList.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("userID"));
		// System.out.println(id);
		User user = udii.searchUser(id);
		request.setAttribute("user1", user);
		rd = request.getRequestDispatcher("updateProfile.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean updateUser(HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User();
		int id =Integer.parseInt(request.getParameter("userID"));
		System.out.println(id);
		if (id == 0) {
			signupUser(request, response);
		}

		else {
			user.setUserID(id);
			user.setUserName(request.getParameter("Name"));
			user.setUserEmail(request.getParameter("Email"));
			user.setUserPhone(request.getParameter("Phone"));
			udii.updateProfile(user);
     
		}
		return true;
	}

	public void logout(HttpServletResponse response,HttpSession session) throws IOException {
		System.out.println(session.toString());
		System.out.println(session.getAttribute("user1"));
        
		session.invalidate();
		response.sendRedirect("LoginUser.jsp");
	
		System.out.println(session.getId());
	}

	public void uploadImage(HttpServletRequest request, HttpServletResponse response) {
		ServletFileUpload upload=new ServletFileUpload(new DiskFileItemFactory() );
		int id=Integer.parseInt(request.getParameter("uid"));
		String image=request.getParameter("uimage");
		System.out.println(id+" "+image);
		try {
			List<FileItem> item=upload.parseRequest(request);
			for (FileItem fileItem : item) {
				fileItem.write(new File("C:\\Users\\hp\\eclipse-workspace\\PhoneBook\\src\\main\\webapp\\uploads\\"+fileItem.getName()));
			String imageName=fileItem.getName();
				User user=new User(id,imageName);
				udii.updateUser(user);
				request.setAttribute("msg", "Profile picture updated!!");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changePassword(HttpServletRequest request, HttpServletResponse response) {
		String ID=request.getParameter("userID");		
		String p1=request.getParameter("Password1");
		String p2=request.getParameter("Password2");
		
		
		if(p1.equals(p2))
		{
			int id=Integer.parseInt(ID);
			if(udii.updatePassword(id,p1))
			{
				request.setAttribute("msg", "Password updated successfully..please login again!");
				rd=request.getRequestDispatcher("LoginUser.jsp");
				try {
					rd.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
			
			else
				{
				request.setAttribute("msg", "Somethong went wrong, please try again!!");
				}
			rd=request.getRequestDispatcher("UpdatePassword.jsp");
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		else {
			request.setAttribute("msg", "both passwords doesn't match, please try again!!");
			rd=request.getRequestDispatcher("UpdatePassword.jsp");
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
	}
		
		
		
	}

	


