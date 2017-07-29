package com.util;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet {


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
//		得到文件的全路径
		FileWriter fileWriter=null;
		BufferedWriter bufferedWriter=null;
		String path=this.getServletContext().getRealPath("record.txt");
		try {
			fileWriter=new FileWriter(path); 
			bufferedWriter=new BufferedWriter(fileWriter);
			
			String num=(String) this.getServletContext().getAttribute("num");
			bufferedWriter.write(num);
			System.out.println("你保存的路径是："+path);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
//		得到文件的全路径
		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		String path=this.getServletContext().getRealPath("record.txt");
		try {
			fileReader=new FileReader(path); 
			bufferedReader=new BufferedReader(fileReader);
			
			String num=bufferedReader.readLine();
			this.getServletContext().setAttribute("num", num);
			System.out.println("你读取的路径是："+path);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
