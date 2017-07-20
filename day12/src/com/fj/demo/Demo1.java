package com.fj.demo;

import java.util.Random;
import java.util.Scanner;

public class Demo1 {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true){
			f();
		}
		
	}
	
	public static void f(){
		System.out.print("请输入你的数字:");
		int flag = scanner.nextInt();
		Random random = new Random();
		
		switch (flag) {
		case 1:
			int i = random.nextInt(3);
			if(i==flag)
				System.out.println("恭喜！获得一个洗脸盆");
			else
				System.out.println("什么都没有！！！");
			break;
		case 2:
			int i2 = random.nextInt(3);
			if(i2==flag)
				System.out.println("恭喜！获得一个杯子");
			else
				System.out.println("什么都没有！！！");
			break;
		case 3:
			int i3 = random.nextInt(3);
			if(i3==flag)
				System.out.println("恭喜！获得一个牙膏");
			else
				System.out.println("什么都没有！！！");
			break;
		default:
			System.out.println("输入有误！");
			break;
		}
	}

}
