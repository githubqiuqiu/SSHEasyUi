package com.ht.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable{
	/**
	 * 
	 * @author Qiu
	 * 功能:角色bean
	 * 
	 */
	
	private Integer id;
	private String rname;
	private String code;
	private String introduce;
	
	//一个角色 对应多个用户  
	private Set<User> user=new HashSet<>();
	

	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Role(Integer id, String rname, String code, String introduce, Set<User> user) {
		super();
		this.id = id;
		this.rname = rname;
		this.code = code;
		this.introduce = introduce;
		this.user = user;
	}
	public Role() {
		super();
	}

	//一对多(多对一)方法中 一定要重新tostring()方法 才能获取到级联查询的值
	public String toSting() {
		StringBuffer sb=new StringBuffer("[");  
        sb.append("id="+getId()+",");  
        sb.append("rname="+getRname()+",");  
        sb.append("code="+getCode()+","); 
        sb.append("introduce="+getIntroduce()+",");  
        sb.append("]");  
        return sb.toString();  
	}
	
	
	
}
