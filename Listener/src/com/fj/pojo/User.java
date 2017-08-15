package com.fj.pojo;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener,Serializable,HttpSessionActivationListener{
	
	private String username;
	private String password;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	//对象活化调用//被设置到session中（setAttribute）
	@Override
	public void valueBound(HttpSessionBindingEvent hsbe) {
		// TODO Auto-generated method stub
		System.out.println("valueBound name: "+hsbe.getName());
	}
	//对象钝化调用	从session中解除（removeAttribute） 
	@Override
	public void valueUnbound(HttpSessionBindingEvent hsbe) {
		// TODO Auto-generated method stub
		 System.out.println("valueUnbound name: "+hsbe.getName());
	}


	//激活
	@Override
	public void sessionDidActivate(HttpSessionEvent hsbe) {
		// TODO Auto-generated method stub
		 System.out.println("sessionDidActivate name: "+hsbe.getSource());
	}


	//被传送到别的jvm或 写到硬盘
	@Override
	public void sessionWillPassivate(HttpSessionEvent hsbe) {
		// TODO Auto-generated method stub
        System.out.println("sessionWillPassivate name: "+hsbe.getSource());
	}

}
