package com.dxc.HibDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.dxc.Hibutil.HibernateUtils;
import com.dxc.beans.User;

public class UserDAO implements UserHibDAO<User> {

	static SessionFactory sessionFactory;
	static Session session;
		
	@Override
	public boolean update(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(User e) {
		sessionFactory=HibernateUtils.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(e);		
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public static boolean validate(String username,String password) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		boolean res=false;
		User u=null;
		sessionFactory=HibernateUtils.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		u= (User) session.get(User.class,username);
		session.getTransaction().commit();
		session.close();
		if(u!=null)
		{
			res=true;
		}
		return res;
		
	}

}
