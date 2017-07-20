package com.fj.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Demo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		A a = new A();
		a.setIndex1(10);
		a.setIndex2(101);
		a.setIndex3(20);
		a.setIndex4(11);
		a.setIndex5(120);
		a.setIndex6(5);
		a.setIndex7(6);
		a.setIndex8(30);
		a.setIndex9(0);
		
		//使用for计算出所有index的和
		//得到类对象
		Class clazz = Class.forName("com.fj.test.A");
//		Constructor c = clazz.getConstructor();
//		A aa = (A) c.newInstance();
		//得到属性数组
		Field[] field = clazz.getDeclaredFields();
		int sum = 0;
		for(Field f:field){
			//暴力访问
			System.out.println(f.getType());
			if(f.getType()==int.class){
				f.setAccessible(true);
				
				sum+=f.getInt(a);
			}
			
		}
		
		System.out.println(sum);
	}
	
}

class A{
	private final Long i = 20000L;
	private int index1;
	private int index2;
	private int index3;
	private int index4;
	private int index5;
	private int index6;
	private int index7;
	private int index8;
	private int index9;
	
	
	
	
	public Long getI() {
		return i;
	}
	private int getIndex1() {
		return index1;
	}
	public void setIndex1(int index1) {
		this.index1 = index1;
	}
	public int getIndex2() {
		return index2;
	}
	public void setIndex2(int index2) {
		this.index2 = index2;
	}
	public int getIndex3() {
		return index3;
	}
	public void setIndex3(int index3) {
		this.index3 = index3;
	}
	public int getIndex4() {
		return index4;
	}
	public void setIndex4(int index4) {
		this.index4 = index4;
	}
	public int getIndex5() {
		return index5;
	}
	public void setIndex5(int index5) {
		this.index5 = index5;
	}
	public int getIndex6() {
		return index6;
	}
	public void setIndex6(int index6) {
		this.index6 = index6;
	}
	public int getIndex7() {
		return index7;
	}
	public void setIndex7(int index7) {
		this.index7 = index7;
	}
	public int getIndex8() {
		return index8;
	}
	public void setIndex8(int index8) {
		this.index8 = index8;
	}
	public int getIndex9() {
		return index9;
	}
	public void setIndex9(int index9) {
		this.index9 = index9;
	}
	
	
	
}
