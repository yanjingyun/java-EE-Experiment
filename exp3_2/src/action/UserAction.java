package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;

import entity.User;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User user;
	
	public String listUI(){
		UserDAO userDao = new UserDAO();
		List<User> list = userDao.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "success";
	}

	public String editUI(){
		UserDAO userDao = new UserDAO();
		System.out.println("id=" + user.getId());
		
		User u = userDao.findById(user.getId());
		if(u != null){
			ServletActionContext.getRequest().setAttribute("user", u);
			return "success";
		}
		return "error";
	}
	public String edit(){
		UserDAO userDao = new UserDAO();
		userDao.updateUser(user);
		
		return listUI();
	}
	
	public String delete(){
		UserDAO userDao = new UserDAO();
		userDao.delete(user);
		
		return listUI();
	}
	
	public String addUser(){
		UserDAO userDao = new UserDAO();
		userDao.save(user);
		
		return listUI();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
