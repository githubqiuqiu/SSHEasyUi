package com.ht.model;

import java.util.HashSet;
import java.util.Set;

public class City {
	/**
	 * @author Qiu
	 * 功能:省县市三级联动  县/区
	 * 
	 */
	private Integer cid;
	private String cname;
	private Integer pid;
	
//	private Provice provice;
//	private Set<County> county=new HashSet<>();
//	
//	public Set<County> getCounty() {
//		return county;
//	}
//	public void setCounty(Set<County> county) {
//		this.county = county;
//	}
//	public Provice getProvice() {
//		return provice;
//	}
//	public void setProvice(Provice provice) {
//		this.provice = provice;
//	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "City [cid=" + cid + ", cname=" + cname + ", pid=" + pid + "]";
	}
	
	
	
	
}
