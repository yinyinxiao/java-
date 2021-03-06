package silver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;


public class StudentDao {
	List<Student> students;
	public List<Student> getAll(){
		Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			String driverClass="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/school";
			String userString="root";
			String password="liuyin520";
			Class.forName(driverClass);
			connection=DriverManager.getConnection(url, userString, password);
			String sqlString="SELECT* FROM students";
			System.out.println("111");
			preparedStatement=(PreparedStatement) connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				String Student_id=resultSet.getString("Student_id");
				String Student_Name=resultSet.getString("Student_name");
				String Class_idString=resultSet.getString("Class_id");
				String student_pwd=resultSet.getString("Student_pwd");
				Student student=new Student(Student_id,Student_Name,Class_idString,student_pwd);
				students.add(student);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(resultSet!=null){
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(preparedStatement!=null){
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(connection!=null){
					connection.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
}
