package mypackage.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypackage.entities.Admin;
import mypackage.models.LoginModel;
import mypackage.serviceimpl.AdminServiceImpl;
import mypackage.services.AdminService;

@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService adminService = new AdminServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginModel loginModel = new LoginModel();
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		
		Admin admin = adminService.getAdmin(loginModel);
		if(admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else
			response.sendRedirect("invalidcred.jsp");		
	}
}
