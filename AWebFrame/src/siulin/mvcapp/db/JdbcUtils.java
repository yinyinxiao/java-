package siulin.mvcapp.db;

import java.sql.Connection;

import javax.activation.DataSource;

/**
 * JDBC�����Ĺ�����
 * @author 
 *
 */
public class JdbcUtils {
	/**
	 * ��������Դ��һ��Connection
	 * @return
	 */
	public static Connection getConnection(){
		return null;
		//return dataSourse.getConnection();
	}
	/**
	 * Connection����
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		
	}
	
	private static DataSource dataSourse=null;
	static{
		//dataSourseDataSource=new CombopooledDataSourse("mvcapp");
	}
}
