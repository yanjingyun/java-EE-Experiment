package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CurdDao;
import entites.Stu;

public class UpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String stuName = request.getParameter("stuName");
		String stuPassword = request.getParameter("stuPassword");
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		CurdDao curdDao = (CurdDao) factory.getBean("curdDao");
		
		Stu stu = new Stu(id, stuName, stuPassword, stuAge);
		curdDao.Updata(stu );
		
		request.getRequestDispatcher("GetAllInfoServlet").forward(request, response);
		
	}
}
