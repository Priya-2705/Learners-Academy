package mypackage.services;

import mypackage.entities.Admin;
import mypackage.models.TeacherModel;

public interface TeacherService {
	
	void addTeacher(Admin admin, TeacherModel teacherModel);
}
