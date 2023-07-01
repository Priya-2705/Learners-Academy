package mypackage.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import mypackage.dao.AdminDao;
import mypackage.dao.ClazzDao;
import mypackage.dao.TeacherDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.daoimpl.ClazzDaoImpl;
import mypackage.daoimpl.TeacherDaoImpl;
import mypackage.entities.Admin;
import mypackage.entities.Clazz;
import mypackage.entities.Teacher;
import mypackage.models.TeacherModel;
import mypackage.services.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private AdminDao adminDao = new AdminDaoImpl();
	private TeacherDao teacherDao = new TeacherDaoImpl();
	private ClazzDao clazzDao = new ClazzDaoImpl();

	@Override
	public void addTeacher(Admin admin, TeacherModel teacherModel) {

		try {
			Admin adm = adminDao.getAdmin(admin.getUsername(), admin.getPassword());
			
			Clazz clazz = clazzDao.getClazzById(Integer.parseInt(teacherModel.getCid()));		
			Teacher teacher = new Teacher();
			teacher.setTeacher_name(teacherModel.getName());
			teacher.setTeacher_qual(teacherModel.getQualification());
			teacher.setAdmin(adm);
			
			Set<Clazz> clazzSet = new HashSet<>();
			clazzSet.add(clazz);
			teacher.setClazzes(clazzSet);
			
			adm.addTeacher(teacher);
			teacherDao.add(teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
