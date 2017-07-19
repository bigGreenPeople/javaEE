package com.fj.demo;

import java.util.Scanner;

import com.fj.data.Data;
import com.fj.data.Goods;

/*
 * 这个类要负责抽奖的业务逻辑
 * */
public class LuckService {
	Scanner scanner = new Scanner(System.in);
	//辛运大放送的方法
	public void giveGift(){
		System.out.println("杰氏购物管理系统>真情回顾>幸运大放送");
		System.out.println();
		//找出积分最高的会员并打印
		int maxIndex = -1;
		int maxScore = 0;
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custScore>maxScore){
				maxScore = Data.customers[i].custScore;
				maxIndex = i;
			}
			if(Data.customers[i].custNo == 0){
				break;
			}	
		}
		//打印最高积分的会员信息
		if(maxIndex!=-1){
			System.out.println("具有最高积分的会员是："+Data.customers[maxIndex].custNo+"   "+Data.customers[maxIndex].custBirth+"   "+Data.customers[maxIndex].custScore);
		}
		
		System.out.println("恭喜！获赠礼品：一个价值12000.0元的苹果笔记本电脑");
		System.out.println();
		System.out.print("回车键继续......");
		scanner.nextLine();
		Menu.nextMenu();
	}
	
	//辛运抽奖方法
	public void luckDraw(){
		System.out.println("杰氏购物管理系统>真情回顾>幸运抽奖");
		System.out.println();
		System.out.print("是否开始(y/n):");
		String flag = scanner.nextLine();
		
		if(flag.equals("y")){
			//获得数组元素的最大下标
			int maxIndex = -1;
			for(int i=0;i<Data.customers.length;i++){
				if(Data.customers[i].custNo == 0){
					maxIndex = i-1;
					break;
				}
			}
			
			//创建一个0到maxIndex的随机数	
			int index = (int) (Math.random()*maxIndex);
			System.out.println();
			System.out.println("幸运用户获赠MP3："+Data.customers[index].custNo);
			System.out.println();
			System.out.print("回车键继续......");
			scanner.nextLine();
		}else if(flag.equals("n")){
			return;
		}else{
			System.out.println("输入的值有误！");
		}
	}
	
	//生日问候
	public void birthdayGreetings(){
		System.out.println("杰氏购物管理系统>真情回顾>生日问候");
		System.out.println();
		
		System.out.print("请输入今天的日期(月/日<用两位数表示>):");
		String nowDate = scanner.next();
		//找到生日是nowDate的人
		int index = -1;
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custNo == 0){
				break;
			}
			if(Data.customers[i].custBirth.equals(nowDate)){
				index = i;
				break;
			}
		}
		if(index!=-1){
			System.out.println("过生日的会员是:"+Data.customers[index].custNo);
			System.out.println("恭喜！获赠mp3一个！	");
		}else{
			System.out.println("今天没人过生日 !");
		}
		System.out.println();
		System.out.println("回车键继续......");
		scanner.nextLine();
		
	}
}
