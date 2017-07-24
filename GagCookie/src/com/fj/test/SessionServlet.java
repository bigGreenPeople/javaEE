package com.fj.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		//得到session
		HttpSession session = request.getSession();
		//往session里面放入值
		session.setAttribute("name", "付杰");
		
		//编码后跳转	在禁用cookie后依然能够使用session的值
		//编码的实质是在后面加上JSESSIONID=...这样cookie被禁了也可以取得JSESSIONID了
		//encodeURL()是本应用级别的，encodeRedirectURL()是跨应用的
		String url = response.encodeRedirectURL("/GagCookie/GetSession");
		response.sendRedirect(url);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
