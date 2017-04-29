package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "loginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			String sql = "select * from user where username=? and passwd=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, passwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("µÇÂ¼³É¹¦£¡£¡");
				request.setAttribute("username", username);
				request.getRequestDispatcher("/ok.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "µÇÂ¼Ê§°Ü£¬Çë¼ì²éÊäÈë");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(ct != null) ct.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
