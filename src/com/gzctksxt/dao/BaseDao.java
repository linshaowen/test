package com.gzctksxt.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;

public class BaseDao<T extends Serializable> {
	public static ConnectionManager cm=ConnectionManager.getInstance();
	
	public void setParamsToPs(PreparedStatement ps,Object... params) throws SQLException
	{
		if(null!=params&&params.length>0)
		{
			for(int i=0;i<params.length;i++)
			{
				
			
					ps.setObject(i+1, params[i]);
//输出每个set到ps的值
				System.out.println(params[i]);
				
			}
		}
//		System.out.println(ps.toString());
	}
	public T parseResultSetToBean(Class<T> clazz,ResultSet rs)
	{
		T t=null;
		try {
			t=clazz.newInstance();
			ResultSetMetaData rmd=rs.getMetaData();
			int columnCount=rmd.getColumnCount();
			String [] fieldsName=new String[columnCount];
			for(int i=0;i<columnCount;i++)
			{
				fieldsName[i]=rmd.getColumnLabel(i+1);
			}
			for (int i = 0; i <columnCount; i++) {
				int columnType=rmd.getColumnType(i+1);
				switch(columnType)
				{
				case Types.INTEGER:
				case Types.BIGINT:
				case Types.TINYINT:
					setValueToField(clazz, t, rs.getInt(i+1), fieldsName[i]);
					break;
				case Types.VARCHAR:
				case Types.VARBINARY:
				case Types.LONGNVARCHAR:
				case Types.CHAR:
					setValueToField(clazz, t, rs.getString(i+1), fieldsName[i]);
					break;
				case Types.TIME:
				case Types.TIMESTAMP:
					setValueToField(clazz, t, rs.getTimestamp(i+1), fieldsName[i]);
					
					break;
				default:
					break;
				}
			}
			} catch (Exception e) 
			{
				System.out.println("0013...��ResultSetת����Bean����......");
			}
		return t;
	}

	public void setValueToField(Class clazz,T t,Object value,String fieldName)
	{
		
		try {
			String filedName=parseColumnToField(fieldName);
			Field field=clazz.getDeclaredField(filedName);
			if(null!=field)
			{
				field.setAccessible(true);
				field.set(t,value);
				} 
		}catch (IllegalArgumentException e) {
					
			e.printStackTrace();
		} catch (IllegalAccessException e) {
					
			e.printStackTrace();
		}catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String parseColumnToField(String column)
	{
		if(null!=column&&column.indexOf("_")==-1)
		{
			return column;
		}
		else{
			int	index=column.indexOf("_");
			return column.substring(0,index)+column.substring(index+1,index+2).toUpperCase()+column.substring(index+2);
			
		}
	}
}
