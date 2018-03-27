package com.ht.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.ht.action.base.BaseAction;

public class FiledownloadAction extends BaseAction{
	
	//从前台获取的文件名（包括文件格式，例如"test.jpg"）
    private String fileName;  

    //定义输入流，名称和xml里面的<param name="inputName">的名称一样
    private InputStream inputStream;  
    
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	//下载导出的数据(模板已经导入到upload中了  直接去upload里下载)
	 @Action(value="downloadexport",results= {@Result(name="success",type="stream",
			 params= {
					 "contentType", "application/octet-stream",   
					 "inputName","inputStream",
					 "contentDisposition","attachment;fileName=${fileName}",
					 "bufferSize","10240"
			 })})
	 		public String downloadexport() throws FileNotFoundException {
	 			fileName="exports.xls";
	 			 //获取需要下载的文件的相对文件夹路径
	 	        String basePath = ServletActionContext.getServletContext().getRealPath("/upload");

	 	        //根据文件夹路径和文件名，创建file文件
	 	        File file = new File(basePath,fileName); 

	 	        //用输入流读取文件
	 	        inputStream = new FileInputStream(file);    

		 		return SUCCESS;
	 		}
	 
	 
}