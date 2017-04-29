package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.sun.xml.internal.ws.api.server.Module;

import dao.CurdDao;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CurdDao curddao;

	public CurdDao getCurddao() {
		return curddao;
	}

	public void setCurddao(CurdDao curddao) {
		this.curddao = curddao;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("usename");
		String password = request.getParameter("password");

		// 从spring的配置文件中装载sessionfactory
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		CurdDao dao = (CurdDao) factory.getBean("CurdDao");


		String result = dao.Login(name, password);

		if (result.equals("success")) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("Fail.jsp");
		}

	}

}
