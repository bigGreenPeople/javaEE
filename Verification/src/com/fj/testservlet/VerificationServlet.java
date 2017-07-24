package com.fj.testservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerificationServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//得到用户输入的验证码
		String code = request.getParameter("code");
		//得到存放在session的验证码
		String relCode = (String) request.getSession().getAttribute("CHECKNUM");
//		System.out.println("session:"+relCode);
//		System.out.println("接受的:"+code);
		//验证码是否一致
		if(relCode.equals(code)){
			request.getRequestDispatcher("/ok.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/Verification.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
