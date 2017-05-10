package utils;



import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//初始化连接池
	private static DataSource dataSource;
	static{
		dataSource=new ComboPooledDataSource();
	}
	
	/**
	 * 获取连接池
	 * @return
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	/**
	 * 获取常用工具类
	 * @return
	 */
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(dataSource);
	}
}
