package com.ht.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.ht.action.base.BaseAction;
import com.ht.bean.UserRole;
import com.ht.model.User;
import com.ht.util.ExportExcel;
import com.ht.util.ImportExcel;

public class PoiAction extends BaseAction{
	 //从前台获取的文件名（包括文件格式，例如"test.jpg"）
    private String fileName;  

    //定义输入流，名称和xml里面的<param name="inputName">的名称一样
    private InputStream inputStream;  

    //定义好set和get方法，可自动获取匹配
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



    //导出excel表格   先要导入到一个位置  再去下载 (先导入upload再下载   导入逻辑和下载逻辑分开写)
	@Action(value="exports")
	public void export() {
		String sheetName ="用户列表";
		String titleName ="所有用户";
		String[] headers = {"编号","用户名","性别","年龄","密码","角色id","角色名"};
		
		List<User> list=userService.findAll();
		List<UserRole> lists=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			UserRole ur=new UserRole();
			ur.setId(list.get(i).getId());
			ur.setName(list.get(i).getName());
			ur.setSex(list.get(i).getSex());
			ur.setAge(list.get(i).getAge());
			ur.setPwd(list.get(i).getPwd());
			ur.setRid(list.get(i).getRid());
			ur.setRname(list.get(i).getRole().getRname());
			lists.add(ur);
		}
		
		//先把文件导入到upload文件夹下 (上传)
		Random r=new Random();
		String strs=r.nextInt(1000000)+".xls";
		//生成一个随机名
		fileName="exports.xls";	
				
		String resultUrl = ServletActionContext.getServletContext().getRealPath("/upload")+"/"+fileName;

		String pattern = "yyyy-MM-dd hh:mm:ss";
		
		//先把文件上传到upload中 (已经导出到upload文件夹里了)
		ExportExcel.exportExcel(sheetName, titleName, headers, lists, resultUrl, pattern);
		
	}
	
	public String importexcel() {
		
		return SUCCESS;
	}
	
	
}
