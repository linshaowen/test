/**
 * 
 */
package com.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



import org.apache.poi.ss.usermodel.Cell;

import com.gzctksxt.bean.BaseBean;
import com.gzctksxt.bean.BaseNameBean;
import com.gzctksxt.bean.PJBean;
import com.gzctksxt.dao.BaseBeanDao;
import com.gzctksxt.dao.BaseNameDao;
import com.gzctksxt.dao.PJBeanDao;
import com.gzctksxt.daoImp.BaseBeanImp;
import com.gzctksxt.daoImp.BaseNameImp;
import com.gzctksxt.daoImp.PJBeanImp;



public class ReadExcel {

	public void readXls(String filepath,String title) throws IOException, SQLException,NullPointerException {

		InputStream is = new FileInputStream(filepath);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			BaseBeanDao bd=new BaseBeanImp();
			BaseBean bb=new BaseBean();

			BaseNameDao bnd=new BaseNameImp();
			BaseNameBean bnb=new BaseNameBean();


			PJBeanDao pd=new PJBeanImp();
			PJBean pjb=new PJBean();
			if (hssfSheet == null) {
				continue;
			}
			int over=0;
			// ѭ����Row
			for (int rowNum = 0; over==0; rowNum++) {

				//取得真正的行数,因为可能是空字符“”被认为存在一行；
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if(hssfSheet.getRow(rowNum+1)==null||hssfSheet.getRow(rowNum+1).getCell(0) == null||hssfSheet.getRow(rowNum+1).getCell(0).getStringCellValue().equalsIgnoreCase(""))
				{
					over=1;
				}

				if (hssfRow != null) {
					//如果xls中单元cell是null 读取将有异常，不能取得getStringvalue
					//行和列都是从0开始计算
					System.out.println(title);
					System.out.println(rowNum);
					if (title.equals("4")) {

						try {
							if(rowNum>=1){
								hssfRow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
								hssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
								hssfRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								hssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								hssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);

							
								HSSFCell name = hssfRow.getCell(0);
								HSSFCell zb = hssfRow.getCell(1);
								HSSFCell fhl = hssfRow.getCell(2);
								HSSFCell wcjd = hssfRow.getCell(3);
								HSSFCell hbts = hssfRow.getCell(4);
				
								pjb.setName(name.getStringCellValue());
								pjb.setZb(zb.getStringCellValue());
								pjb.setFhl(fhl.getStringCellValue());
								pjb.setWcjd(wcjd.getStringCellValue());
								pjb.setHbts(hbts.getStringCellValue());

								pd.insert("zd",pjb);
							}
							

						} catch (Exception e) {

						}


					}
					else if(title.equals("1"))
					{

						if(rowNum>0){
							//读取cell之前现进行差错控制，
							for(int i=0;i<hssfRow.getLastCellNum();i++)
							{
								//当是null的时候
								if(hssfRow.getCell(i)==null)
								{
									System.out.println(hssfRow.getLastCellNum()+"sum");
									//									 HSSFCell cell = hssfRow.createCell(i);
									//									System.out.println(i+"here");
									hssfRow.createCell(i, 1);
									hssfRow.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
									hssfRow.getCell(i).setCellValue("");
								}else if (hssfRow.getCell(i).getCellStyle().getDataFormatString().indexOf("%")!=-1&&rowNum>2)
								{	
									//当是百分数的时候

									String s=Math.round(hssfRow.getCell(i).getNumericCellValue()*100)+"%";
									hssfRow.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
									hssfRow.getCell(i).setCellValue(s);
								}else{
									hssfRow.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
								}


							}



							if(rowNum==1)
							{
								//								hssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
								HSSFCell jz = hssfRow.getCell(2);
								bnb.setL10(jz.getStringCellValue());


							}else if(rowNum==2)
							{

								HSSFCell l0 = hssfRow.getCell(0);
								HSSFCell l1 = hssfRow.getCell(1);
								HSSFCell l2 = hssfRow.getCell(2);
								HSSFCell l3 = hssfRow.getCell(3);
								HSSFCell l4 = hssfRow.getCell(4);
								HSSFCell l5 = hssfRow.getCell(5);
								HSSFCell l6 = hssfRow.getCell(6);
								HSSFCell l7 = hssfRow.getCell(7);
								HSSFCell l8 = hssfRow.getCell(8);
								HSSFCell l9 = hssfRow.getCell(9);

								bnb.setL0(l0.getStringCellValue());
								bnb.setL1(l1.getStringCellValue());
								bnb.setL2(l2.getStringCellValue());
								bnb.setL3(l3.getStringCellValue());
								bnb.setL4(l4.getStringCellValue());
								bnb.setL5(l5.getStringCellValue());
								bnb.setL6(l6.getStringCellValue());
								bnb.setL7(l7.getStringCellValue());
								bnb.setL8(l8.getStringCellValue());
								bnb.setL9(l9.getStringCellValue());

								bnd.insert("ydn",bnb);
								System.out.println("done");
							}else if(rowNum>2)
							{
								HSSFCell l0 = hssfRow.getCell(0);
								HSSFCell l1 = hssfRow.getCell(1);
								HSSFCell l2 = hssfRow.getCell(2);
								HSSFCell l3 = hssfRow.getCell(3);
								HSSFCell l4 = hssfRow.getCell(4);
								HSSFCell l5 = hssfRow.getCell(5);
								HSSFCell l6 = hssfRow.getCell(6);
								HSSFCell l7 = hssfRow.getCell(7);
								HSSFCell l8 = hssfRow.getCell(8);
								HSSFCell l9 = hssfRow.getCell(9);

								bnb.setL0(l0.getStringCellValue());
								bnb.setL1(l1.getStringCellValue());
								bnb.setL2(l2.getStringCellValue());
								bnb.setL3(l3.getStringCellValue());
								bnb.setL4(l4.getStringCellValue());
								bnb.setL5(l5.getStringCellValue());
								bnb.setL6(l6.getStringCellValue());
								bnb.setL7(l7.getStringCellValue());
								bnb.setL8(l8.getStringCellValue());
								bnb.setL9(l9.getStringCellValue());
								bd.insert("yd", null, bnb);

							}
						}


					}else if(title.equals("2"))
					{

					
							//读取cell之前现进行差错控制，
							for(int i=0;i<hssfRow.getLastCellNum();i++)
							{
								//当是null的时候
								if(hssfRow.getCell(i)==null)
								{
									System.out.println(hssfRow.getLastCellNum()+"sum");
									//									 HSSFCell cell = hssfRow.createCell(i);
									//									System.out.println(i+"here");
									hssfRow.createCell(i, 1);
									hssfRow.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
									hssfRow.getCell(i).setCellValue("");
								}else if (hssfRow.getCell(i).getCellStyle().getDataFormatString().indexOf("%")!=-1&&rowNum>2)
								{	
									//当是百分数的时候

									String s=Math.round(hssfRow.getCell(i).getNumericCellValue()*100)+"%";
									hssfRow.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
									hssfRow.getCell(i).setCellValue(s);
								}else{
									hssfRow.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
								}


							}



							if(rowNum==0)
							{
								//								hssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
								HSSFCell l0 = hssfRow.getCell(1);
								HSSFCell l1 = hssfRow.getCell(5);
bnb.setL0(l0.getStringCellValue());
bnb.setL1(l1.getStringCellValue());

							}else if(rowNum==1)
							{


								HSSFCell l2 = hssfRow.getCell(1);
								HSSFCell l3 = hssfRow.getCell(2);
								HSSFCell l4 = hssfRow.getCell(3);
								HSSFCell l5 = hssfRow.getCell(4);
								HSSFCell l6 = hssfRow.getCell(5);
								HSSFCell l7 = hssfRow.getCell(6);
								HSSFCell l8 = hssfRow.getCell(7);
								HSSFCell l9 = hssfRow.getCell(8);



								bnb.setL2(l2.getStringCellValue());
								bnb.setL3(l3.getStringCellValue());
								bnb.setL4(l4.getStringCellValue());
								bnb.setL5(l5.getStringCellValue());
								bnb.setL6(l6.getStringCellValue());
								bnb.setL7(l7.getStringCellValue());
								bnb.setL8(l8.getStringCellValue());
								bnb.setL9(l9.getStringCellValue());
								bnd.insert("kdn",bnb);
								System.out.println("done");
							}else if(rowNum>1)
							{
								HSSFCell l0 = hssfRow.getCell(0);
								HSSFCell l1 = hssfRow.getCell(1);
								HSSFCell l2 = hssfRow.getCell(2);
								HSSFCell l3 = hssfRow.getCell(3);
								HSSFCell l4 = hssfRow.getCell(4);
								HSSFCell l5 = hssfRow.getCell(5);
								HSSFCell l6 = hssfRow.getCell(6);
								HSSFCell l7 = hssfRow.getCell(7);
								HSSFCell l8 = hssfRow.getCell(8);


								bnb.setL0(l0.getStringCellValue());
								bnb.setL1(l1.getStringCellValue());
								bnb.setL2(l2.getStringCellValue());
								bnb.setL3(l3.getStringCellValue());
								bnb.setL4(l4.getStringCellValue());
								bnb.setL5(l5.getStringCellValue());
								bnb.setL6(l6.getStringCellValue());
								bnb.setL7(l7.getStringCellValue());
								bnb.setL8(l8.getStringCellValue());
								bd.insert("kd", null, bnb);

							}

					



					}
				}





			}
		}

	}

	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			// ���ز������͵�ֵ
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			// ������ֵ���͵�ֵ
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			// �����ַ������͵�ֵ
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
}
