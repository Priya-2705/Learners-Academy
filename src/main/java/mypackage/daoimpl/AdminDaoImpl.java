package mypackage.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mypackage.dao.AdminDao;
import mypackage.entities.Admin;
import mypackage.util.HibernateUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void insert(Admin admin) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(admin);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public Admin getAdmin(String username, String password) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Query<Admin> query = null;
		Admin admin = null;
		try {
			sessionFactory = HibernateUtil.buildSessionFactory();
			session = sessionFactory.openSession();
			query = session.createQuery("select a from mypackage.entities.Admin a where a.username = ?1 and a.password = ?2");
			query.setParameter(1, username); // Set the value for the first ordinal parameter
			query.setParameter(2, password);
			admin = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return admin;
	}

}
