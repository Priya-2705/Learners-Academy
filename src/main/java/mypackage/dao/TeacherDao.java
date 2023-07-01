package mypackage.dao;

import java.util.List;

import mypackage.entities.Teacher;

public interface TeacherDao {
	
	void add(Teacher teacher) throws Exception;
	void delete(int tid) throws Exception;
	List<Teacher> getAll();
}
