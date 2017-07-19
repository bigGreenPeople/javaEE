package com.fj.data;

/**
 * 会员类
 * @author Administrator
 *
 */
public class Customer {
	 public int     custNo;        //会员编号  
	 public String  custBirth;     //会员生日
	 public int     custScore ;    //会员
	 
	 public Customer(){
		 
	 }
	 
	public Customer(int custNo, String custBirth, int custScore) {
		super();
		this.custNo = custNo;
		this.custBirth = custBirth;
		this.custScore = custScore;
	}
	 
	 
}