package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StuDao;
import entites.Stu;

public class DeleteStuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		StuDao stuDao = (StuDao) factory.getBean("stuDao");
		
		Stu stu = new Stu();
		stu.setStuId(id);
		stuDao.delete(stu);
		
		request.getRequestDispatcher("getAllStu").forward(request, response);
		
	}
}
