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
	/*Driver 是一个接口:数据厂商必须提供实现的接口，能从其中获得数据库的连接
	 * 
	 *
	 * 
	 * */
	//@Test
	public void testDriver() throws SQLException{
	
		Driver driver=new com.mysql.jdbc.Driver();
		/*jdbc url由三部分组成。各部分间用冒号隔开
		 * jdbc:<之协议>:<子名称>
		 * 协议：JDBC URL 中的协议总是jdbc
		 * 子协议：之协议用于表示一个数据库驱动程序
		 * 子名称：一种标识数据库的方法。子名称可以依不同的子协议而变化，用子名称的目的是为了定位数据库提供足够的信息
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
	
	/*DriverManager 是驱动的管理类
	 * 
	 * 可以通过重载的getConnection()方法获得数据库的连接，较为方便
	 * 
	 * 可以同时管理多个驱动程序
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
		
		//加载数据库驱动程序
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

