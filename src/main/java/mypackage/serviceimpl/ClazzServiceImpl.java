package mypackage.serviceimpl;

import mypackage.dao.AdminDao;
import mypackage.dao.ClazzDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.daoimpl.ClazzDaoImpl;
import mypackage.entities.Admin;
import mypackage.entities.Clazz;
import mypackage.models.ClazzModel;
import mypackage.services.ClazzService;

public class ClazzServiceImpl implements ClazzService {

	private ClazzDao clazzDao = new ClazzDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();
	
	@Override
	public void addClazz(Admin admin, ClazzModel clazzModel) {
		
		try {
		Admin adm = adminDao.getAdmin(admin.getUsername(), admin.getPassword());
		
		Clazz clazz = new Clazz();
		clazz.setClazz_name(clazzModel.getName());
		clazz.setAdmin(adm);

		adm.addClazz(clazz);
		clazzDao.add(clazz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
