package com.dvd.DB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dvd.domain.*;

public class DVDMgr {
	//模拟的数据库
	public static List<DVD> db = new ArrayList<DVD>();
	//下次添加的ID
	public static int lastID = 4;
	
	//初始化方法
	public static void init(){
		DVD d1 = new DVD(1, "战狼", 1, 1,new Date() , null);
		DVD d2 = new DVD(2, "刺客信条", 0, 0, null, null);
		DVD d3 = new DVD(3, "小时代", 0, 0, null, null);
		
		db.add(d1);
		db.add(d2);
		db.add(d3);
	}
}
