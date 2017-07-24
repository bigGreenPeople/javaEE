package com.fj.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fj.domain.Emp;
import com.mysql.jdbc.Driver;

public class EmpDao {
	public static Connection ct=null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","1243596620");
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	public List<Emp> showEmpByPage(int pageNow,int pageSize){
		List<Emp> list = new ArrayList<Emp>();
		//这里计算出你要看的页数是第几条到第几条
		int start = (pageNow-1)*pageSize;
		//int end = start + pageSize;
		
		try {
			ps = ct.prepareStatement("select * from emp limit "+start+","+pageSize);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getDate(5));
				emp.setSal(rs.getDouble(6));
				emp.setComm(rs.getDouble(7));
				emp.setDeptno(rs.getInt(8));
				
				list.add(emp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
//				if(ct!=null){
//					ct.close();
//				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return list;
	}
}
