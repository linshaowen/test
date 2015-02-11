package com.gzctksxt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class C3p0Manager  extends ConnectionManager{
	private  static ComboPooledDataSource  cp=new ComboPooledDataSource();
	@Override
	public Connection getConnection() {
		Connection  con=null;
		try {
			con=cp.getConnection();
		} catch (Exception e) {
			System.out.println("ERROR9...ªÒ»°Connection ß∞‹°£°£°£°£..");
			e.printStackTrace();
		}
		return con;
	}
	
}
