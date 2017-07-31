package com.dvd.dao.Imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.dvd.DB.DVDMgr;
import com.dvd.dao.DVDDAO;
import com.dvd.domain.DVD;

public class DVDDAOImp implements DVDDAO {

	//添加
	@Override
	public boolean add(DVD dvd) {
		boolean b = true;
		
		//往list里面添加数据
		DVDMgr.db.add(dvd);
		
		//修改最后的ID
		DVDMgr.lastID++;
		
		return b;
	}

	//删除
	@Override
	public boolean delete(String name) {
		boolean b = false;
		//创建存放DVD的集合
		List<DVD> list = null;
		list = DVDMgr.db;
		//查找list里有没有name
		for(int i=0;i<list.size();i++){
			//如果找到我们就删除
			if(list.get(i).getName().equals(name)){
				//System.out.println("状态："+list.get(i).getStuta());
				//判断它的状态（是否已经借出）
				if(list.get(i).getStuta()==0){
					DVDMgr.db.remove(list.get(i));
					b = true;
				}
				
			}
		}
		
		return b;
	}

	@Override
	public List<DVD> showDVD() {
		//创建存放DVD的集合
		List<DVD> list = null;
		//得到数据
		list = DVDMgr.db;
		
		return list;
	}

	@Override
	public boolean giveDVD(String name, Date date) {
		boolean b = false;
		//查找list里有没有name
		for(DVD dvd:DVDMgr.db){
			//如果找到我们就修改状态
			if(dvd.getName().equals(name)){
				//判断它的状态（是否已经借出）
				if(dvd.getStuta()==0){
					dvd.setStuta(1);
					dvd.setGiveDate(date);
					//dvd.setGetDate(null);
					dvd.setNum((dvd.getNum()+1));
					b = true;
				}
				
			}
		}
		
		return b;

	}
	@Override
	public boolean getDVD(String name, Date date) {
		boolean b = false;
		
		for(DVD dvd:DVDMgr.db){
			//如果找到我们就修改状态
			if(dvd.getName().equals(name)){
				//判断它的状态（是否已经没借出）
				if(dvd.getStuta()==1){
					dvd.setStuta(0);
					//dvd.setGiveDate(null);
					dvd.setGetDate(date);
					b = true;
				}
				
			}
		}
		return b;

	}
	
	@Override
	public int getLastID() {
		// TODO Auto-generated method stub
		return DVDMgr.lastID;
	}
	
	@Override
	public List<DVD> showByNum() {
		// TODO Auto-generated method stub
		List<DVD> list = new ArrayList<DVD>();
		
		//复制到新的集合
		list.addAll(DVDMgr.db);
		//排序
		Collections.sort(list);
		
		return list;
	}
	
	@Override
	public int getDay(String name) {
		// TODO Auto-generated method stub
		int day = 0;
		for(DVD dvd:DVDMgr.db){
			//如果找到我们就修改状态
			if(dvd.getName().equals(name)){
				
				Long newTime = dvd.getGetDate().getTime();
				Long oldTime = dvd.getGiveDate().getTime();
				long time = newTime-oldTime;
				day = (int) (time/(1000*60*60*24));
			}
		}
		
		return day;
	}
}
