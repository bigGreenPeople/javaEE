package com.sevice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.*;
import com.domain.User;

public class UsersService {
	
//	添加用户
	public boolean addUser(User u)
	{
		boolean b=true;
		String sql="insert into users values(users_seq.nextval,?,?,?,?)";
		String [] parameters={u.getUsername(),u.getEmail(),u.getGrade()+"",u.getPasswd()};
		try {
			SQLHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
		}finally{
			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
		}
		return b;
	}
	
//	修改用户
	public boolean updUser(User u)
	{
		boolean b=true;
		String sql="update users set USERNAME=?,EMAIL=?,GRADE=?,PASSWD=? where id=?";
		String [] parameters={u.getUsername(),u.getEmail(),u.getGrade()+"",u.getPasswd(),u.getId()+""};
		try {
			SQLHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
		}finally{
			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
		}
		return b;
	}
	
//	通过id得到一个用户
	public User getUserById(String id)
	{
		User u=new User();
		String sql="select * from users where id=?";
		String[] parameters={id}; 
		ResultSet rs=SQLHelper.executeQuery(sql, parameters);
		try {
			while(rs.next())
			{
				u.setId(Integer.parseInt(rs.getString(1)));
				u.setUsername(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setGrade(Integer.parseInt(rs.getString(4)));
				u.setPasswd(rs.getString(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
		}
		return u;
	}
	
//	通过用户名字得到用户
	public ArrayList<User> getUserByNames(String name)
	{
		ArrayList<User> al=new ArrayList<User>();
		
		String sql="select * from users where USERNAME like ?";
		String[] parameters={"%"+name+"%"}; 
		ResultSet rs=SQLHelper.executeQuery(sql, parameters);
		try {
			while(rs.next())
			{
				User u=new User();
				u.setId(Integer.parseInt(rs.getString(1)));
				u.setUsername(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setGrade(Integer.parseInt(rs.getString(4)));
				u.setPasswd(rs.getString(5));
				al.add(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
		}
		return al;
	}
//	删除用户方法
	public boolean delUser(String id)
	{
		boolean b=true;
		String[] parameters={id};
		String sql="delete users where id=?";
		try {
			SQLHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
		}finally{
			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
		}
		
		return b;
	}
	
//	得到页数
	public int getPageCount(int pageSize){
		String sql="select count(*) from users";
		ResultSet rs=SQLHelper.executeQuery(sql, null);
		int count=0;
		try {
			rs.next();
			count=Integer.parseInt(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
		}
		
		return count;
	}
	
//	分页函数 这里我们的返回对象应该是ArrayList
	public ArrayList<User> getUsersByPage(int pageNow,int pageSize)
	{
		ArrayList<User> al=new ArrayList<User>();
		String sql="select * from (select t1.*,rownum rn from (select * from users order by id) t1 where rownum<="+(pageNow*pageSize)+") where rn>="+(pageSize*(pageNow-1)+1);
		
		ArrayList al2=SQLHelper.executeQuery2(sql, null);
		try {
			for(int i=0;i<al2.size();i++){
				Object[] ob=(Object[]) al2.get(i);
				User user=new User();
				
				user.setId(Integer.parseInt(ob[0].toString()));
				user.setUsername(ob[1].toString());
				user.setEmail(ob[2].toString());
				user.setGrade(Integer.parseInt(ob[3].toString()));
				user.setPasswd(ob[4].toString());
				al.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return al;
	}
	
//	检查用户密码是否正确
	public boolean checkUser(User u)
	{
		boolean b=false;
		
		String sql="select * from users where ID=? and PASSWD=?";
		String[] parameters={u.getId()+"",u.getPasswd()};
		//ResultSet rs=SQLHelper.executeQuery(sql, parameters);
		ArrayList al=SQLHelper.executeQuery2(sql, parameters);
		try {
			if(al.size()==1)
			{
				b=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//SQLHelper.close(rs, SQLHelper.getPs(),SQLHelper.getCt());
		}
		return b;
	}
}
