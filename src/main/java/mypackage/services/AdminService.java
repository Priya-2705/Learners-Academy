package mypackage.services;

import mypackage.entities.Admin;
import mypackage.models.AdminModel;
import mypackage.models.LoginModel;

public interface AdminService {
	
	void register(AdminModel adminModel);
	Admin getAdmin(LoginModel loginModel);
}
