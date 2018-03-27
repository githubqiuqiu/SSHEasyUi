package com.ht.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

public class FileUtil {
	//定义文件上传的大小
	private static final int buffersize=1024*16;

	
	//获取文件内容类型的方法
	//name:文件名
	public String getcontentType(String name){
		//获得文件名的最后一个.的下标
		int index=name.lastIndexOf(".");
		return name.substring(index);
	}
	
	//读取文件的方法
	//src:要上传的文件(读取这个文件)  tosrc:上传到指定路径的文件(写入到指定位置的文件)
		public void copy(File src,File tosrc){
			try {
				//初始化输入输出流
				InputStream in=null;
				OutputStream out=null;
				
				try {
					//得到输入输出流
					in=new BufferedInputStream(new FileInputStream(src),buffersize);
					out=new BufferedOutputStream(new FileOutputStream(tosrc),buffersize);
					
					//定义一个字节数组
					byte [] b=new byte[buffersize];
					
					//循环读写文件
					while(in.read(b)>0){//只要文件没读完
						out.write(b);//写文件
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally{
					if(in!=null){
						in.close();
					}
					if(out!=null){
						out.close();
					}
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//执行多文件上传  (返回文件保存在upload里面的新名字)
		//[]myfile 上传的文件数组    []MyfileFileName 上传的文件数组名称  path 要上传到项目的文件夹
		public List uploadfiles(File []myfile,String[] MyfileFileName,String path) {
			List list=new ArrayList<>();
			
			//执行上传
			for (int i = 0; i < myfile.length; i++) {
				Random r=new Random();
				String strs=r.nextInt(1000000)+"";
				//得到一个新名称
				String newfilename=new Date().getTime()+strs+this.getcontentType(MyfileFileName[i]);
				//获取项目路径
				String url=ServletActionContext.getServletContext().getRealPath(path);
				//保存文件
				File newfile=new File(url+"/"+newfilename);
				//执行上传
				this.copy(myfile[i], newfile);
				list.add(newfilename);
			}
			return list;
		}
	
}
