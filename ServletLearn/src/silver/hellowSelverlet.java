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
	//����Servletconfig��װ��servlet��������Ϣ���ҿ��Ի��servletContext����
	/*
	 * ���ĸ�������getInitParameterNames,getInitParameter,getServletName,getServletContext
	 * 		�ص�:
	 * getServletContext:����ǰwebӦ�ã�������Ϊ���ǵ�ǰwebӦ�õĴ�ܼң����Դ��л�õ�ǰwebӦ�õĸ����������Ϣ��
	 * 1.���Ի�õ�ǰWebӦ�õĳ�ʼ������
	 * 2.��ȡ��ǰwebӦ�õ�ĳһ���ļ��ڷ������ϵľ���·�� getRealPath�������ǲ���ǰ��·��
	 * 3.��ȡ��ǰwebӦ�õ�����getContextPath();
	 * 4.��ȡ��ǰwebӦ�õ�ĳһ���ļ���Ӧ����������getResourseAsStream(String path);path ��/Ϊ��ǰwebӦ�õĸ�Ŀ¼
	 * 5.��attribute��صķ���
	 * */
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");
		String userString=arg0.getInitParameter("user");//��ȡservlet��ʼ������ֵ,���������user��Ӧ�Ĳ���ֵΪroot
		
		Enumeration<String> names=arg0.getInitParameterNames();//��ò����Ĳ�����
		while (names.hasMoreElements()) {
			String name = names.nextElement();
				
		}
		String pathString=arg0.getServletContext().getRealPath("/index.jsp");//E:\apache-tomcat-7.0.77\webapps\ServletLearn\index.jsp
		
		//��ȡServletContext����
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
