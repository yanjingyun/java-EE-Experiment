package com.yjy.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yjy.entity.User;
import com.yjy.service.UserService;


public class UserAction extends ActionSupport {
	private UserService userService;
	private User user;
	private List<User> listUser = new ArrayList<User>();
	
	//登录
	public String login() throws Exception{
		boolean b = userService.login(user);
		if(b){
			ServletActionContext.getRequest().setAttribute("user", user);
			return "success";
		}
		ServletActionContext.getRequest().setAttribute("msg", "登录失败！！");
		return "index";
	}

	//得到全部用户
	public String listUI() throws Exception{
		listUser = userService.listAll();
		return "listUI";
	}
	
	//新增用户
	public String add() throws Exception{
		userService.addUser(user);
		return "list";
	}
	
	//编辑用户页面
	public String editUI() throws Exception{
		user = userService.getUser(user.getId());
		System.out.println(user);
		return "editUI";
	}
	//编辑用户
	public String edit() throws Exception{
		userService.editUser(user);
		return "list";
	}
	
	//删除用户
	public String delete() throws Exception{
		userService.deleteUser(user);
		return "list";
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUser() {
		return listUser;
	}
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
