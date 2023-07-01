package mypackage.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mypackage.dao.SubjectDao;
import mypackage.entities.Clazz;
import mypackage.entities.Subject;
import mypackage.util.HibernateUtil;

public class SubjectDaoImpl implements SubjectDao {

	@Override
	public void add(Subject subject) throws Exception {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(subject);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
            }
            throw new Exception("Failed to add subject.", e);
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
			Subject subject = session.get(Subject.class, sid);
			session.delete(subject);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
            }
            throw new Exception("Failed to delete subject.", e);
		} finally {
            session.close();
        }		
	}
	
	@Override
	public void update(Subject subject) throws Exception {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Subject sub = session.get(Subject.class, subject.getSubject_id());
			session.update(sub);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
                tx.rollback();
            }
            throw new Exception("Failed to update subject.", e);
		} finally {
            session.close();
        }	
	}

	@Override
	public List<Subject> getAll() {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Subject> query = session.createQuery("select s from mypackage.entities.Subject s");
		return query.list();
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Subject> query = session.createQuery("select s from mypackage.entities.Subject s where s.subject_id = ?1");
		query.setParameter(1, subjectId);
		Subject result = (Subject) query.uniqueResult();
		session.close();
		return result;
	}

	@Override
	public List<Subject> getByClass(Clazz clazz) {
		
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Subject> query = session.createQuery("SELECT s FROM Subject s WHERE s.clazz = :clazz");
        query.setParameter("clazz", clazz);
        List<Subject> subjects = query.list();
        session.close();
        return subjects;
	}
}
