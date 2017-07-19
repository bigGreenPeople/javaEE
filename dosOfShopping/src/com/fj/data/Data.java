package com.fj.data;

import com.fj.data.*;;
/**
 * 初始化数据
 * @author Administrator
 *
 */
public class Data {
	/* 商品信息 */
	public static Goods goods[] = new Goods[50];
	/* 会员信息 */
	public static  Customer customers[] = new Customer[100];
	/* 管理员 */
	public static Manager manager = new Manager();
	
	//定义初始化方法
	public void init(){
		for (int i = 0; i < goods.length; i++) {
			goods[i] = new Goods();
		}
		
		// 商品0
		goods[0].goodsName = "addidas运动鞋";
		goods[0].goodsPrice = 880;
		
		// 商品1
		goods[1].goodsName = "Kappa网球裙";
		goods[1].goodsPrice = 200;
	
		// 商品2
		goods[2].goodsName = "网球拍";
		goods[2].goodsPrice = 780;
	

		// 商品3
		goods[3].goodsName = "addidasT恤";
		goods[3].goodsPrice = 420.78;
		

		// 商品4
		goods[4].goodsName = "Nike运动鞋";
		goods[4].goodsPrice = 900;
		

		// 商品5
		goods[5].goodsName = "Kappa网球";
		goods[5].goodsPrice = 45;
		

		// 商品6
		goods[6].goodsName = "KappaT恤";
		goods[6].goodsPrice = 245;

	
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer();
		}
		customers[0].custNo = 1900; // 客户1
		customers[0].custBirth = "08/05";
		customers[0].custScore = 2000;

		customers[1].custNo = 1711; // 客户2
		customers[1].custBirth = "07/13";
		customers[1].custScore = 4000;

		customers[2].custNo = 1623; // 客户3
		customers[2].custBirth = "06/26";
		customers[2].custScore = 5000;

		customers[3].custNo = 1545; // 客户4
		customers[3].custBirth = "04/08";
		customers[3].custScore = 2200;

		customers[4].custNo = 1464; // 客户5
		customers[4].custBirth = "08/16";
		customers[4].custScore = 1000;

		customers[5].custNo = 1372; // 客户6
		customers[5].custBirth = "12/23";
		customers[5].custScore = 3000;

		customers[6].custNo = 1286; // 客户7
		customers[6].custBirth = "12/21";
		customers[6].custScore = 10080;
	}
}

