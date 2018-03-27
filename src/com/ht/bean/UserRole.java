package com.ht.bean;

public class UserRole {
	/**
	 * @author Qiu
	 * 功能:查询用户信息表 的新建bean  
	 * 包含user表的所有字段和role表的rname
	 * 
	 */
	
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private String pwd;
	private Integer rid;
	private String rname;
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
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", pwd=" + pwd + ", rid="
				+ rid + ", rname=" + rname + "]";
	}
	public UserRole(Integer id, String name, String sex, Integer age, String pwd, Integer rid, String rname) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.pwd = pwd;
		this.rid = rid;
		this.rname = rname;
	}
	public UserRole() {
		super();
	}
	
	
}
