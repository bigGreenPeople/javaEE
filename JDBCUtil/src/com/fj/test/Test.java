package com.fj.test;

import java.sql.SQLException;
import java.util.List;

import com.fj.JDBCUtils.JdbcUtils;
import com.fj.dao.BookCaseDao;
import com.fj.domain.BookType;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试添加是否成功
		BookCaseDao bookCaseDao = new BookCaseDao();
		/*
		BookType bookType = new BookType(9, "xxx类", 20);
		
		try {
			boolean b = bookCaseDao.addBookType(bookType);
			System.out.println(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//测试查询是否成功
	/*	List<BookType> list;
		try {
			list = bookCaseDao.getBookType();
			for(BookType bookType:list){
				System.out.println(bookType.getTypeName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//测试我们的事务是否成功
		
		
		try {
			//开启事务
			JdbcUtils.beginTransaction();
			//对数据进行操作
			bookCaseDao.updBookCase(2, 10);
			int i = 2/0;
			bookCaseDao.updBookCase(3, -20);
			//提交事务
			JdbcUtils.commitTransaction();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//回滚事务
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
