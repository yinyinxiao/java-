package silver.liuyin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class AddressServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name =request.getParameter("name");
		String sex=request.getParameter("sex");
		String address=request.getParameter("address");
		UserBean user=new UserBean();
		user.setName(name);
		user.setAddress(address);
		user.setSex(sex);
		ServletContext application=getServletContext();
		ArrayList<UserBean>list=(ArrayList<UserBean>)application.getAttribute("users");
		if(list==null){
			list=new ArrayList<UserBean>();
		}
		list.add(user);
		application.setAttribute("users",list );
		RequestDispatcher dispatcher=request.getRequestDispatcher("manager.jsp");
		dispatcher.forward(request, response);
		
	}

}
