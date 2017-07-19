package com.fj.demo;
/*
 * 这是你购买商品的信息mod
 * */
public class GiftInfo {
	//购买人员
	public int custNo;
	//商品下标
	public int giftIndex;
	//个数
	public int num;
	
	
	public GiftInfo(){
		
	}

	public GiftInfo(int custNo,int giftIndex, int num) {
		super();
		this.giftIndex = giftIndex;
		this.num = num;
		this.custNo = custNo;
	}
	
	
}
