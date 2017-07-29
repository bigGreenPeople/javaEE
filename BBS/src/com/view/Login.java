package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");

		String userId="";
//		操作cookie如果用户保存过账号就显示账号
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("id")){
					userId=cookie.getValue();
					//System.out.println(userId);
				}
			}
		}
		
		out.println("<h1>登入界面</h1>");
		out.println("<form action='/BBS/LoginClServlet' method='post'>");
		out.println("用户ID：<input type=\"text\" name=\"user\" size=\"10\" value='"+userId+"'/></br>");
		out.println("密　码：<input type=\"password\" name=\"pass\" size=\"10\"/></br>");
		out.println("验证码：<input type=\"text\" name=\"code\" size=\"8\" /><br/><img src='/BBS/CreateCode'/></br>");
		out.println("<input type='checkbox' name='iskeepinfo' value='keep'/><font size=2>是否保存账号</font></br>");
		out.println("<input type='submit' value='登陆'/>");
		out.println("</form>");
		String err=(String)request.getAttribute("err");
		if(err!=null)
		{
			out.println("<font color=\"red\">"+err+"</font>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
