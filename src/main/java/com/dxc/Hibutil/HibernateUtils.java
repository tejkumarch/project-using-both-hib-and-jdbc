package com.dxc.Hibutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {

	private static SessionFactory sessionFactory=buildSessionFactory();
	private static final String HIBERNATE_CFG="hibernate.cfg.xml";
	
	
	static SessionFactory buildSessionFactory()
	{
		Configuration configuration=new Configuration().addResource(HIBERNATE_CFG).configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();

		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		
		return sessionFactory;

	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
