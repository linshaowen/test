/**
 * 
 */
package com.excel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.gzctksxt.bean.BaseBean;
import com.gzctksxt.dao.BaseBeanDao;
import com.gzctksxt.daoImp.BaseBeanImp;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class SaveData2DB {

	@SuppressWarnings({ "rawtypes" })
	public void save(String filepath,String title) throws IOException, SQLException {
		ReadExcel xlsMain = new ReadExcel();
//		BaseBean bb = null;
		xlsMain.readXls(filepath,title);
//BaseBeanDao bd=new BaseBeanImp();
//
//		
//			bb = list.get(0);
//			bd.insert("zj",bb);
			
		
	}
}
