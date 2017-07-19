package com.fj.demo;

import java.util.Scanner;

import com.fj.data.*;

public class StartManagement {
	
	public static Scanner input = new Scanner(System.in);//输入流
	public static Menu menu = new Menu();//负责打印菜单的类
	public static Data data = new Data();
	
	public static void main(String[] args) {
		while(true){
			launch();
		}
	}
	
	public static void launch(){
		//初始化data数据
				data.init();
				
				//打印出登录界面
				menu.printLoginMenu();
				
				//选择你要进行的操作
				
				int flag = input.nextInt();
				Menu.nextMenu();
				//创建管理员服务类
				ManagerService managerService = new ManagerService();
				
				//判断用户选择的选项
				switch (flag) {
				case 1:
					//进行登录验证
					System.out.println("请输入密码:");
					if(managerService.checkAdmin(input.next())){
						System.out.println("进入系统");
						mainManagement();
					}else{
						System.out.println("密码错误!");
						//System.out.println(Manager.loginNum);
						if(Manager.loginNum==3){
							System.out.println("密码错误3次输入错误！系统自动关闭！！！！！！！！");
							System.exit(0);;
						}
					}
					
					break;
				case 2:
					//管理员更改密码
					System.out.println("请输入修改前密码:");
					if(managerService.checkAdmin(input.next())){
						System.out.println("请输入修改后密码:");
						managerService.updPass(input.next());
					}else{
						System.out.println("密码错误!");
					}
					Menu.nextMenu();
					break;
				case 3:
					//退出jvm
					Menu.nextMenu();
					System.out.println("谢谢您的使用!祝您生活愉快0.0.....");
					System.exit(0);
					break;
				default:
					System.out.println("输入的值有误！");
					break;
				}
	}
	
	//进入主系统
	public static void mainManagement(){
		while(true){
			//打印系统主界面
			menu.printMainMenu();
			
			//接受选项
			int flag = input.nextInt();
			Menu.nextMenu();
			//判断选择选项
			switch (flag) {
			case 1:		
				//进入客户信息管理
				custManagement();
				
				break;
			case 2:
				//进入购物系统
				shoppingManagement();
				break;
			case 3:
				//进入真情回顾
				reviewManagement();
				break;
			case 4:
				//退出系统  就是退出函数
				return;
			default:
				System.out.println("输入的值有误！");
				break;
			}
		}
	}
	
	//客户信息管理系统
	public static void custManagement(){
		while(true){
			//打印客户管理界面
			menu.printCustManageMenu();
			//创建用户服务类 
			CustService custService = new CustService();
			
			//接受用户的选项
			String flag = input.next();
			Menu.nextMenu();
			//判断用户的选项
			switch (flag) {
			case "1":
				//显示所有
				custService.showCust();
				break;
			case "2":
				//添加
				if(custService.addCust()){
					System.out.println("添加成功！");
				}else{
					System.out.println("添加失败!");
				}
				Menu.nextMenu();
				break;
			case "3":
				//修改
				if(custService.updCust()){
					System.out.println("修改成功！");
				}else{
					System.out.println("修改失败!");
				}
				Menu.nextMenu();
				break;
			case "4":
				//查询
				while(true){
					custService.findCustById();
					System.out.print("要继续查询吗(y/n):");
					if("n".equals(input.next())){
						break;
					}
				}
				Menu.nextMenu();
				break;
			case "n":
				//返回上一层
				return;
			default:
				System.out.println("输入的值有误！");
				break;
			}
		}
	}
	
	//购物管理系统
	public static void shoppingManagement(){
		//创建shoppingservice
		ShoppingService shoppingService = new ShoppingService();
		
		//打印商品信息
		shoppingService.showGoods();
		
		//购买物品
		shoppingService.shopping();
		
		System.out.print("回车键返回上一层......");
		input.nextLine();
		Menu.nextMenu();
	}
	
	//真情回顾系统
	public static void reviewManagement(){
		while(true){
			//创建luckservic
			LuckService luckService = new LuckService();
			//打印真情回顾界面
			menu.printReviewManageMenu();
			//接受选择参数
			String flag = input.next();
			menu.nextMenu();
			//判断
			switch (flag) {
			case "1":
				//辛运大放送
				luckService.giveGift();
				break;
			case "2":
				//辛运抽奖
				luckService.luckDraw();
				break;
			case "3":
				//生日问候
				luckService.birthdayGreetings();
				menu.nextMenu();
				break;
			case "n":
				//返回上一层
				return;
			default:
				System.out.println("输入的值有误！");
				menu.nextMenu();
				break;
			}
		}
		
	}
}
