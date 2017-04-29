package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import dao.CurdDao;
import entites.Stu;

public class GetAllInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		CurdDao dao = (CurdDao) factory.getBean("curdDao");
		
		// ªÒ»°CurdDao
		List<Stu> list = dao.GetAllStuIndo();

		request.setAttribute("list", list);

		request.getRequestDispatcher("show.jsp").forward(request, response);

	}

}
