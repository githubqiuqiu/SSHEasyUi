package com.ht.model;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * @author Qiu
	 * 功能:用户bean
	 */
	
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private String pwd;
	private Integer rid;

	//多个用户对应一个角色  
	private Role role;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	//一对多(多对一)方法中 一定要重新tostring()方法 才能获取到级联查询的值
	public String toSting() {
		StringBuffer sb=new StringBuffer("[");  
        sb.append("id="+getId()+",");  
        sb.append("name="+getName()+",");  
        sb.append("sex="+getSex()+","); 
        sb.append("age="+getAge()+",");  
        sb.append("pwd="+getPwd()+","); 
        sb.append("rid="+getRid()+",");
        sb.append("role="+getRole()+",");  
        sb.append("]");  
        return sb.toString();  
	}
	
	
	public User(Integer id, String name, String sex, Integer age, String pwd, Integer rid, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.pwd = pwd;
		this.rid = rid;
		this.role = role;
	}

	public User() {
		super();
	}
	
}
