package silver.liu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/*
 * Statement:����ִ��sql���Ķ���
 * ͨ��Connection��createStatement()������ȡ
 * ͨ��executeUpdate(sql)����ִ��SQL���
 * �����sql��������insert��update��delete,����������select���
 * 
 * Connection,statement����Ӧ�ó�������ݿ���������ӵ���Դ��ʹ�ú�һ��Ҫ�ر�
 * ��Ҫ��finally�йر�
 * �ȱ�statement���ٹر�connection
 * */
public class JDBCTest_3 {
	public Connection connection() throws Exception{
		Properties properties=new Properties();
		InputStream inputStream=getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(inputStream);
		
		String driverString=properties.getProperty("driver");
		String urlString=properties.getProperty("jdbcUrl");
		String userString=properties.getProperty("user");
		String password=properties.getProperty("password");
		
		Class.forName(driverString);	
		return (Connection)DriverManager.getConnection(urlString, userString, password);
	}
	public void closeConnection(Connection connection,java.sql.Statement statement){
		if (statement!=null) {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		if (connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//insert,updata,delete��䶼����ʹ�õķ���
	public void myExecuteUpdate(String sql){
		Connection connection=null;
		java.sql.Statement statement=null;
		try {
			connection=connection();
			statement=connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			closeConnection(connection, statement);
		}
	}
	public static void main(String[] args) throws Exception{
		String sqlString="insert into students (Student_id,Student_name,Class_id,Student_pwd) values('3599','zh','555','990')";
		JDBCTest_3 jdbcTest_3=new JDBCTest_3();
		jdbcTest_3.myExecuteUpdate(sqlString);
	}
}
