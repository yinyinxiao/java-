package liuyin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liuyin.Teacher;

/**
 * Servlet implementation class FindServlet
 */
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// 加载数据库驱动，注册到驱动管理器
			Class.forName("com.mysql.jdbc.Driver");
			// 数据库连接字符串
			String url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf-8";
			// 数据库用户名
			String username = "root";
			// 数据库密码
			String password = "";
			// 创建Connection连接
			Connection conn = DriverManager.getConnection(url, username,
					password);
			// 添加图书信息的SQL语句
			String sql = "select * from teachers";
			// 获取Statement
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			List<Teacher> list = new ArrayList<Teacher>();
			while (resultSet.next()) {

				Teacher teacher = new Teacher();
				teacher.setID(resultSet.getString("id"));
				teacher.setPassword(resultSet.getString("name"));
				teacher.setUsername(resultSet.getString("password"));
				list.add(teacher);

			}
			request.setAttribute("list", list);
			resultSet.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("book_list.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
