package com.fj.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.bos.domain.User;

/**
 * 此工具类用于获取登录的用户和session
 * @author bigGreenPeople
 *
 */
public class BOSUtils {
	//获取session
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	//获取登录的用户
	public static User getLoginUser(){
		return (User) getSession().getAttribute("loginUser");
	}
}
