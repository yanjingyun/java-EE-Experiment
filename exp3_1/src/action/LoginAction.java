package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;

import entity.User;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User user;
	public String login(){
		System.out.println(user);
		
		UserDAO userDao = new UserDAO();
		User u = userDao.getUserByNameAndPasswd(user);
		if(u != null){
			ServletActionContext.getRequest().setAttribute("user", u);
			return "success";
		}
		ServletActionContext.getRequest().setAttribute("msg", "µ«¬º ß∞‹£¨«ÎºÏ≤È ‰»Î");
		return "error";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
