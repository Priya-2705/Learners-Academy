package mypackage.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mypackage.dao.TeacherDao;
import mypackage.entities.Teacher;
import mypackage.util.HibernateUtil;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public void add(Teacher teacher) throws Exception {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(teacher);
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
	public void delete(int tid) throws Exception {

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, tid);
			session.delete(teacher);
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
	public List<Teacher> getAll() {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Teacher> query = session.createQuery("select t from mypackage.entities.Teacher t");
		return query.list();
	}
}
