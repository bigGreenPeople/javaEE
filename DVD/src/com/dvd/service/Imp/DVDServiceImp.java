package com.dvd.service.Imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dvd.dao.DVDDAO;
import com.dvd.dao.Imp.DVDDAOImp;
import com.dvd.domain.DVD;
import com.dvd.service.DVDService;

/**
 * @author Administrator
 *2017-7-31 11:42:26
 *l
 */
public class DVDServiceImp implements DVDService {	
	public DVDDAO dvdDao = new DVDDAOImp();		
	//澶栭潰缁欎簡name  name---DVD
	@Override
	public void add(String name) {
		//鍒涘缓dvd
		DVD dvd = new DVD(dvdDao.getLastID(), name, 0, 0, null, null);
		//娣诲姞
		if(dvdDao.add(dvd)){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}				
	}	
	@Override
	public void delete(String name) {
		 //鍒ゆ柇鍒犻櫎鏄惁鎴愬姛
		if(dvdDao.delete(name)){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
	@Override
	public void showDVD() {
		//寰楀埌鎵�湁鐨凞VD
		List<DVD> list = dvdDao.showDVD();	
		System.out.println("编号"+"\t"+"是否借出"+"\t名称"+"\t借出时间");
		for(DVD dvd:list){
			String sta = "借出";
			if(dvd.getStuta()==0){
				sta = "未借出";
			}
			String date="";
			if(dvd.getGiveDate()!=null){
				SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");				
				 date = sd.format(dvd.getGiveDate());
			}
			
			System.out.println(dvd.getId()+"\t"+sta+"\t"+dvd.getName()+"\t"+date);
		}
	}
	
	@Override
	public void giveDVD(String name, String date) {
		//string---data
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		
		Date d=null;
		try {
			d = sd.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//鍒ゆ柇鏄惁鍊熷嚭
		if(dvdDao.giveDVD(name, d)){
			System.out.println("借出成功");
		}else{
			System.out.println("借出失败");
		}	
	}
	@Override
	public void getDVD(String name, String date) {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		
		Date d=null;
		try {
			d = sd.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//鍒ゆ柇鏄惁杩樹功
		if(dvdDao.getDVD(name, d)){
			System.out.println("归还成功");
			
			System.out.print("租金为："+dvdDao.getDay(name)+"元\n");
		}else{
			System.out.println("归还失败");
		}		
	}
	
	@Override
	public void showByNum() {
		// TODO Auto-generated method stub
		List<DVD> list = dvdDao.showByNum();
		
		System.out.println("序号\t"+"名称\t"+"借出次数");
		for(DVD dvd:list){
			
			System.out.println(dvd.getId()+"\t"+dvd.getName()+"\t"+dvd.getNum());
		}
	}
}
