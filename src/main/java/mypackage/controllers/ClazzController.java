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
import mypackage.models.ClazzModel;
import mypackage.serviceimpl.ClazzServiceImpl;
import mypackage.services.ClazzService;

@WebServlet("/clazzcontroller")
public class ClazzController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClazzService clazzService = new ClazzServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String clazzName = request.getParameter("clazzname");
		
		ClazzModel clazzModel = new ClazzModel(clazzName);
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		clazzService.addClazz(admin, clazzModel);
		
		RequestDispatcher rd = request.getRequestDispatcher("clazzlist.jsp");
		rd.forward(request, response);
	}
}
