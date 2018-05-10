package silver.liu;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCtEST_2 {
	public Connection testConnection() throws Exception{
		Properties properties=new Properties();
		InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(inputStream);
		Connection connection=null;
		String driver=null;
		String url=null;
		String password=null;
		String user=null;
		String sql=null;
		//sql="Insert into students (Student_id,Student_name,Class_id,Student_pwd) values ('123','liuyin','rrr','234')";
		sql="update students set Student_name='xiaoyinyin' where Student_id='123'";	
		driver=properties.getProperty("driver");
			 url=properties.getProperty("jdbcUrl");
			 password=properties.getProperty("password");
			 user=properties.getProperty("user");
			
			Class.forName(driver);
			connection=(Connection)DriverManager.getConnection(url, user, password);
		Statement statement=(Statement) connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
		return connection;
	}
	public static void main(String[] args) throws Exception{
		System.out.println("333");
		JDBCtEST_2 jdbCtEST_2=new JDBCtEST_2();
		System.out.println(jdbCtEST_2.testConnection());
	}
}

