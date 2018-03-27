package com.ht.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.ht.action.base.BaseAction;
import com.ht.bean.UserRole;
import com.ht.model.User;
import com.ht.util.JsonFormate;
import com.ht.util.Md5Util;

@Controller
public class UserAction extends BaseAction<User>{
	/**
	 * @author Qiu
	 * 功能:用户action
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String mapJson;
	private Map map;
	private Integer id;
	private String uploadname;
	private PrintWriter pWriter;
	private Integer  ids[];
	
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public String getUploadname() {
		return uploadname;
	}
	public void setUploadname(String uploadname) {
		this.uploadname = uploadname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public String getMapJson() {
		return mapJson;
	}
	public void setMapJson(String mapJson) {
		this.mapJson = mapJson;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	@Action(value="tologin",results= {@Result(name="success",location="/WEB-INF/views/ht/htindex.jsp"),@Result(name="login",location="/login.jsp")})
	public String tologin() {

	
		Subject subject = SecurityUtils.getSubject();
		//加密
		Md5Util util=new Md5Util();
		
		try{
			//构造一个用户密码令牌
			AuthenticationToken token = new UsernamePasswordToken(user.getName(), user.getPwd());
			
			subject.login(token);
		}catch(UnknownAccountException e){
			//设置错误信息
			this.addActionError(this.getText("用户名不存在"));
			return "login";
		}catch(NullPointerException e) {
			this.addActionError(this.getText("请重新登入"));
			return "login";
		}
		catch(Exception e) {
			//设置错误信息
			this.addActionError(this.getText("用户账号密码不匹配"));
			return "login";
		}
		
		  //获取认证信息对象中存储的User对象
        User user = (User) subject.getPrincipal();
       // System.out.println(user.toSting());
        //System.out.println(user.getRole().toSting());
		return SUCCESS;
	}
	
	
	@Action(value="touser",results= {@Result(name="success",location="/WEB-INF/views/ht/user.jsp")})
	public String touser() {
		return SUCCESS;
	}
	
	@Action(value="seluser")
	public void seluser() throws IOException {
		HttpServletResponse res=ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		res.setCharacterEncoding("utf-8");
		
		//分页查询的参数
		Integer page =Integer.parseInt(req.getParameter("page")) ;
		Integer rows =Integer.parseInt(req.getParameter("rows"));
		
		//传到页面的list
		List<UserRole> lists=new ArrayList<>();
		
		//分页查询的总数据
		List<User> list=userService.seluserwithpage(page, rows);
		for (User user : list) {
			UserRole ur=new UserRole();
			ur.setId(user.getId());
			ur.setName(user.getName());
			ur.setSex(user.getSex());
			ur.setAge(user.getAge());
			ur.setPwd(user.getPwd());
			ur.setRid(user.getRid());
			ur.setRname(user.getRole().getRname());
			
			lists.add(ur);
			
		}
		
		//总数据条数
		int count=userService.selcount();
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		
		map=new HashMap<>();
		map.put("rows", lists);
		map.put("total", count);
		
		//转json格式
		formate.formatejson(map);
		
	}
	
	@Action(value="touseradd",results= {@Result(name="success",location="/WEB-INF/views/include/useradd.jsp")})
	public String touseradd() {
		return SUCCESS;
	}
	
	@Action(value="useradd",results= {@Result(name="success",location="touser",type="redirect")})
	public String useradd() {
		userService.save(user);
		return SUCCESS;
	}
	
	@Action(value="seluserbyid",results= {@Result(name="success",location="/WEB-INF/views/include/edituser.jsp")})
	public String seluserbyid() {
		user=userService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="edituser",results= {@Result(name="success",location="touser",type="redirect")})
	public String edituser() {
		userService.update(user);
		return SUCCESS;
	}
	
	@Action(value="deluser")
	public void deluser()  {
		//request and response
		HttpServletResponse resp = ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		resp.setCharacterEncoding("utf-8");
		
		if(id!=null) {//单选删除
			System.out.println(id);
			user=userService.findById(id);
			userService.delete(user);
		}
		else {//多选删除
			for (int i = 0; i < ids.length; i++) {
				System.out.println(ids[i]);
				user=userService.findById(ids[i]);
				userService.delete(user);
			}
			
		}
		
		try {
			pWriter = resp.getWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		pWriter.print("success");
		pWriter.flush();
		pWriter.close();
	}
	


}
	
	

