package com.dxc.HibDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.dxc.Hibutil.HibernateUtils;
import com.dxc.beans.Exam;

public class ExamHibDAO implements UserHibDAO<Exam> {
	SessionFactory sessionFactory;
	Session session;
		
	
	public boolean update(Exam e) {
		sessionFactory=HibernateUtils.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(e);		
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean insert(Exam e) {
		
		sessionFactory=HibernateUtils.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();

		return true;
	}

	public boolean delete(String id) {
		sessionFactory=HibernateUtils.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		Exam exam=(Exam)session.get(Exam.class, id);
		session.delete(exam);
		session.getTransaction().commit();
		session.close();

		return true;
	}

	public Exam find(String id) {
		sessionFactory=HibernateUtils.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		Exam e= (Exam) session.get(Exam.class,id);
		session.getTransaction().commit();
		session.close();
		return e;
	}

	public List<Exam> findAll(){
		sessionFactory=HibernateUtils.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Exam");
		List<Exam> e=query.list();
		session.getTransaction().commit();
		session.close();
		return e;
	}

}
