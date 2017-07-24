<%@page import="com.fj.domain.Emp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	//得到要使用的信息 
    	List<Emp> list = (List)request.getAttribute("list");
    	int pageCount = Integer.parseInt(request.getAttribute("pageCount")+"");
     %>
     
     
     <table border="1">
     			<tr><td>EMPNO</td><td>ENAME</td><td>JOB</td><td>MGR</td><td>HIREDATE</td><td>SAL</td><td>COMM</td><td>DEPTNO</td></tr>
     <%
     	for(int i=0;i<list.size();i++){
     		Emp emp = list.get(i);
     		%>
     		
     			<tr><td><%=emp.getEmpno() %></td>
     			<td><%=emp.getEname() %></td>
     			<td><%=emp.getJob() %></td>
     			<td><%=emp.getMgr() %></td>
     			<td><%=emp.getHiredate() %></td>
     			<td><%=emp.getSal() %></td>
     			<td><%=emp.getComm() %></td>
     			<td><%=emp.getDeptno() %></td></tr>  		   		
     		<% 
     	}
      %>
      </table>
      <!-- 分页链接 -->
      <%
      	for(int i=1;i<=pageCount;i++){
      		%>
      			<a href="/forPage/Paging?pageNow=<%=i%>"><%=i%></a> &nbsp;&nbsp;&nbsp;
      		<% 
      	}
       %>
  </body>
</html>
