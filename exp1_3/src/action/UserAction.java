package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class UserAction extends ActionSupport{
	
	static Connection ct = null;
	private User user;
	private List<User> listUser = new ArrayList<User>();
	private Integer id;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/exp";
			String user = "root";
			String password = "123456";
			ct = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//得到全部用户
	public String listUI() throws Exception{
		String sql = "select * from user";
		PreparedStatement ps = ct.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("passwd"));
			System.out.println(user);
			listUser.add(user);
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		return "listUI";
	}
	
	//新增用户
	public String add() throws Exception{
		String sql = "insert into user(username,passwd) values(?, ?)";
		PreparedStatement ps = ct.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPasswd());
		ps.execute();
		
		if(ps != null) ps.close();
		return "list";
	}
	
	//编辑用户页面
	public String editUI() throws Exception{
		System.out.println(id + " 编辑的主键");
		String sql = "select * from user where id=?";
		PreparedStatement ps = ct.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("passwd"));
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		
		return "editUI";
	}
	//编辑用户
	public String edit() throws Exception{
		System.out.println(user);
		if(user != null){
			String sql = "update user set username=?, passwd=? where id=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPasswd());
			ps.setInt(3, user.getId());
			
			ps.execute();
			
			if(ps != null) ps.close();
			
		}
		return "list";
	}
	
	//删除用户
	public String delete() throws Exception{
		System.out.println("用户主键：" + id);
		if(id != null){
			String sql = "delete from user where id=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			
			if(ps != null) ps.close();
		}
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
