package cn.hibernate.test;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.hibernate.po.Student;

public class HbTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transcaction;

	@Test
	public void test() throws Exception {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		session=sessionFactory.openSession();
		transcaction=session.beginTransaction();
		
		Student s=new Student();
		s.setUsername("李四");
		s.setBirthday(new Date());
		s.setAddress("上海");
		session.save(s);
		
		transcaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void getCurrentSessionTest() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		session=sessionFactory.getCurrentSession();
		if(session!=null){
			System.out.println("创建成功");
		}else{
			System.out.println("创建失败");
		}
	}
	
	@Test
	public void opensessionTest() throws Exception {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		session=sessionFactory.openSession();
		transcaction=session.beginTransaction();
		
		transcaction.commit();
		session.close();
		sessionFactory.close();
	}
}
