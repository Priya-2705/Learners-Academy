package mypackage.services;

import mypackage.entities.Admin;
import mypackage.models.ClazzModel;

public interface ClazzService {
	
	void addClazz(Admin admin, ClazzModel clazzModel);
}
