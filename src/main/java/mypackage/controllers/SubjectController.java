package mypackage.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypackage.dao.ClazzDao;
import mypackage.daoimpl.ClazzDaoImpl;
import mypackage.entities.Admin;
import mypackage.entities.Clazz;
import mypackage.models.SubjectModel;
import mypackage.serviceimpl.SubjectServiceImpl;
import mypackage.services.SubjectService;

@WebServlet("/subjectcontroller")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SubjectService subjectService = new SubjectServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String subjectName = request.getParameter("subjectname");
    	String subjectLevel = request.getParameter("subjectlevel");
    	String clazzName = request.getParameter("clazzname");
    		
    	SubjectModel subjectModel = new SubjectModel(subjectName, subjectLevel, clazzName);
    	HttpSession session = request.getSession();
    	Admin admin = (Admin) session.getAttribute("admin");
    	subjectService.addSubject(admin, subjectModel);
    		
    	RequestDispatcher rd = request.getRequestDispatcher("subjectslist.jsp");
    	rd.forward(request, response);
	}
}
