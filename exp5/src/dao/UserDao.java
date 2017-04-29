package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao {
	static Connection ct = null;
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
	public boolean login(User user) throws Exception {
		String sql = "select * from user where username=? and passwd=?";
		PreparedStatement ps = ct.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPasswd());
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			return true;
		}
		if(ps != null) ps.close();
		return false;
	}
	public List<User> listAll() throws Exception {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user";
		PreparedStatement ps = ct.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("passwd"));
			list.add(user);
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		return list;
	}
	public boolean add(User user) throws SQLException {
		String sql = "insert into user(username,passwd) values(?, ?)";
		PreparedStatement ps = ct.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPasswd());
		boolean b = ps.execute();
		
		if(ps != null) ps.close();
		
		return b;
	}
	public User getUser(Integer id) throws SQLException {
		User user = new User();
		String sql = "select * from user where id=?";
		PreparedStatement ps = ct.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("passwd"));
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		
		return user;
	}
	public boolean editUser(User user) throws SQLException {
		String sql = "update user set username=?, passwd=? where id=?";
		PreparedStatement ps = ct.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPasswd());
		ps.setInt(3, user.getId());
		
		boolean b = ps.execute();
		
		if(ps != null) ps.close();
		return b;
	}
	public boolean deleteUser(Integer id) throws SQLException {
		String sql = "delete from user where id=?";
		PreparedStatement ps = ct.prepareStatement(sql);
		ps.setInt(1, id);
		boolean b = ps.execute();
		
		if(ps != null) ps.close();
		
		return b;
	}
	
}
