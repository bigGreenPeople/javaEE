package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;

public class LookUserView extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
//		js代码
		out.println("<script type='text/javascript'>");
		out.println("function look(){var e=document.getElementById('username').value; window.open('/BBS/UserClServlet?type=look&name='+e,'_self');}");
		out.println("</script>");
		//得到查询结果集合
		ArrayList<User> al=(ArrayList)request.getAttribute("al");
		

		out.println("<img src='images/Hello.jpg'/><hr/><a href='/BBS/MainFrame'>返回主界面</a>"+"   "+"<a href='/BBS/Login'>安全退出</a>");
		out.println("<h2>查找用户</h2>");
		out.println("<br/><input id='username' type='text' size='10'/><input type='button' onclick='look()' value='查找'/>");
		
		if(al!=null){
	//		显示表内容
			out.println("<table border='1px' width='600' bordercolor='red' cellspacing=0>");
			out.println("<tr><th>用户ID</th><th>用户名</th><th>电子邮箱</th><th>权限等级</th><th>用户密码</th><th>删除用户</th><th>修改用户</th></tr>");
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
		}
		out.println("<hr/><img src='images/wg.jpg'/>");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
