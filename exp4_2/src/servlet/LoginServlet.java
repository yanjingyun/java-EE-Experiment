package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StuDao;
import entites.Stu;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		StuDao dao = (StuDao) factory.getBean("stuDao");
		
		String username = request.getParameter("usename");
		String password = request.getParameter("password");

		List list = dao.login(username, password);
		if(list != null && list.size() != 0){
			request.getRequestDispatcher("success.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

}
