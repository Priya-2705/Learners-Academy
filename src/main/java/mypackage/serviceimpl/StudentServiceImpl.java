package mypackage.serviceimpl;

import mypackage.dao.AdminDao;
import mypackage.dao.ClazzDao;
import mypackage.dao.StudentDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.daoimpl.ClazzDaoImpl;
import mypackage.daoimpl.StudentDaoImpl;
import mypackage.entities.Admin;
import mypackage.entities.Clazz;
import mypackage.entities.Student;
import mypackage.models.StudentModel;
import mypackage.services.StudentService;

public class StudentServiceImpl implements StudentService{

	private StudentDao studentDao = new StudentDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();
	private ClazzDao clazzDao = new ClazzDaoImpl();
	
	@Override
	public void addStudent(Admin admin, StudentModel studentModel) {
		
		try {
		Admin adm = adminDao.getAdmin(admin.getUsername(), admin.getPassword());
		
		Clazz clazz = clazzDao.getClazzById(Integer.parseInt(studentModel.getCid()));
		Student student = new Student();
		student.setStudent_name(studentModel.getName());
		student.setAddress(studentModel.getAddress());
		student.setAdmin(adm);
		student.setClazz(clazz);
		
		adm.addStudent(student);
		studentDao.add(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
