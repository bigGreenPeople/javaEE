package com.fj.c3p0;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3p0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//得到数据池
			ComboPooledDataSource cds = new ComboPooledDataSource();
			
			Connection connection = cds.getConnection();
			System.out.println(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
