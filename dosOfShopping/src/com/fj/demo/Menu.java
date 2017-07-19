package com.fj.demo;
/*
 * 这个类是用于打印菜单的信息
 * */
public class Menu {
	//打印出登录界面
	public void printLoginMenu(){
		System.out.println("\t欢迎使用杰氏购物管理系统1.0版");
		System.out.println("***********************************");
		System.out.println("1.登录系统");
		System.out.println("2.管理员更改密码");
		System.out.println("3.退出");
		System.out.println("***********************************");
		System.out.println("选择你要进行的操作:");
	}
	
	//打印系统主界面
	public void printMainMenu(){
		System.out.println("\t欢迎使用杰氏购物管理系统");
		System.out.println("***********************************");
		System.out.println("1.客户信息管理");
		System.out.println("2.购物结算");
		System.out.println("3.真情回顾");
		System.out.println("4.注销");
		System.out.println("***********************************");
		System.out.println("选择你要进行的操作:");
	}
	
	//打印客户信息管理界面
	public void printCustManageMenu(){
		System.out.println("杰氏购物管理系统>客户管理信息>显示客户信息");
		System.out.println("***********************************");
		System.out.println("1.显示所有用户信息");
		System.out.println("2.添加客户信息");
		System.out.println("3.修改客户信息");
		System.out.println("4.查询客户信息");
		System.out.println("***********************************");
		System.out.println("选择你要进行的操作或按'n'返回上一层:");
	}
	
	//打印真情回顾的管理界面
	public void printReviewManageMenu(){
		System.out.println("杰氏购物管理系统>真情回顾");
		System.out.println("***********************************");
		System.out.println("1.幸运大放送");
		System.out.println("2.辛运抽奖");
		System.out.println("3.生日问候");
		System.out.println("***********************************");
		System.out.println("选择你要进行的操作或按'n'返回上一层:");
	}
	
	//打印3行回车
	public static void nextMenu(){
		for(int i=0;i<3;i++){
			System.out.println();
		}
	}
	
}
