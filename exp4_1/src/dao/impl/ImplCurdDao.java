package dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CurdDao;
import entites.Stu;

public class ImplCurdDao implements CurdDao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.openSession();
	}
	
	public String Login(String name, String password) {
		String hql = "from Stu as p where p.stuName='" + name + "'"
				+ " and p.stuPassword='" + password + "'";
		List<Stu> list = getSession().createQuery(hql).list();
		getSession().close();
		if(list != null && list.size() != 0){
			return "success";
		}
		
		return "fail";
	}

	public String Insert(Stu stu) {
		this.getSession().saveOrUpdate(stu);
		getSession().close();
		return "success";
	}

	public String Delete(Stu stu) {
		Transaction transaction = getSession().beginTransaction();
		this.getSession().delete(stu);
		transaction.commit();
		getSession().close();
		return "success";
	}

	public List<Stu> GetAllStuIndo() {
		String hql = "from Stu as p";
		List<Stu> list = this.getSession().createQuery(hql).list();
		getSession().close();
		return list;
	}

	public String Updata(Stu stu) {
		Transaction transaction = getSession().beginTransaction();
		this.getSession().update(stu);
		transaction.commit();
		getSession().close();
		return "success";
	}

	public Stu GetStuById(Integer id) {
		String hql = "from Stu as p where p.stuId='" + id + "'";
		List<Stu> list = this.getSession().createQuery(hql).list();
		getSession().close();
		
		Stu stu = list.get(0);
		return stu;
	}

}
