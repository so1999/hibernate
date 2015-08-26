package cn.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;
	
	static{
		Configuration config=new Configuration().configure();
		//StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

		sessionFactory=config.buildSessionFactory(serviceRegistry);
		
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static Session geSession(){
		session=sessionFactory.getCurrentSession();
		return session;
	}
	public static void closeSession(Session session){
		if(session!=null){
			session.close();
		}
	}
}
