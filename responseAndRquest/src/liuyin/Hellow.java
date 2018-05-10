import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hellow implements Servlet{

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

	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("«Î«Û¿¥¡À");
		/*
		 * <form action="hellow" method="post">
  	name:<input type="text" name="user"/>
  	pawssard:<input type="password" name="password"/>
  	<input type="submit"/>
  </form> */
		String user=arg0.getParameter("user");
		String password=arg0.getParameter("password");
		System.out.println("name:"+user);
		System.out.println("pwd:"+password);
			Enumeration<String> names=arg0.getParameterNames();
			while (names.hasMoreElements()) {
				String name=names.nextElement();
				String val =arg0.getParameter(name);
				System.out.println(name+"::"+val);
			}
		
		
		
	
		
	}

}
