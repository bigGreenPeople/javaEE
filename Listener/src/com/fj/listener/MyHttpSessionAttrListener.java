package com.fj.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttrListener implements HttpSessionAttributeListener {
	//向session添加属性后触发
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("属性添加：键"+arg0.getName()+"   值："+arg0.getValue());
	}
	//向session删除属性触发
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("属性删除：键"+arg0.getName()+"   值："+arg0.getValue());
	}
	//向session修改属性触发
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		//这里得到的是被修改前的属性
		System.out.println("属性修改 ：键"+arg0.getName()+"   值："+arg0.getValue());
	}

}
