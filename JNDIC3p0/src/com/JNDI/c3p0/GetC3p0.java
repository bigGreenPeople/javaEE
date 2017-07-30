package com.JNDI.c3p0;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * 在JNDI中配置c3p0的属性
 * @author Administrator
 *
 */
public class GetC3p0 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Context cxt = new InitialContext();
			Context cc = (Context)cxt.lookup("java:comp/env");
			//取得我们的数据源
			DataSource dataSource = (DataSource) cc.lookup("bean/fujie");
			
			
			//得到连接池的连接
			Connection con = dataSource.getConnection();
			System.out.println("con = "+con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
