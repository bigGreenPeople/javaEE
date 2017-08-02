package com.fj.struts2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 当子类接受到请求时都会来调用service方法
 * 此类用于接受到用户要调用的方法
 * 然后利用反射去调用这个方法
 * 在接受到要返回的跳转信息
 * 处理之
 * @author BigGreenPeople
 *
 */
public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//得到网页传来的method参数 来决定调用哪个
		String  method = req.getParameter("method");
		System.out.println(method);
		//得到此类对象
		Class clazz =  this.getClass();
		Method met = null;
		
		try {
			//得到我们的方法对象
			//这里我们不能写req.getClass()和resp.getClass()		
			met = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("无此方法!");
		}
		String result="";
		//调用之
		try {
			//得到我们的返回值	
			result = (String) met.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("方法调用时出错!");
		}
		
		//根据返回值决定怎么跳转
		//我们来给他一个规定
		//f:xxx.jsp	这个为forword
		//r:xxxjsp	这个为重定向
		//xxx.jsp 这个默认为forword
		
		//判断result有没有对象 如果为null的话我们什么都不做
		if(result!=null && !result.equals("")){
			//判断返回值有没：
			if(result.contains(":")){
				//得到：的位置
				int index = result.indexOf(":");
				//截取出前缀
				String s = result.substring(0,index);
				//截取要跳转的界面 
				String path = result.substring(index+1);
				
				//判断它如何跳转
				if(s.equals("r")){
					//重定向
					resp.sendRedirect(req.getContextPath()+path);
				}else if(s.equals("f")){
					//forword	跳转
					req.getRequestDispatcher(path).forward(req, resp);
				}
			}else{
				//默认forword	跳转
				req.getRequestDispatcher(result).forward(req, resp);
			}
		}

	}
}
