package com.fj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fj.JDBCUtils.JdbcUtils;
import com.fj.domain.BookType;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BookCaseDao {
	//增加
	public boolean addBookType(BookType bookType) throws SQLException{
		//创建我们的DButil的工作类
		QueryRunner qr = new QueryRunner();
		
		String sql = "INSERT INTO tb_booktype VALUES(?,?,?)";
		Object[] params = { bookType.getId(),bookType.getTypeName(),bookType.getDays()};		
		int num = qr.update(JdbcUtils.getConnection(),sql,params);
		//判断影响的数据是否为0 	如果不为0就成功
		if(num==0){
			return false;
		}
		
		return true;
	}
	//删除
	public boolean delBookCase(){
		return true;
	}
	
	//修改 
	public boolean updBookCase(int bookCaseId,int days) throws SQLException{
		QueryRunner qr = new QueryRunner();
		//写好sql语句
		String sql = "UPDATE tb_booktype SET days=days+? WHERE id=?";
		Object[] params ={days,bookCaseId};
		
		int num = qr.update(JdbcUtils.getConnection(), sql, params);
		
		//判断影响的数据是否为0 	如果不为0就成功
		if(num==0){
			return false;
		}
		
		return true;
	}
	
	//查询
	public List<BookType> getBookType() throws SQLException{
		List<BookType> list = new ArrayList<BookType>();
		QueryRunner qr = new QueryRunner();
		//查询语句
		String sql = "SELECT * FROM tb_booktype";
		//得到我们已经封装的结果集
		list = qr.query(new ComboPooledDataSource().getConnection(), sql,new BeanListHandler<BookType>(BookType.class));
		
		return list;
	}
	
}
