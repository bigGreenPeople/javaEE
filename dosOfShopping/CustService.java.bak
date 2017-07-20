package com.fj.demo;

import java.util.Scanner;

import com.fj.data.*;

/*
 * 这是客户的服务类
 * */
public class CustService {
	
	public static Scanner scanner = new Scanner(System.in);
	// 显示客户信息
	public void showCust(){
		System.out.println("杰氏购物管理系统>客户管理信息>显示客户信息");
		System.out.println("会员号\t生日\t积分");
		System.out.println("-------|-------|-------");
		//显示所有的客户
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custBirth==null){
				System.out.print("回车键继续......");
				scanner.nextLine();
				Menu.nextMenu();
				return;
			}else{
				System.out.println(Data.customers[i].custNo+"   "+
						Data.customers[i].custBirth+"   "+
						Data.customers[i].custScore+"   ");
			}
			
		}
		
	}
	
	//添加用户
	public boolean addCust(){
		boolean b=false;
		
		System.out.println("杰氏购物管理系统>客户管理信息>添加客户信息");
		
		System.out.print("请输入会员号(4位整数):");
		int custNo = scanner.nextInt();        //会员编号  
		System.out.print("请输入会员生日(月/日<用两位数表示>):");
		String custBirth = scanner.next();     //会员生日
		System.out.print("请输入积分:");
		int custScore = scanner.nextInt();    //会员
		
		//创建一个客户对象
		Customer customer = new Customer(custNo, custBirth, custScore);
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custBirth==null){
				Data.customers[i] = customer;
				//添加成功
				b = true;
				break;
			}		
		}
		
		return b;
	}
	
	//修改用户信息
	public boolean updCust(){
		boolean b=true;
		System.out.println("杰氏购物管理系统>客户管理信息>修改客户信息");
		
		System.out.print("请输入会员号:");
		int id = scanner.nextInt();
		
		System.out.println("会员号\t生日\t积分");
		System.out.println("-------|-------|-------");
		//遍历数组
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custBirth==null){
				
				break;
			}
			if(Data.customers[i].custNo==id){
				System.out.println(Data.customers[i].custNo+"   "+
						Data.customers[i].custBirth+"   "+
						Data.customers[i].custScore+"   ");
				
				//修改
				System.out.println("*****************************");
				System.out.println("1.修改生日");
				System.out.println("2.修改积分");
				System.out.println("*****************************");
				
				System.out.println("请输入选择：");
				int flag = scanner.nextInt();
				if(flag==1){
					//修改生日
					System.out.println("请输入修改后的生日:");
					Data.customers[i].custBirth = scanner.next();
				}else if(flag==2){
					//修改积分
					System.out.println("请输入修改后的积分:");
					Data.customers[i].custScore = scanner.nextInt();
				}else{
					System.out.println("数值错误!");
					b = false;
				}
			}
		}
		
		return b;
	}
	
	//查询用户信息
	public void findCustById(){
		System.out.println("杰氏购物管理系统>客户管理信息>查询客户信息");
		
		System.out.print("请输入会员号:");
		int id = scanner.nextInt();
		
		System.out.println("会员号\t生日\t积分");
		System.out.println("-------|-------|-------");
		//遍历数组
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custBirth==null){
				
				break;
			}
			if(Data.customers[i].custNo==id){
				System.out.println(Data.customers[i].custNo+"   "+
						Data.customers[i].custBirth+"   "+
						Data.customers[i].custScore+"   ");
			}
		}
		
		System.out.print("回车键继续......");
		scanner.nextLine();
	}
	
}
