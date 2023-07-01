package mypackage.dao;

import java.util.List;

import mypackage.entities.Clazz;
import mypackage.entities.Subject;

public interface SubjectDao {
	
	void add(Subject subject) throws Exception;
	void delete(int sid) throws Exception;
	void update(Subject subject) throws Exception;
	List<Subject> getAll();
	Subject getSubjectById(int subjectId);
    List<Subject> getByClass(Clazz clazz);
}
