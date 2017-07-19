package com.fj.demo;

import java.util.*;

import com.fj.data.Data;
import com.fj.data.Goods;

public class ShoppingService {
	//定义一个集合当作“购物车”  这里也可以使用数组为了方便我使用了集合
	public static List<GiftInfo> list = new LinkedList<GiftInfo>();
	//用作输出
	public static Scanner scanner = new Scanner(System.in);
	//显示商品
	public void showGoods(){
		System.out.println("杰氏购物管理系统>购物结算");
		System.out.println("*************************");
		Goods[] goods = Data.goods;
		System.out.println("请选择要购买的商品编号:");
		//循环遍历显示商品的信息
		for(int i=0;i<goods.length;i++){
			if(goods[i].goodsName!=null){
				System.out.println((i+1)+":"+goods[i].goodsName);
			}
		}
		
		System.out.println("*************************");
	}
	
	//购买商品
	public void shopping(){
		//得到我们的商品库
		Goods[] goods = Data.goods;
		
		System.out.print("请输入会员号:");
		int custNo = scanner.nextInt();
		while(true){
			
			System.out.print("请输入商品编号:");
			int giftIndex = scanner.nextInt()-1;
			System.out.print("请输入数目:");
			int num = scanner.nextInt();
			
			//加入购物车
			int isPayIdenx = -1;
			for(int i=0;i<list.size();i++){
				//如果此商品以及买了一次
				if(giftIndex==list.get(i).giftIndex){
					isPayIdenx = i;
				}
			}
			
			if(isPayIdenx!=-1){
				list.get(isPayIdenx).num+=num;
			}else{
				GiftInfo giftInfo = new GiftInfo(custNo,giftIndex, num );
				list.add(giftInfo);
			}
			
			
			//是否退出
			System.out.print("是否继续(y/n):");
			String flag = scanner.next();
			if(flag.equals("n")){
				break;
			}
		}
		
		
		//结算统计
		
		
		//输出消费清单
		System.out.println("***********消费清单***********");
		System.out.println("物品\t单价\t个数\t金额");
		
		//总金额
		double sum = 0;
		for(GiftInfo gift:list){
			sum+=(gift.num*goods[gift.giftIndex].goodsPrice);
			System.out.println(goods[gift.giftIndex].goodsName
					+"   "+goods[gift.giftIndex].goodsPrice+"元"
					+"   "+gift.num
					+"   "+(gift.num*goods[gift.giftIndex].goodsPrice)+"元");
		}
		
		
		System.out.println("折扣：         "+sale(sum));
		System.out.println("金额总计： "+(sale(sum)*sum)+"元");
		System.out.print("实际缴费： ");
		double payMoney = scanner.nextInt();
		System.out.println("找钱：         "+(payMoney-sale(sum)*sum)+"元");
		System.out.println("本次购物所得积分："+(sale(sum)*sum*0.1));
		
		//更新用户的积分
		for(int i=0;i<Data.customers.length;i++){
			if(Data.customers[i].custNo == list.get(0).custNo){
				Data.customers[i].custScore =Data.customers[i].custScore+(int) (sale(sum)*sum*0.1); 
			}
		}
		 
	}
	
	//创建一个打折的方法
	public double sale(double sum){
		if(sum>=5000){
			return 0.75;
		}else if(sum>=4000){
			return 0.8;
		}else if(sum>=3000){
			return 0.85;
		}else if(sum>=2000){
			return 0.9;
		}else if(sum>=1000){
			return 0.95;
		}else{
			return 1;
		}
	}
}