package mypackage.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypackage.entities.Admin;
import mypackage.entities.Clazz;
import mypackage.entities.Student;
import mypackage.entities.Subject;
import mypackage.entities.Teacher;

public class HibernateUtil {

	
	static SessionFactory sessionFactory = null;
	
	public static SessionFactory buildSessionFactory() {
		
		if(sessionFactory != null) {
			return sessionFactory;
		}
			
		// STEP 1: Create Configuration Object
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				           .addAnnotatedClass(Subject.class).addAnnotatedClass(Clazz.class).addAnnotatedClass(Teacher.class).addAnnotatedClass(Admin.class);
		sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
}

    
