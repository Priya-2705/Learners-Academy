package mypackage.serviceimpl;

import mypackage.dao.AdminDao;
import mypackage.daoimpl.AdminDaoImpl;
import mypackage.entities.Admin;
import mypackage.models.AdminModel;
import mypackage.models.LoginModel;
import mypackage.services.AdminService;

public class AdminServiceImpl implements AdminService{

	private AdminDao dao = new AdminDaoImpl();
	
	@Override
	public void register(AdminModel adminModel) {
		
		Admin admin = new Admin();
		admin.setUsername(adminModel.getUsername());
		admin.setPassword(adminModel.getPassword());
		dao.insert(admin);		
	}

	@Override
	public Admin getAdmin(LoginModel loginModel) {
		
		return dao.getAdmin(loginModel.getUsername(), loginModel.getPassword());
	}

}
