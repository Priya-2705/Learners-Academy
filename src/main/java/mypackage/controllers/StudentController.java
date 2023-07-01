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
import mypackage.models.StudentModel;
import mypackage.serviceimpl.StudentServiceImpl;
import mypackage.services.StudentService;

@WebServlet("/studentcontroller")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StudentService studentService = new StudentServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String studentName = request.getParameter("studentname");
		String studentAddress = request.getParameter("studentaddress");
		String clazzName = request.getParameter("clazzname");

		StudentModel studentModel = new StudentModel(studentName, studentAddress, clazzName);
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		studentService.addStudent(admin, studentModel);
		
		RequestDispatcher rd = request.getRequestDispatcher("studentslist.jsp");
		rd.forward(request, response);
	}
}
