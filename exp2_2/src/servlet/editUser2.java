package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

import entity.User;

public class editUser2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		User user = new User(username, passwd);
		user.setId(id);
		
		UserDAO userDao = new UserDAO();
		userDao.updateUser(user);

		List list = userDao.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("listUI.jsp").forward(request, response);
	}

}
