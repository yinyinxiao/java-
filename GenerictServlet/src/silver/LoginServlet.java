
package silver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

public class LoginServlet implements Servlet {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	private ServletConfig servletConfig;
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig=arg0;

	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=arg0.getParameter("username");
		String password=arg0.getParameter("password");
		
		ServletContext servletContext=servletConfig.getServletContext();
		String inituser=servletContext.getInitParameter("user");
		String initpassword=servletContext.getInitParameter("password");
		
		PrintWriter out=arg1.getWriter();
		if(inituser.equals(username)&&initpassword.equals(password)){
			out.println("hello"+username);
		}else{
			out.print("sorry"+username);
		}
		
		

	}

}
