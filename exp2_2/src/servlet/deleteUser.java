package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class deleteUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO userDao = new UserDAO();
		User user = new User();
		user.setId(id);
		userDao.delete(user);
		
		List list = userDao.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("listUI.jsp").forward(request, response);
	}

}
