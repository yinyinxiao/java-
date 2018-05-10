package siuyin.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;

import siulin.mvcapp.db.JdbcUtils;

/**
 * 封装了基本的CRUD的方法，以供子类继承使用
 * 当前DAO直接在方法中获取数据库的连接，采用DBUtil解决方案
 * <T>:当前DAO处理的实体类的类型是什么
 * */
public class Dao<T> {
	//private QueryRunner queryRunner=new QueryRunner();
	private Class<T> clazz;
	public Dao(){
		java.lang.reflect.Type superClass=getClass().getGenericSuperclass();
		if (superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType=(ParameterizedType) superClass;
			
			java.lang.reflect.Type[] typesArgs=parameterizedType.getActualTypeArguments();
			if (typesArgs!=null&& typesArgs.length>=0) {
				if (typesArgs[0] instanceof Class) {
					clazz=(Class<T>) typesArgs[0];
					
				}
			}
					
		}
	}
	/**
	 * 该方法封装了INSERT、DELETE、UPDATE操作
	 * @param sql：sql语句
	 * @param args：填充sql语句的占位符
	 */
	public void update(String sql,Object...args){
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			/**
			 * queryRunner.update(connection,sql,args);
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		
	}
	/**
	 * 返回T的一个实例对象
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 */
	public T get(String sql,Object...args){
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			/**
			 * queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/**返回T所对应的List
	 * 
	 */
	public List<T> getForList(String sql,Object...args){
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			/**
			 * queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	/**
	 * 返回某一个字段的值
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E>E getForValue(String sql,Object...args){
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			/**
			 * queryRunner.query(connection,sql,new ScalarHandler(),args);
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
}
