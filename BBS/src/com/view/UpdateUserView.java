package com.view;

import java.io.IOException;
import com.domain.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserView extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
//		得到用户
		User u=(User)request.getAttribute("user");
		out.println("<img src='images/Hello.jpg'/><hr/><a href='/BBS/MainFrame'>返回主界面</a>"+"   "+"<a href='/BBS/Login'>安全退出</a>");
		out.println("<h2>修改用户</h2>");
		
//		显示用户信息
		out.println("<form action='/BBS/UserClServlet?type=upd' method='post'>");
		out.println("<table border='1px' width='228' bordercolor='red' cellspacing=0>");
		out.println("<tr><td>用户ID</td><td><input readonly type='text' name='id' value='"+u.getId()+"'/></td></tr>");
		out.println("<tr><td>用户姓名</td><td><input type='text' name='username' value='"+u.getUsername()+"'/></td></tr>");
		out.println("<tr><td>电子邮箱</td><td><input type='text' name='email' value='"+u.getEmail()+"'/></td></tr>");
		out.println("<tr><td>用户等级</td><td><input type='text' name='grade' value='"+u.getGrade()+"'/></td></tr>");
		out.println("<tr><td>用户密码</td><td><input type='text' name='passwd' value='"+u.getPasswd()+"'/></td></tr>");
		out.println("</table>");
		out.println("<input type='submit' value='修改信息'/><input type='reset' value='重置信息'/>");
		out.println("</form>");
		
		out.println("<hr/><img src='images/wg.jpg'/>");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
