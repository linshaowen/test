package com.gzctksxt.dao;

import java.sql.Connection;



public abstract class ConnectionManager {
	private static ConnectionManager cm=null;
	
	public abstract Connection getConnection();
	
	public static ConnectionManager getInstance()
	{
		
		if(null==cm)
		{
			try {
				cm=(ConnectionManager) Class.forName("com.gzctksxt.dao.C3p0Manager").newInstance();
				
			} catch (Exception e) {
				System.out.println("ERROR_003_Connetion Manager Imp.....");
			}
			
		}else
		{
//			System.out.println(cm);
			System.out.println("ERROR_008 ConnectionManager...��ʼ��ʧ��");
		}
		return cm;
	}

}
