package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private String passwd;
	
	public String login(){
		System.out.println(username + " " + passwd);
		System.out.println("µÇÂ¼½çÃæ");
		
		//jdbc
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/exp";
			String user = "root";
			String password = "123456";
			ct = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from user where username=? and passwd=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("µÇÂ¼³É¹¦£¡£¡");
				return "success";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(ct != null) ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		ServletActionContext.getRequest().setAttribute("msg", "µÇÂ¼Ê§°Ü£¬Çë¼ì²éÊäÈë");
		return "error";
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
