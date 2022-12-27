package ControllerService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface ControllerServiceInterface {
public boolean insertContact(HttpServletRequest request, HttpServletResponse response);
public boolean deleteContact(HttpServletRequest request, HttpServletResponse response);
public void editContact(HttpServletRequest request, HttpServletResponse response);
public boolean updateContact(HttpServletRequest request, HttpServletResponse response);
public void listContact(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession);
public boolean signupUser(HttpServletRequest request, HttpServletResponse response);
public boolean loginUser(HttpServletRequest request, HttpServletResponse response,HttpSession httpSession) throws ServletException, IOException;

public void listUsers(HttpServletRequest request, HttpServletResponse response);

}
