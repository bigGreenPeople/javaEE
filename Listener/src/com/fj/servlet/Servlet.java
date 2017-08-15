package com.fj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fj.pojo.User;

public class Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
//		System.out.println("访问到action");
//		Integer num = (Integer) request.getSession().getAttribute("userNumber");
//		System.out.println("用户访问数:"+num+"\n");
		
//		System.out.println("servlet向session添加属性");
//		request.getSession().setAttribute("name", "付杰");
//		
//		System.out.println("servlet修改session属性");
//		request.getSession().setAttribute("name", "fujie");
//		
//		System.out.println("servlet删除session属性");
//		request.getSession().removeAttribute("name");

		User user = new User();
		
		System.out.println("servlet向session添加属性");
		request.getSession().setAttribute("user", user);
		
//		request.getSession()
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
