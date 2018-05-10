package silver.liu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Work_1 {
	public static void main(String[] args){
		Work_1 work_1=new Work_1();
		String sqlString=work_1.getInsertSql();
		work_1.myExecute(sqlString);
	}
	/*
	 * PrepareStatement:是statement的子接口，可以传入带占位符的SQL语句，并且提供了补充占位符变量的方法。
	 * */
	
	/*
	 * 通用select的方法：
	 * 1.先利用SQL进行查询，得到结果集
	 * 2.利用反射创建实体类的对象，例如student对象
	 * 3.获取结果集类的别名
	 * 4.再获取结果集的每一列的值，结合3得到一个Map,键：列的名字。值：列的值
	 * 5.再利用反射为2的对应的属性赋值，属性即为Map的键，值即为Map的值
	 * */
	/*
	 * 关于事物：
	 * 1.如果多个操作，每个操作都使用自己单独的连接，则无法保证事物。
	 * 步骤：
	 * 1.事物开始前，开始事物：取消Connection的默认提交行为，connectio.setAutoCommit(false);
	 * 2.如果事物的操作成功，则提交事务：connection.commit();
	 * 3.回滚事务：若出出现异常，则在catch块中回滚事务：
	 * */
	@Test
	public void prepareStatementTest(){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=getConnection();
			String sqlString="INSERT INTO examstudent(FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, 888);
			preparedStatement.setInt(2, 2323);
			preparedStatement.setString(3, "23323");
			preparedStatement.setString(4, "23323");
			preparedStatement.setString(5, "23323");
			preparedStatement.setString(6, "23323");
			preparedStatement.setInt(7, 2323);
			preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			closeConnection(connection, (Statement)preparedStatement);
		}
	}
	
	public String getInsertSql(){
		Student student=getStudent();
		String sql=null;
		sql="insert into examstudent(FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade) values("+student.getFlowID()+","+student.getType()
				+",'"+student.getIDCard()+"','"+student.getExamCard()+"','"+student.getStudentName()+"','"+student.getLocation()+"',"+student.getGrade()+")";
		return sql;
	}
	public Student getStudent(){
		Scanner scanner=new Scanner(System.in);
		Student student=new Student();
		System.out.println("请输入你的FlowID:");
		student.setFlowID(scanner.nextInt());
		
		System.out.println("请输入你的Type:");
		student.setType(scanner.nextInt());
		
		System.out.println("请输入你的IDCard:");
		student.setIDCard(scanner.next());
		
		System.out.println("请输入你的ExamCard:");
		student.setExamCard(scanner.next());
		
		System.out.println("请输入你的StudentName:");
		student.setStudentName(scanner.next());
		
		System.out.println("请输入你的Location:");
		student.setLocation(scanner.next());
		
		System.out.println("请输入你的Grade");
		student.setGrade(scanner.nextInt());
		return student;
	}
	public Connection getConnection() throws Exception{
		Properties properties=new Properties();
		InputStream inputStream=Work_1.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(inputStream);
		
		String driver=properties.getProperty("driver");
		String url=properties.getProperty("jdbcUrl");
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		
		Class.forName(driver);
		return (Connection)DriverManager.getConnection(url, user, password);
	}
	public void closeConnection(Connection connection,Statement statement){
		
		if (statement!=null) {
			try {
				statement.close();
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public void closeConnection(Connection connection,Statement statement,ResultSet resultSet){
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
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	//update,delete,insert
	public void myExecute(String sql){
		Connection connection=null;
		Statement statement=null;
		try {
			connection=getConnection();
			statement=(Statement) connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			closeConnection(connection, statement);
		}
	}
}
