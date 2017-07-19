package com.fj.demo;

import com.fj.data.*;
/*
 * 此类是一个Customer的管理类
 * 有点类似web开发的service类
 * */

public class ManagerService {
	//登录验证
	public boolean checkAdmin(String pass){
		boolean b = false;
		
		//如果相等密码正确
		if(pass.equals(Data.manager.password)){
			b = true;
		}
		
		//如果失败增加登录失败次数
		if(!b){
			Manager.loginNum++;
		}
		
		Menu.nextMenu();
		return b;
	}
	
	//修改管理员密码s
	public void updPass(String newPass){
		
		Data.manager.password = newPass;
	}
}
