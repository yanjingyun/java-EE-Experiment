package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;

import dao.UserDAO;
import entity.User;


public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		
		UserDAO userDao = new UserDAO();
		String hql = "from User where username=:username and passwd=:passwd";
		Query query = userDao.getSession().createQuery(hql).setString("username", username).setString("passwd", passwd);
		User user = (User) query.uniqueResult();
		if(user != null){
			request.setAttribute("user", user);
			request.getRequestDispatcher("ok.jsp").forward(request, response);
			return;
		}
		request.setAttribute("msg", "登录不成功，请检查输入");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
