package cn.hibernate.test;


import java.util.Date;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import cn.hibernate.po.Contact;
import cn.hibernate.po.Grade;
import cn.hibernate.po.Student;
import cn.hibernate.util.HibernateUtil;

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
		Contact contact=new Contact("215000","13888888888");
		s.setContact(contact);
		session.save(s);
		
		transcaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void getStudent(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		session=sessionFactory.openSession();
		transcaction=session.beginTransaction();
		
		Student s=(Student) session.get(Student.class, 1);
		System.out.println(s);

		
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
	
	
	
	
	@Test
	public void gradeTest(){
		Grade g=new Grade();
		g.setGname("Java");
		g.setGdesc("Java开发");
		Student s1=new Student();
		Student s2=new Student();
		s1.setUsername("李");
		s2.setUsername("赵");
		g.getStudent().add(s1);
		g.getStudent().add(s2);
		Session session=HibernateUtil.geSession();
		Transaction tx=session.beginTransaction();
		session.save(g);
		session.save(s1);
		session.save(s2);
		tx.commit();
	}
	
	@Test
	public void findStudentByGrade(){
		Session session=HibernateUtil.geSession();
		Transaction tx=session.beginTransaction();
		Grade grade=(Grade) session.get(Grade.class, 1);
		System.out.println(grade.getGname()+","+grade.getGdesc());
		Set<Student> students =grade.getStudent();
		for (Student student : students) {
			System.out.println(student.getUsername());
		}
		tx.commit();
	}
	
	@Test
	public void updateStudent(){
		Grade g=new Grade();
		g.setGname("C++");
		g.setGdesc("C++开发");
		Session session=HibernateUtil.geSession();
		Transaction tx = session.beginTransaction();
		Student stu=(Student) session.get(Student.class, 1);
		g.getStudent().add(stu);
		session.save(g);
		tx.commit();
		
	}
	
	@Test
	public void deleteStudent(){
		Session session=HibernateUtil.geSession();
		Transaction tx = session.beginTransaction();
		Student stu=(Student) session.get(Student.class, 2);
		session.delete(stu);
		tx.commit();
	}
}
