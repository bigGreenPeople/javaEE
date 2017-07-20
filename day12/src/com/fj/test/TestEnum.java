package com.fj.test;

public class TestEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student("fujie", Sex.woman);
		System.out.println("姓名："+s.name+"  性别："+s.sex);
	}

}

enum Sex{
	woman("女"),man("男");
	
	private String sex;
	
	private Sex(String sex){
		this.sex = sex;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.sex;
	}
	
}
//枚举底层的实现方氏
/*class Sex{
	private String val; 
	
	public static Sex man = new Sex("男");
	public static Sex woman = new Sex("女");
	
	private Sex(){
	}
	private Sex(String val){
		this.val = val;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.val;
	}
}*/

class Student{
	public String name;
	public Sex sex;
	
	public Student(String name, Sex sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	
}
