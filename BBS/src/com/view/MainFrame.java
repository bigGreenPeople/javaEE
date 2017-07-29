package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.User;
import com.sevice.UsersService;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		
//		得到登入次数
		String num=(String) this.getServletContext().getAttribute("num");
		
//		检查用户是否通过了登陆处理器
		HttpSession session = request.getSession();
		String userId=(String)session.getAttribute("userId");
		if(userId==null){
			request.setAttribute("err", "请输入账号密码！");
			request.getRequestDispatcher("/Web-INF/admin/Login.jsp").forward(request, response);
			return;
		}
		
//		下面的代码是对cookie的操作
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String val=request.getParameter("iskeepinfo");
		

//		用户勾选了保存 我们去创建cookie
		if(val!=null&&val.equals("keep")){
			Cookie cookie=new Cookie("id", user);
			cookie.setMaxAge(3600*24);
			response.addCookie(cookie);		
		}else{
			Cookie cookie=new Cookie("id", user);
			cookie.setMaxAge(0);
			response.addCookie(cookie);	
		}
		
//		这里得到我们的cookie
		Cookie[] cookies=request.getCookies();
		String lastTime="";
//		是否查找到lastTime
		boolean b=false;
		
		if(cookies!=null)
		{
			for(Cookie cookie:cookies)
			{
				if("lastTime".equals(cookie.getName())){
					lastTime=cookie.getValue();
//					得到转化类
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					得到时间
					String nowTime=simpleDateFormat.format(new Date());
					cookie=new Cookie("lastTime", nowTime);
//					设置生命周期
					cookie.setMaxAge(3600*24);
//					添加到http响应中
					response.addCookie(cookie);
					//System.out.println(lastTime);
					b=true;
				}
			}
		}
		if(!b)
		{
//			得到转化类
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			得到时间
			String nowTime=simpleDateFormat.format(new Date());
			Cookie cookie=new Cookie("lastTime", nowTime);
//			设置生命周期
			cookie.setMaxAge(3600*24);
//			添加到http响应中
			response.addCookie(cookie);
		}
		
//		得到登陆的用户
		User u=new UsersService().getUserById(userId);
		
		out.println("<img src='images/Hello.jpg'/><hr/>");
		out.println("<h1>欢迎&nbsp;"+u.getUsername()+"&nbsp;登陆</h1>");
		if(b){
			out.println("你上次登陆的时间是："+lastTime);
		}else{
			out.println("欢迎你首次登陆！");
		}
		out.println("本网站被浏览了"+num+"次");
		out.println("<a href=\"/BBS/index.jsp\">返回登陆界面</a></br>");
		out.println("<h1>请选择你要进行的操作</h1>");
		out.println("<a href=\"/BBS/ManageUsers\">管理用户</a></br>");
		out.println("<a href=\"/BBS/AdddateUser\">添加用户</a></br>");
		out.println("<a href=\"/BBS/LookUserView\">查找用户</a></br>");
		out.println("<a href=\"/BBS/index.jsp\">退出系统</a></br>");
		out.println("<hr/><img src='images/wg.jpg'/>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}
