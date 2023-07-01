package mypackage.dao;

import java.util.List;

import mypackage.entities.Clazz;

public interface ClazzDao {
	
	void add(Clazz clazz) throws Exception;
	void delete(int id) throws Exception;
	Clazz getClazzById(int cid);
	List<Clazz> getAll();
    Clazz getByName(String className);
}
