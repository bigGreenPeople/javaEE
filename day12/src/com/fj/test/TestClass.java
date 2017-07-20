package com.fj.test;
/*
 * 此类用于测试反射
 * */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class clazz1 =  Class.forName("com.fj.test.Cat");
//		Cat cat = c.newInstance();
		Constructor<Cat> cs = clazz1.getConstructor(String.class,int.class,String[].class);
		String[] foods = {"鱼","老鼠"};
		Cat cat = cs.newInstance("付杰",20,(Object)foods); 
		
		Field field = clazz1.getField("age");
		System.out.println(field.getFloat(cat));
		/*Method m1 = clazz1.getMethod("show", null);
		//调用无参的show方法
		m1.invoke(cat, null);
		Method m2 = clazz1.getMethod("show", int.class,String.class);
		//调用2个参的show方法
		m2.invoke(cat, 31,"付杰");
		Method m3 = clazz1.getDeclaredMethod("show", List.class);
		m3.setAccessible(true);
		List<String> list = new ArrayList<String>();
		list.add("字符1");
		list.add("字符2");
		list.add("字符3");*/
		//调用List参的show方法
		//m3.invoke(cat, list);
		
		//System.out.println(c);
//		System.out.println(cat.name);
//		System.out.println(cat.age);
//		for(String s:cat.foods){
//			System.out.print(s+"  ");
//		}
		
		/*System.out.println(Cat.class);
		Cat cat = new Cat();
		System.out.println(cat.getClass());*/
	}

}

class Cat{
	public String name;
	public int age;
	public String[] foods;
	public Dog dog = new Dog();
	
	public Cat(){
		
	}

	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Cat(String name, int age, String[] foods) {
		super();
		this.name = name;
		this.age = age;
		this.foods = foods;
	}
	
	public void show(){
		System.out.println("调用无参的show方法");
	}
	
	public void show(int age,String name){
		System.out.println("调用int 和  String参的show方法"+age+name);
	}
	
	private void show(List<String> list){
		System.out.println("调用List的show方法");
		for(String s:list){
			System.out.print(s);
		}
	}
}

class Dog{
	public String name;
	public int age;
}
