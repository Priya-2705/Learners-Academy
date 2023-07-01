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
import mypackage.models.TeacherModel;
import mypackage.serviceimpl.TeacherServiceImpl;
import mypackage.services.TeacherService;

@WebServlet("/teachercontroller")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TeacherService teacherService = new TeacherServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String teacherName = request.getParameter("teachername");
		System.out.println(teacherName);
		String qualification = request.getParameter("qualification");
		System.out.println(qualification);
		String clazzName = request.getParameter("clazzname");
		System.out.println(clazzName);
		
		TeacherModel teacherModel = new TeacherModel(teacherName, qualification, clazzName);
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		teacherService.addTeacher(admin, teacherModel);
		
		RequestDispatcher rd = request.getRequestDispatcher("teacherslist.jsp");
		rd.forward(request, response);
	}

}
