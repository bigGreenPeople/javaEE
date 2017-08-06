package com.fj.service;

import java.util.ArrayList;

import com.fj.domain.Users;
import com.fj.tools.SQLHelper;

public class UsersService {
	
	public Users getUsersByName(String username){
		String sql="select * from users3 where username=?";
		String[] parameters={username};
		
		ArrayList al=SQLHelper.executeQuery2(sql, parameters);
		Users user=new Users();
		
		if(al.size()>0){
			Object[] ob=(Object[]) al.get(0);
			
			user.setUsername(ob[0].toString());
			user.setPhotos(ob[1].toString());
			user.setPhotos2(ob[2].toString());
		}
		
		return user;
	}
	
	public boolean addUser(Users user){
		boolean b=true;
		
		String sql="insert into users3 values(?,?,?)";
		String[] parameters={user.getUsername(),user.getPhotos(),user.getPhotos2()};
		
		try {
			SQLHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
			e.printStackTrace();
		}
		
		
		return b;
	}
	
	public ArrayList<Users> getUserList(){
		
		String sql="select * from users3";
		ArrayList<Users> al2=null;
		
		try {
			ArrayList al=SQLHelper.executeQuery2(sql, null);
			
			al2=new ArrayList<Users>();
			
			for(int i=0;i<al.size();i++){
				Users user=new Users();
				
				Object[] ob=(Object[]) al.get(i);
				
				user.setUsername(ob[0].toString());
				user.setPhotos(ob[1].toString());
				user.setPhotos2(ob[2].toString());
				
				al2.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
		}
		
		
		return al2;
	}
}
