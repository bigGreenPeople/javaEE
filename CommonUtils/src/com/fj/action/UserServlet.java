package com.fj.action;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fj.CommonUtils.CommonUtils;
import com.fj.domain.User;

public class UserServlet extends BaseServlet {
	

	public String getUser(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
//		将form表单传递的参数变成一个map
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		//Set <String> set = parameterMap.keySet();
		User user=null;
		try {
			//调用我们的CommonUtils的tobean方法  直接将from表单的内容中是user属性的内容注入到user中
			user = CommonUtils.toBean(User.class, parameterMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//打印出user的信息
		System.out.println("username:"+user.getUsername()+"\npassword:"+user.getPassword());
		return null;
	}
	
}
