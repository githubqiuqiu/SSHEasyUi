package com.ht.model;

import java.util.HashSet;
import java.util.Set;

public class Provice {
	/**
	 * @author Qiu
	 * 功能:省县市 三级联动  省
	 * 
	 */
	private Integer pid;
	private String pname;
//	private Set<City> city=new HashSet<>();
//	
//	public Set<City> getCity() {
//		return city;
//	}
//	public void setCity(Set<City> city) {
//		this.city = city;
//	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
}
