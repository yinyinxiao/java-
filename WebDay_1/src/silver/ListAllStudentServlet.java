package silver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDao studentDao=new StudentDao();
		List<Student> students=studentDao.getAll();
		request.setAttribute("students", students);
		request.getRequestDispatcher("/students.jsp").forward(request, response);
	}

}
