package com.ht.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;
import com.ht.action.base.BaseAction;
import com.ht.bean.UserImport;
import com.ht.model.User;
import com.ht.util.ExportExcel;
import com.ht.util.FileUtil;
import com.ht.util.ImportExcel;


@Controller
public class FileuploadAction extends BaseAction{
	//给新文件定义一个新名字
	private String newfilename;
	
	//文件上传需要下面三个属性
	//文件数组(页面传来的文件)
	private File []myfile;
		
	//文件内容
	private String[] myfileContentType;
	
	//文件名
	private String [] myfileFileName;
	
	private FileUtil fileutil=new FileUtil();
	
	public String getNewfilename() {
		return newfilename;
	}
	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}
	public File[] getMyfile() {
		return myfile;
	}

	public void setMyfile(File[] myfile) {
		this.myfile = myfile;
	}
	public String[] getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(String[] myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String[] getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String[] myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	
	//上传模板
	@Action(value="uploadmoban",results={@Result(name="success",location="touser",type="redirect")})
	public String uploadmoban() {
		//执行上传
//		for (int i = 0; i < myfile.length; i++) {
//			Random r=new Random();
//			String strs=r.nextInt(1000000)+"";
//			//得到一个新名称
//			newfilename=new Date().getTime()+strs+fileutil.getcontentType(myfileFileName[i]);
//			//获取项目路径
//			String url=ServletActionContext.getServletContext().getRealPath("/upload");
//			//保存文件
//			File newfile=new File(url+"/"+newfilename);
//			//执行上传
//			fileutil.copy(myfile[i], newfile);
//		}
		//工具类
		fileutil.uploadfiles(myfile, myfileFileName, "/upload");
		return SUCCESS;
	}
	
	//导入数据
	@Action(value="importexcel",results= {@Result(name="success",location="touser",type="redirect")})
	public String importexcel() {
		//返回生成的新文件的名称
		List list=fileutil.uploadfiles(myfile, myfileFileName, "/upload");
		
		String path=ServletActionContext.getServletContext().getRealPath("/upload");
		//导入excel表的数据
		int startrow=2;//从获取数据的那一行开始取
		int endrow=0;
		
		try {
			List<UserImport> lists=(List<UserImport>)importexcel.importExcel(path+"/"+list.get(0), startrow, endrow, UserImport.class);
			for (UserImport user : lists) {
				User u=new User();
				u.setName(user.getName());
				u.setSex(user.getSex());
				u.setAge(user.getAge());
				u.setPwd(user.getPwd());
				u.setRid(user.getRid());
				System.out.println(u.toSting());
				//保存数据
				//userService.save(u);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file=new File(path+"/"+list.get(0));
		file.delete();
		return SUCCESS;
	}
	
	
	
}
