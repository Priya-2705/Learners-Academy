package mypackage.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypackage.models.AdminModel;
import mypackage.serviceimpl.AdminServiceImpl;
import mypackage.services.AdminService;

@WebServlet("/registercontroller")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AdminService adminService = new AdminServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminModel adminModel = new AdminModel(username, password);
		adminService.register(adminModel);
		RequestDispatcher rd = request.getRequestDispatcher("registrationsuccessful.jsp");
		rd.forward(request, response);
		
	}

}
