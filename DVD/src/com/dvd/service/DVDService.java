package com.dvd.service;

public interface DVDService {
	//添加	把name封装成一个DVD对象 
	public void add(String name);	
	//删除	
	public void delete(String name);
	//显示dvd		得到list显示出来
	public void showDVD();
	//借出	String ---> Date
	public void giveDVD(String name,String date);
	//归还	String ---> Date
	public void getDVD(String name,String date);
	//��������ʾ
	public void showByNum();
}
