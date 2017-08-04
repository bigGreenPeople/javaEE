package com.jdbcodbc;
import java.sql.*;
public class Test_1 {

	static Connection ct = null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			ct = DriverManager.getConnection("jdbc:odbc:OrclJdbc","scott","2681660542");
			ps=ct.prepareStatement("select * from emp");
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString("empno")+"    "+rs.getString("ename"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
