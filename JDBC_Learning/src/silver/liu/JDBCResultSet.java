package silver.liu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/*
 * ResultSet:结果集。封装了JDBC进行查询的结果
 * Statement对象的executeQuery(sql)可以得到结果集。
 * ResultSet返回的实际就是一张数据表，有一个指针指向数据表第一行的前面
 * 可以用next()方法检测到下一行是否有效，若有效方法返回true且指针往下移。
 * 当指针移到某一行是，可以同过调用getInt(index)或getXxx(colunmName)获取每一列的值
 * ResutSet也需要关闭
 * */
public class JDBCResultSet {
	public Connection connection() throws Exception{
		Properties properties=new Properties();
		InputStream inputStream=JDBCResultSet.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(inputStream);
		String driver=properties.getProperty("driver");
		String url=properties.getProperty("jdbcUrl");
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		Class.forName(driver);
		
		return (Connection)DriverManager.getConnection(url, user, password);
	}
	public void closeConnection(Connection connection,java.sql.Statement statement,ResultSet resultSet){
		if (resultSet!=null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
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
	@Test
	public void testResultSet(){
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=connection();
			statement=(Statement) connection.createStatement();
			String sql="SELECT* FROM students";
			
			resultSet=statement.executeQuery(sql);
			
			while (resultSet.next()) {
				String student_id=resultSet.getString(1);
				String student_name=resultSet.getString("Student_name");
				String class_id=resultSet.getString(3);
				String student_pwdString=resultSet.getString(4);
				System.out.println(student_id+student_name+student_pwdString+class_id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			closeConnection(connection, statement, resultSet);
		}
	}
}
