package com.dvd.view;

import com.dvd.DB.DVDMgr;

public class Start {

	public static void main(String[] args) {
		//初始化数据
		DVDMgr.init();
		//实例化对象
		Menu dvdMgr=new Menu();
		//无限循环
		while(true){
		dvdMgr.startMenu();   //主界面
		}
	}

}
