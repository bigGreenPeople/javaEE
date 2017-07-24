package com.fj.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fj.DAO.EmpDao;
import com.fj.domain.Emp;

public class Paging extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//创建DAO 
		//select * (select t.*,coum l (select * from emp) t where l>=6) where t.l<=1;
		EmpDao empDao = new EmpDao();
		
		//分页信息
		int pageNow = 1;
		String pageNowStr = request.getParameter("pageNow");
		//设置pageNow
		if( pageNowStr!=null ){
			pageNow = Integer.parseInt(pageNowStr);
		}
		
		//每页3条记录
		int pageSize = 3;
		//System.out.println(pageNowStr);
		
		
		//计算出页数
		int pageCount=14% pageSize==0 ? 14/pageSize: 14/pageSize+1;
		
		
		
		//得到分页的记录
		List<Emp> list = empDao.showEmpByPage(pageNow, pageSize);
		System.out.println(list.size()); 
		
		//将jsp要用到的信息设置到request
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/page.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
