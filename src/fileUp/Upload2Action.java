/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileUp;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map; //其它包视具体情况引入  
import org.apache.struts2.ServletActionContext;  //key   
import javax.servlet.http.HttpServletRequest;  



import org.apache.struts2.ServletActionContext;

public class Upload2Action extends ActionSupport{
	//文件标题
	private String title;
	//上传文件
	private File upload;
	//上传文件名
	private String uploadFileName;
	//上传文件
	private File upload2;
	//上传文件名
	private String upload2FileName;
	//上传文件
	private File upload3;
	//上传文件名
	private String upload3FileName;
	//上传文件
	private File upload4;
	public File getUpload2() {
		return upload2;
	}
	public void setUpload2(File upload2) {
		this.upload2 = upload2;
	}
	public String getUpload2FileName() {
		return upload2FileName;
	}
	public void setUpload2FileName(String upload2FileName) {
		this.upload2FileName = upload2FileName;
	}
	public File getUpload3() {
		return upload3;
	}
	public void setUpload3(File upload3) {
		this.upload3 = upload3;
	}
	public String getUpload3FileName() {
		return upload3FileName;
	}
	public void setUpload3FileName(String upload3FileName) {
		this.upload3FileName = upload3FileName;
	}
	public File getUpload4() {
		return upload4;
	}
	public void setUpload4(File upload4) {
		this.upload4 = upload4;
	}
	public String getUpload4FileName() {
		return upload4FileName;
	}
	public void setUpload4FileName(String upload4FileName) {
		this.upload4FileName = upload4FileName;
	}
	//上传文件名
	private String upload4FileName;
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
			+ "/" + "1.jpg");
                //定义输出流对象
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer))>0){
			fos.write(buffer , 0 , len);
		}
		fos.close();
	
		
		if(getUpload2FileName()!=null)
		{
			fos = new FileOutputStream(getSavePath()
					+ "/" + "2.jpg");
		                //定义输出流对象
				 fis = new FileInputStream(getUpload2());
				 buffer = new byte[1024];
				 len = 0;
				while ((len = fis.read(buffer))>0){
					fos.write(buffer , 0 , len);
				}
				fos.close();
		}
		
		if(getUpload3FileName()!=null)
		{
			fos = new FileOutputStream(getSavePath()
					+ "/" + "3.jpg");
		                //定义输出流对象
				 fis = new FileInputStream(getUpload3());
				 buffer = new byte[1024];
				 len = 0;
				while ((len = fis.read(buffer))>0){
					fos.write(buffer , 0 , len);
				}
				fos.close();
		}
			
		if(getUpload4FileName()!=null)
		{
			fos = new FileOutputStream(getSavePath()
					+ "/" + "4.jpg");
		                //定义输出流对象
				 fis = new FileInputStream(getUpload4());
				 buffer = new byte[1024];
				 len = 0;
				while ((len = fis.read(buffer))>0){
					fos.write(buffer , 0 , len);
				}
				fos.close();
		}
			
		
		return SUCCESS;
	}
}

