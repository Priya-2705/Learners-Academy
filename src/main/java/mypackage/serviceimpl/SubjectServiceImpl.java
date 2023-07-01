package mypackage.serviceimpl;

import mypackage.dao.AdminDao;
import mypackage.dao.ClazzDao;
import mypackage.dao.SubjectDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.daoimpl.ClazzDaoImpl;
import mypackage.daoimpl.SubjectDaoImpl;
import mypackage.entities.Admin;
import mypackage.entities.Clazz;
import mypackage.entities.Subject;
import mypackage.models.SubjectModel;
import mypackage.services.SubjectService;

public class SubjectServiceImpl implements SubjectService {

	private SubjectDao subjectDao = new SubjectDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();
	private ClazzDao clazzDao = new ClazzDaoImpl();

	@Override
	public void addSubject(Admin admin, SubjectModel subjectModel) {

		try {
			Admin adm = adminDao.getAdmin(admin.getUsername(), admin.getPassword());

			Clazz clazz = clazzDao.getClazzById(Integer.parseInt(subjectModel.getCid()));
			Subject subject = new Subject();
			subject.setSubject_name(subjectModel.getName());
			subject.setSubject_level(subjectModel.getLevel());
			subject.setAdmin(adm);
			subject.setClazz(clazz);

			adm.addSubject(subject);
			subjectDao.add(subject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
