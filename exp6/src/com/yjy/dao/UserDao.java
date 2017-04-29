package com.yjy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yjy.entity.User;

public class UserDao {
	private SessionFactory sessionFactory;
	
	
	public boolean login(User user) {
		String hql = "from User u where u.username=? and u.passwd=?";
		List<User> list = getSession().createQuery(hql).setParameter(0, user.getUsername()).setParameter(1, user.getPasswd()).list();
		if(list != null && list.size()!=0){
			return true;
		}
		return false;
	}
	public List<User> listAll() {
		String hql = "from User u";
		List<User> list = getSession().createQuery(hql).list();
		return list;
	}
	public void addUser(User user) {
		getSession().save(user);
	}
	
	public User getUser(Integer id) {
		
		return (User) getSession().get(User.class, id);
	}
	
	public void editUser(User user) {
		getSession().update(user);
	}
	
	public void deleteUser(User user) {
		getSession().delete(user);
	}
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
}
