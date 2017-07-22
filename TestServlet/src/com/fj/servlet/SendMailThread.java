package com.fj.servlet;
/*
 * 当servlet第一次被访问的时候每隔2s发一次邮件
 * */
public class SendMailThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		try {
			while(true){
				Thread.sleep(2000);
				System.out.println("发出第"+i+++"封邮件");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//super.run();
	}
}
