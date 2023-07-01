package mypackage.dao;

import mypackage.entities.Admin;

public interface AdminDao {
	
	void insert(Admin admin);
	Admin getAdmin(String username, String password);
}
