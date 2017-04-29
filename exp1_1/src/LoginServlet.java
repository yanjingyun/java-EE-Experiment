import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		System.out.println(username + " " + passwd);
		//jdbc
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/exp";
			String user = "root";
			String password = "123456";
			Connection ct = DriverManager.getConnection(url, user, password);
			if(ct != null) System.out.println("连接成功");
			String sql = "select * from user where username=? and passwd=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, passwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("登录成功！！");
				request.setAttribute("username", username);
				request.getRequestDispatcher("/ok.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "登录失败，请检查输入");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
