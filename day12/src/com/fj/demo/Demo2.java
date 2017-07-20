package com.fj.demo;

import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) {
		while(true){
			inputAge();
		}
		
	}

	public static void inputAge() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("请输入你的年龄:");
		String age = scanner.next();
		
		boolean b = false;
		
		if(age.length()==2){
			String reg = "^[1-9]\\d";
			if(age.matches(reg)){
				b = true;
			}
		}else if(age.length()==1){
			String reg = "^\\d";
			if(age.matches(reg)){
				b = true;
			}
		}else if(age.length()==3){
			if(age.equals("120")){
				b = true;
			}else{
				String reg = "^[1][0-1]\\d";
				if(age.matches(reg)){
					b = true;
				}
			}
		}
		
		if(!b){
			System.out.println("年龄有误！！");
		}else{
			System.out.println("年龄正确");
		}
	}
	
	
}
