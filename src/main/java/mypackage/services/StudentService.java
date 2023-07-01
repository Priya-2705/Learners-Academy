package mypackage.services;

import mypackage.entities.Admin;
import mypackage.models.StudentModel;

public interface StudentService {
	
	void addStudent(Admin admin, StudentModel studentModel);
}
