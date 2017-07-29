package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.util.*;
import com.domain.User;
import com.sevice.UsersService;

import java.sql.*;

public class LoginClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String code=request.getParameter("code");
		

		
		HttpSession session=request.getSession();
		//验证帐号密码
//		if("123".equals(pass))
//		{
//			response.sendRedirect("/MyWeb/MainFrame?name="+user);
//		}else{
//			response.sendRedirect("/MyWeb/Login");
//		}
//		连接数据库
		UsersService us=new UsersService();
		User u=new User();
		if(code.equals(session.getAttribute("checkcode")))
		{
			if(user!="")
			{
				u.setId(Integer.parseInt(user));
			}
			u.setPasswd(pass);
				if(us.checkUser(u))
				{
					//System.out.println(rs.getString("id")+rs.getString("passwd"));
//					创建session
					HttpSession session1=request.getSession();
					session1.setAttribute("userId", user);
					
//					得到登入次数
					String num=(String) this.getServletContext().getAttribute("num");
//					登入次数加一
					this.getServletContext().setAttribute("num",(Integer.parseInt(num)+1)+"");
					
					response.sendRedirect("/BBS/MainFrame");
							
					Cookie cookie=new Cookie("lasttime", "");
				}else{
					request.setAttribute("err", "你输入的账号和密码错误！");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
		}else{
			request.setAttribute("err", "验证码错误！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
	}


	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doGet(request, response);
	}

}
