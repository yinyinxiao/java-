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
	 * PrepareStatement:��statement���ӽӿڣ����Դ����ռλ����SQL��䣬�����ṩ�˲���ռλ�������ķ�����
	 * */
	
	/*
	 * ͨ��select�ķ�����
	 * 1.������SQL���в�ѯ���õ������
	 * 2.���÷��䴴��ʵ����Ķ�������student����
	 * 3.��ȡ�������ı���
	 * 4.�ٻ�ȡ�������ÿһ�е�ֵ�����3�õ�һ��Map,�����е����֡�ֵ���е�ֵ
	 * 5.�����÷���Ϊ2�Ķ�Ӧ�����Ը�ֵ�����Լ�ΪMap�ļ���ֵ��ΪMap��ֵ
	 * */
	/*
	 * �������
	 * 1.������������ÿ��������ʹ���Լ����������ӣ����޷���֤���
	 * ���裺
	 * 1.���￪ʼǰ����ʼ���ȡ��Connection��Ĭ���ύ��Ϊ��connectio.setAutoCommit(false);
	 * 2.�������Ĳ����ɹ������ύ����connection.commit();
	 * 3.�ع��������������쳣������catch���лع�����
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
		System.out.println("���������FlowID:");
		student.setFlowID(scanner.nextInt());
		
		System.out.println("���������Type:");
		student.setType(scanner.nextInt());
		
		System.out.println("���������IDCard:");
		student.setIDCard(scanner.next());
		
		System.out.println("���������ExamCard:");
		student.setExamCard(scanner.next());
		
		System.out.println("���������StudentName:");
		student.setStudentName(scanner.next());
		
		System.out.println("���������Location:");
		student.setLocation(scanner.next());
		
		System.out.println("���������Grade");
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
