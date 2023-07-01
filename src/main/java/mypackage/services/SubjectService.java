package mypackage.services;

import mypackage.entities.Admin;
import mypackage.models.SubjectModel;

public interface SubjectService {
	
	void addSubject(Admin admin, SubjectModel subjectModel);

}
