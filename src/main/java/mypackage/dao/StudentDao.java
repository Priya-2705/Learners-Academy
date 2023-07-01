package mypackage.dao;

import java.util.List;

import mypackage.entities.Clazz;
import mypackage.entities.Student;

public interface StudentDao {
	
	void add(Student student) throws Exception;
	void delete(int sid) throws Exception;
	List<Student> getAll();
    List<Student> getByClass(Clazz clazz);
}
