package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.sevice.UsersService;

public class ManageUsers extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		这里是我们的js代码
		out.println("<script type='text/javascript'>");
		out.println("function jmp(){var e=document.getElementById('pageNow').value; window.open('/BBS/ManageUsers?page='+e,'_self');}");
		out.println("function confirmOper(){return window.confirm('确认删除该用户');}");
		out.println("</script>");
		
		int pageNow=1;//当前页
		String tempPageNow=request.getParameter("page");
		if(tempPageNow!=null)
		{
			pageNow=Integer.parseInt(tempPageNow);
		}
		int pageSize=3;//指定每页显示3条记录
		int pageCount=1;//页数的总数
		int rowCount=1;//记录的总数
		
			
//			创建一个User服务类
			UsersService us=new UsersService();
//			得到需要的数据
			ArrayList<User> al=us.getUsersByPage(pageNow, pageSize);
			
//			显示页面
			out.println("<img src='images/Hello.jpg'/><hr/>欢迎XX登陆   <a href='/BBS/MainFrame'>返回主界面</a>"+"   "+"<a href='/BBS/Login'>安全退出</a>");
			out.println("<h2>管理用户</h2>");
//			显示表内容
			out.println("<table border='1px' width='600' bordercolor='red' cellspacing=0>");
			out.println("<tr><th>用户ID</th><th>用户名</th><th>电子邮箱</th><th>权限等级</th><th>用户密码</th><th>删除用户</th><th>修改用户</th></tr>");
//			显示分页的数据
			for(User u:al)
			{
				out.println("<tr>"
						+ "<td>"+u.getId()+"</td>"
						+ "<td>"+u.getUsername()+"</td>"
						+ "<td>"+u.getEmail()+"</td>"
						+ "<td>"+u.getGrade()+"</td>"
						+ "<td>"+u.getPasswd()+"</td>"
						+ "<td><a onclick='return confirmOper()' href='/BBS/UserClServlet?type=del&id="+u.getId()+"'>删除用户</a></td>"
						+ "<td><a href='/BBS/UserClServlet?type=gotoUpdView&id="+u.getId()+"'>修改用户</a></td>"
						+"</tr>");
			}
			
			out.println("</table>");
			
//			得到总记录数
			rowCount=us.getPageCount(pageSize);
//			计算出页数 
			pageCount=((rowCount%pageSize)==0)?rowCount/pageSize:(rowCount/pageSize)+1;
//			显示上一页标签
			if(pageNow!=1)
			{
				out.println("<a href='/BBS/ManageUsers?page="+(pageNow-1)+"'>上一页</a>");
			}
//			显示页数
			for(int i=1;i<=pageCount;i++)
			{
				out.println("<a href='/BBS/ManageUsers?page="+i+"'><"+i+"></a>");
			}
//			显示下一页标签			
			if(pageNow!=pageCount)
			{
				out.println("<a href='/BBS/ManageUsers?page="+(pageNow+1)+"'>下一页</a>");
			}
			out.println("  &nbsp;&nbsp;  当前页:"+pageNow+"/总页数:"+pageCount);
			out.println("<br/><input id='pageNow' type='text' size='10'/><input type='button' onclick='jmp()' value='跳转'/>");
			out.println("<hr/><img src='images/wg.jpg'/>");
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
