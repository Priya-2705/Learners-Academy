package mypackage.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mypackage.dao.ClazzDao;
import mypackage.entities.Clazz;
import mypackage.util.HibernateUtil;

public class ClazzDaoImpl implements ClazzDao {

	@Override
	public void add(Clazz clazz) throws Exception {

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(clazz);
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
	public void delete(int id) throws Exception {

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Clazz clazz = session.get(Clazz.class, id);
			session.delete(clazz);
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
	public List<Clazz> getAll() {

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Clazz> query = session.createQuery("select c from mypackage.entities.Clazz c");
		return query.list();
	}

	@Override
	public Clazz getClazzById(int cid) {

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Clazz> query = session.createQuery("select c from mypackage.entities.Clazz c where c.clazz_id = ?1");
		query.setParameter(1, cid);
		Clazz result = (Clazz) query.uniqueResult();
		session.close();
		return result;
	}

	@Override
	public Clazz getByName(String className) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Clazz> query = session.createQuery("SELECT c FROM Clazz c WHERE c.className = :className");
        query.setParameter("className", className);
        Clazz result = query.uniqueResult();
        session.close();
        return result;
	}
}
