package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StuDao;
import entites.Stu;

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// ªÒ»°CurdDao
		StuDao dao = (StuDao) factory.getBean("stuDao");

		Stu stu = new Stu();
		stu.setStuAge(Integer.parseInt(request.getParameter("age")));
		stu.setStuName(request.getParameter("name"));
		stu.setStuPassword(request.getParameter("password"));

		dao.Insert(stu);

		request.getRequestDispatcher("getAllStu").forward(request,response);
	}

}
