package com.fj.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourceServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		//getResourceAsStream是用于返回this.getServletContext()(也就是当前web应用的路径)
//		路径的下的222.txt文件
		//InputStream resourceAsStream = this.getServletContext().getResourceAsStream("222.txt");
		
		//如果是在src目录下我们应该这样去获得它
		//先去获得当前类的类加载器  在从类加载器的路径下去找111.txt
		InputStream resourceAsStream = ResourceServlet.class.getClassLoader().getResourceAsStream("111.txt");
		
		//获得一个web文件的全路径
		String path = this.getServletContext().getRealPath("222.txt");
		System.out.println("全路径:"+path);
		
		//byte数组来接受
		byte[] buf = new byte[1024];
		resourceAsStream.read(buf);
		System.out.println(new String(buf));
		System.out.println("读取成功");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
