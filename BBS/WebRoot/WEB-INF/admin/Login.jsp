<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%
		String userId="";
//		操作cookie如果用户保存过账号就显示账号
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("id")){
					userId=cookie.getValue();
					//System.out.println(userId);
				}
			}
		}
		
		String err=(String)request.getAttribute("err");
	 %>
  </head>
  
  <body>
    <h1>登入界面</h1>
	    <form action='/BBS/LoginClServlet' method='post'>
	         用户ID：<input type="text" name="user" size="10" value='<%=userId %>'/><br/>
	   	  密　码：<input type="password" name="pass" size="10"/><br/>
	   	  验证码：<input type="text" name="code" size="8" /><br/><img src='/BBS/CreateCode'/><br/>
	   	  <input type='checkbox' name='iskeepinfo' value='keep'/><font size=2>是否保存账号</font><br/>
	   	  <input type='submit' value='登陆'/>
   	  </form>
   	  <%
	   	  if(err!=null)
			{%>
				<font color="red">"+<%=err %>+"</font>
			<%}
   	   %>
  </body>
</html>
