package com.fj.reflect;

public class Dog {
	
	//这里使用反射调用不会自动拆箱，所以我们定义成integer
	public void cry(String name,Integer age){
		System.out.println("小狗"+name+"  年龄是"+age);
	}
}
