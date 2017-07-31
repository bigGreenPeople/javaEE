package com.dvd.view;
 //业务逻辑层的实现

import java.util.Scanner;

import com.dvd.service.DVDService;
import com.dvd.service.Imp.DVDServiceImp;

public class Menu {
	//实例化DVDServiceImp对象
	DVDService dsi=new DVDServiceImp();
	//实例化Scanner对象
	Scanner input=new Scanner(System.in);
	//初始化碟片信息
	public void initial(){
		
	}
	
	//显示Dvd菜单
	public void startMenu(){
		System.out.println("	欢迎使用迷你DVD管理器");
		System.out.println("-------------------------------");
		System.out.println("0.借出排行榜");
		System.out.println("1.新增DVD");
		System.out.println("2.查看DVD");
		System.out.println("3.删除DVD");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.退         出");
		System.out.println("-------------------------------");
		System.out.println();
		System.out.print("请选择:");
		String num=input.next();
		switch (num) {
		case "1":
			System.out.print("请输入要新增的DVD的名称:");
			String aname=input.next();
			dsi.add(aname);    //新增DVD
			break;
		case "2":
			dsi.showDVD();    //查看DVD所有信息
			break;
		case "3":
			System.out.println("请输入要删除的DVD的名称:");
			String dname=input.next();
			dsi.delete(dname);    //删除DVD
			break;
		case "4":
			System.out.print("请输入借出的DVD的名称:");
			String gname=input.next();
			System.out.print("请输入借出DVD的日期:");
			String gdate=input.next();
			dsi.giveDVD(gname, gdate);    //借出DVD
			break;
		case "5":
			System.out.print("请输入归还的DVD的名称:");
			String hname=input.next();
			System.out.print("请输入归还DVD的日期:");
			String hdate=input.next();
			dsi.getDVD(hname, hdate);    //归还DVD
			break;
		case "6":
			System.out.println("谢谢使用");  
			System.exit(0);	 //退出虚拟机
			break;
		case "0":
			dsi.showByNum();    //返回主界面
			break;
		default:
			System.out.println("你输入有误，请重新输入");
			startMenu();   //主界面
			break;
		}
	}
	//返回主菜单
	public void returnMain() {
		startMenu();
	}

	
}
