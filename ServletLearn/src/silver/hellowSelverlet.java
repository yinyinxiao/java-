package silver;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class hellowSelverlet implements Servlet{
	@Override
	public void destroy() {
		System.out.println("destory");
		
	}
	public hellowSelverlet(){
		System.out.println("hellowServlet");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	//参数Servletconfig封装了servlet的配置信息并且可以获得servletContext对象
	/*
	 * 有四个方法：getInitParameterNames,getInitParameter,getServletName,getServletContext
	 * 		重点:
	 * getServletContext:代表当前web应用，可以认为它是当前web应用的大管家，可以从中获得当前web应用的各个方面的信息。
	 * 1.可以获得当前Web应用的初始化参数
	 * 2.获取当前web应用的某一个文件在服务器上的绝对路径 getRealPath，而不是部署前的路径
	 * 3.获取当前web应用的名称getContextPath();
	 * 4.获取当前web应用的某一个文件对应的输入流。getResourseAsStream(String path);path 的/为当前web应用的根目录
	 * 5.和attribute相关的方法
	 * */
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");
		String userString=arg0.getInitParameter("user");//获取servlet初始化参数值,这里参数名user对应的参数值为root
		
		Enumeration<String> names=arg0.getInitParameterNames();//获得参数的参数名
		while (names.hasMoreElements()) {
			String name = names.nextElement();
				
		}
		String pathString=arg0.getServletContext().getRealPath("/index.jsp");//E:\apache-tomcat-7.0.77\webapps\ServletLearn\index.jsp
		
		//获取ServletContext对象
		ServletContext servletContext=arg0.getServletContext();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
		
	}
}
