package com.fj.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//创建一个连接池
	public static ComboPooledDataSource cds = new ComboPooledDataSource(); 
	//事务的连接
	//public static Connection ct = null;
	//将其改成线程安全的
	public static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	//得到一个连接
	public static Connection getConnection() throws SQLException{
		//如果发现事务处理
		
		Connection ct = threadLocal.get();
		if(ct!=null) return ct;		
		else return cds.getConnection();
	}
	//得到一个数据源
	public static ComboPooledDataSource getCds() {
		return cds;
	}
	
	//开启事务
	public static void beginTransaction() throws SQLException{
		//得到thread里面的连接
		Connection ct = threadLocal.get();
		//判断事务是否开启
		if(ct!=null) throw new RuntimeException("错误!事务已开启 ");
		ct = getConnection();
		ct.setAutoCommit(false);
		
		//将连接放入
		threadLocal.set(ct);
	}
	
	
	//提交事务
	public static void commitTransaction() throws SQLException{
		//得到thread里面的连接
		Connection ct = threadLocal.get();
		
		//判断事务是否开启
		if(ct==null) throw new RuntimeException("错误!事务未开启 ");
		ct.commit();
		ct.close();
		//将threadLocal里面的连接移除
		threadLocal.remove();
	}
		
	//回滚事务
	public static void rollbackTransaction() throws SQLException{
		//得到thread里面的连接
		Connection ct = threadLocal.get();
		//判断事务是否开启
		if(ct==null) throw new RuntimeException("错误!事务未开启 ");
		ct.rollback();
		ct.close();
		//将threadLocal里面的连接移除
		threadLocal.remove();
	}
	
	//用于释放连接	
	public static void releaseConnection(Connection connection) throws SQLException{
		//如果是事务的话就不释放 如果不是就释放
		//得到thread里面的连接
		Connection ct = threadLocal.get();
		
		//如果ct不为null说明有事务
		if(ct==null){
			connection.close();
		}
		//ct不为null时我们应该去判断这两个连接是不是同一个连接 
		//如果是说明这个要释放的连接是事务的连接就不去释放它
		if(ct != connection){
			connection.close();
		}
	}
}
