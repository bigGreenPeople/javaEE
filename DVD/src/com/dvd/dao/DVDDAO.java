package com.dvd.dao;

import java.util.Date;
import java.util.List;

import com.dvd.domain.*;

public interface DVDDAO {
	//娣诲姞
	public boolean add(DVD dvd);	
	//鍒犻櫎
	public boolean delete(String name);
	//鏄剧ずdvd
	public List<DVD> showDVD();
	//鍊熷嚭	String ---> Date
	public boolean giveDVD(String name,Date date);
	//褰掕繕
	public boolean getDVD(String name,Date date);
	
	//返回一个添加时的ID
	public int getLastID();
	
	public List<DVD> showByNum();
	
	//得到租期
	public int getDay(String name);
}
