package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StuDao;
import entites.Stu;


public class GetAllStu extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		StuDao dao = (StuDao) factory.getBean("stuDao");
		// ªÒ»°CurdDao
		List<Stu> list = dao.GetAllStu();

		request.setAttribute("list", list);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

}
