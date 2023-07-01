package mypackage.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mypackage.dao.StudentDao;
import mypackage.entities.Clazz;
import mypackage.entities.Student;
import mypackage.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void add(Student student) throws Exception {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
            }
            throw new Exception("Failed to add teacher.", e);
		} finally {
            session.close();
        }
	}

	@Override
	public void delete(int sid) throws Exception {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = session.get(Student.class, sid);
			session.delete(student);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
            }
            throw new Exception("Failed to delete teacher.", e);
		} finally {
            session.close();
        }
	}

	@Override
	public List<Student> getAll() {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Student> query = session.createQuery("select s from mypackage.entities.Student s");
		return query.list();
	}

	@Override
	public List<Student> getByClass(Clazz clazz) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Student> query = session.createQuery("SELECT s FROM Student s WHERE s.clazz = :clazz");
        query.setParameter("clazz", clazz);
        List<Student> students = query.list();
        session.close();
        return students;
	}

}
