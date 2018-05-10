import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



public class StudentDao {
	public List<Student> getAllStudent(){
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/school";
		String user="root";
		String password="liyin520";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			Class.forName(driver);
			connection=(Connection) DriverManager.getConnection(url, user, password);
			String sql="select* from students";
			statement=(Statement) connection.createStatement();
			resultSet=statement.executeQuery(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
