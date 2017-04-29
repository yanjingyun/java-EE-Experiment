package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entites.Stu;

public class StuDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Stu> GetAllStu() {
		String hql = "from Stu as p";
		Session session = sessionFactory.openSession();
		List<Stu> list = session.createQuery(hql).list();
		session.close();
		return list;
	}
	public void Insert(Stu stu) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(stu);
		transaction.commit();
		session.close();
	}

	public Stu GetStuById(int id) {
		Session session = sessionFactory.openSession();
		Stu stu = (Stu) session.get(Stu.class, id);
		session.close();
		return stu;
	}

	public void updata(Stu stu) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(stu);
		transaction.commit();
		session.close();
	}

	public void delete(Stu stu) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(stu);
		transaction.commit();
		session.close();
	}

	public List login(String username, String password) {
		Session session = sessionFactory.openSession();
		String hql = "from Stu s where s.stuName=? and s.stuPassword=?";
		List list = session.createQuery(hql).setParameter(0, username).setParameter(1, password).list();
		session.close();
		return list;
	}
	
	
}
