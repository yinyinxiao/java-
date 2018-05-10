package siuyin.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;

import siulin.mvcapp.db.JdbcUtils;

/**
 * ��װ�˻�����CRUD�ķ������Թ�����̳�ʹ��
 * ��ǰDAOֱ���ڷ����л�ȡ���ݿ�����ӣ�����DBUtil�������
 * <T>:��ǰDAO�����ʵ�����������ʲô
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
	 * �÷�����װ��INSERT��DELETE��UPDATE����
	 * @param sql��sql���
	 * @param args�����sql����ռλ��
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
	 * ����T��һ��ʵ������
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
	
	/**����T����Ӧ��List
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
	 * ����ĳһ���ֶε�ֵ
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
