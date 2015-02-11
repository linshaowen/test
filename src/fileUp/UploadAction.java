/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileUp;
import com.excel.SaveData2DB;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map; //其它包视具体情况引入  
import org.apache.struts2.ServletActionContext;  //key   
import javax.servlet.http.HttpServletRequest;  



import org.apache.struts2.ServletActionContext;

public class UploadAction extends ActionSupport{
	//文件标题
	private String title;
	//上传文件
	private File upload;
	//上传文件名
	private String uploadFileName;
	//获取在struts.xml文件中配置路径
	private String savePath;
	public void setSavePath(String value){
		this.savePath = value;
	}
	private String getSavePath() throws Exception {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setTitle(String title) {
		this.title = title; 
	}
	public String getTitle(){
		return this.title; 
	}
	public void setUpload(File upload){
		this.upload = upload; 
	}
	public File getUpload() {
		return this.upload; 
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName; 
	}
	public String getUploadFileName(){
		return this.uploadFileName; 
	}
	public String execute() throws Exception{
		//以服务器的文件保存地址和原文件名建立上传文件输出流
		FileOutputStream fos = new FileOutputStream(getSavePath()
			+ "/" + getUploadFileName());
                //定义输出流对象
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer))>0){
			fos.write(buffer , 0 , len);
		}
		fos.close();
		//从excel写入数据库
		SaveData2DB saveData2DB = new SaveData2DB();
		saveData2DB.save(getSavePath()
				+ "/" + getUploadFileName(),this.title);
		System.out.println("success-end");
//		HttpServletRequest request = ServletActionContext.getRequest();  
//		String type = (String)request.getAttribute("type");    
//		System.out.println(this.title);
		
		return SUCCESS;
	}
}

