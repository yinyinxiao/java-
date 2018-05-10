package silver.liu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sound.midi.MidiDevice.Info;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class JDBCtEST {
	/*Driver ��һ���ӿ�:���ݳ��̱����ṩʵ�ֵĽӿڣ��ܴ����л�����ݿ������
	 * 
	 *
	 * 
	 * */
	//@Test
	public void testDriver() throws SQLException{
	
		Driver driver=new com.mysql.jdbc.Driver();
		/*jdbc url����������ɡ������ּ���ð�Ÿ���
		 * jdbc:<֮Э��>:<������>
		 * Э�飺JDBC URL �е�Э������jdbc
		 * ��Э�飺֮Э�����ڱ�ʾһ�����ݿ���������
		 * �����ƣ�һ�ֱ�ʶ���ݿ�ķ����������ƿ�������ͬ����Э����仯���������Ƶ�Ŀ����Ϊ�˶�λ���ݿ��ṩ�㹻����Ϣ
		 * */
		String url="jdbc:mysql://127.0.0.1:3306/test";
		Properties info=new Properties();
		info.put("user", "root");
		info.put("password", "liuyin520");
		Connection connection=(Connection) driver.connect(url, info);
		System.out.println(connection);
		
	}
	public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException{
		String driverClass=null;
		String jdbcUrl=null;
		String user=null;
		String password=null;
		
		InputStream in=
				getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties=new Properties();
		properties.load(in);
		
		driverClass=properties.getProperty("driver");
		jdbcUrl=properties.getProperty("jdbcUrl");
		user =properties.getProperty("user");
		password=properties.getProperty("password");
		Properties info=new Properties();
		info.put("user", user);
		info.put("password", password);
	
		
		Driver driver=(Driver) Class.forName(driverClass).newInstance();
		
		Connection connection=(Connection) driver.connect(jdbcUrl,info);
		
		return connection;
	}
	
	public void testGetConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException{
		System.out.println(getConnection());
	}
	
	/*DriverManager �������Ĺ�����
	 * 
	 * ����ͨ�����ص�getConnection()����������ݿ�����ӣ���Ϊ����
	 * 
	 * ����ͬʱ��������������
	 * */
	
	public void testDriverManager() throws Exception{

		String driverClass=null;
		String jdbcUrl=null;
		String user=null;
		String password=null;
		
		InputStream in=
				getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties=new Properties();
		properties.load(in);
		
		driverClass=properties.getProperty("driver");
		jdbcUrl=properties.getProperty("jdbcUrl");
		user =properties.getProperty("user");
		password=properties.getProperty("password");
		
		//�������ݿ���������
		Class.forName(driverClass);
		Connection connection=(Connection) DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(connection);
	}

	public Connection testGetDriverManager() throws Exception{

		Properties properties=new Properties();
		
		InputStream in=this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		
		
		properties.load(in);
		
		String driverClass=properties.getProperty("driver");
		String jdbcUrl=properties.getProperty("jdbcUrl");
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		
		Class.forName(driverClass);
		
		Connection connection=(Connection) DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}
	public static void main(String[] args) throws Exception{
		JDBCtEST tEst=new JDBCtEST();
		System.out.println(tEst.testGetDriverManager());
	}
}

