package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		User user = new User(username, passwd);
		UserDAO userDao = new UserDAO();

		boolean login = userDao.login(user);
		if(login){
			request.setAttribute("user", user);
			request.getRequestDispatcher("/ok.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("msg", "µ«¬º ß∞‹£¨«ÎºÏ≤È ‰»Î");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
