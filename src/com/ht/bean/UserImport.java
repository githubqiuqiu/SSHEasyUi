package com.ht.bean;

public class UserImport {
	/**
	 * @author Qiu
	 * 
	 * 功能:导入user表数据用的bean
	 * 
	 */
	

	private String name;
	private String sex;
	private Integer age;
	private String pwd;
	private Integer rid;

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
	@Override
	public String toString() {
		return "UserImport [name=" + name + ", sex=" + sex + ", age=" + age + ", pwd=" + pwd + ", rid=" + rid + "]";
	}
	public UserImport(String name, String sex, Integer age, String pwd, Integer rid) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.pwd = pwd;
		this.rid = rid;
	}
	public UserImport() {
		super();
	}
	
}
