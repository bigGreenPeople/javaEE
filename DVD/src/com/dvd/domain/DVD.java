package com.dvd.domain;

import java.util.Date;

public class DVD implements Comparable<DVD>{
	//DVDid
	private int id;
	//DVD鍚嶇О
	private String name;
	//鍊熷嚭娆℃暟
	private int num;
	//鐘舵�    1琛ㄧず鍊熷嚭 0 琛ㄧず娌″�鍑�
	private int stuta;
	//鍊熷嚭鏃ユ湡
	private Date giveDate;
	//褰掕繕鏃ユ湡
	private Date getDate;
	
	public DVD(){}

	public DVD(int id, String name, int num, int stuta, Date giveDate,
			Date getDate) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.stuta = stuta;
		this.giveDate = giveDate;
		this.getDate = getDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStuta() {
		return stuta;
	}

	public void setStuta(int stuta) {
		this.stuta = stuta;
	}

	public Date getGiveDate() {
		return giveDate;
	}

	public void setGiveDate(Date giveDate) {
		this.giveDate = giveDate;
	}

	public Date getGetDate() {
		return getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	@Override
	public int compareTo(DVD o) {
		// TODO Auto-generated method stub
		if(this.getNum()>o.getNum()){
			return -1;
		}else if(this.getNum()<o.getNum()){
			return 1;
		}else{
			return 0;
		}
		
	}
}
