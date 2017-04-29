package com.yjy.service;

import java.util.List;

import com.yjy.dao.UserDao;
import com.yjy.entity.User;

public class UserService {
	private UserDao userDao;

	
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public boolean login(User user) {
		return userDao.login(user);
	}
	public List<User> listAll() {
		return userDao.listAll();
	}
	public void addUser(User user) {
		userDao.addUser(user);
	}
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}
	public void editUser(User user) {
		userDao.editUser(user);
	}
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
}
