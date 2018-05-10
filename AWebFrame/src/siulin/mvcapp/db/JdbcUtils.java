package siulin.mvcapp.db;

import java.sql.Connection;

import javax.activation.DataSource;

/**
 * JDBC操作的工具类
 * @author 
 *
 */
public class JdbcUtils {
	/**
	 * 返回数据源的一个Connection
	 * @return
	 */
	public static Connection getConnection(){
		return null;
		//return dataSourse.getConnection();
	}
	/**
	 * Connection连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		
	}
	
	private static DataSource dataSourse=null;
	static{
		//dataSourseDataSource=new CombopooledDataSourse("mvcapp");
	}
}
