package com.fj.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {
	//网站访问计数
	private int userNumber;
	
	//监听器是在tomcat启动的时候创建
	public MyListener() {
		// TODO Auto-generated constructor stub
		System.out.println("监听器创建");
	}
	
	//session创建的时候触发
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		userNumber++;
		arg0.getSession().setAttribute("userNumber", userNumber);
	}
	//session关闭的时候触发
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
