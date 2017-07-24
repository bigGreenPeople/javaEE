package com.fj.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fj.MD5.MD5;

public class CreateCookie extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		//md5加密
		//如果cookie要存放中文的时候使用URLEncoder编码    然后取值的时候URLDecoder解码就OK了
		//Cookie cookie = new Cookie("username", MD5.MD5("fujie"));
		//创建当前时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = simpleDateFormat.format(new Date());
		System.out.println(time);
		
		//设置一个标志如果第一次登入就不存在cookie
		boolean b=true;
		//取出cookie
		Cookie[] cookies = request.getCookies();
		//查找我们的lasttime
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("lastTime")){
					//打印出我们最后登入的时间
					pw.println(c.getValue());
					b = false;
				}
			}
		}
		if(b){
			pw.print("你是第一次登入 ");
		}
		
		Cookie cookie = new Cookie("lastTime", time);
		cookie.setMaxAge(3000);
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
