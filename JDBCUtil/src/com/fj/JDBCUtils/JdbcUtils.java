package com.fj.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//创建一个连接池
	public static ComboPooledDataSource cds = new ComboPooledDataSource(); 
	//事务的连接
	public static Connection ct = null;
	
	//得到一个连接
	public static Connection getConnection() throws SQLException{
		//如果发现事务处理
		if(ct!=null) return ct;		
		return cds.getConnection();
	}
	//得到一个数据源
	public static ComboPooledDataSource getCds() {
		return cds;
	}
	
	//开启事务
	public static void beginTransaction() throws SQLException{
		//判断事务是否开启
		if(ct!=null) throw new RuntimeException("错误!事务已开启 ");
		ct = getConnection();
		ct.setAutoCommit(false);
	}
	
	
	//提交事务
	public static void commitTransaction() throws SQLException{
		//判断事务是否开启
		if(ct==null) throw new RuntimeException("错误!事务未开启 ");
		ct.commit();
		ct = null;
	}
		
	//回滚事务
	public static void rollbackTransaction() throws SQLException{
		//判断事务是否开启
		if(ct==null) throw new RuntimeException("错误!事务未开启 ");
		ct.rollback();
		ct = null;
	}
}
