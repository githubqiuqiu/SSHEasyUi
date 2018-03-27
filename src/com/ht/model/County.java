package com.ht.model;

public class County {
	/**
	 * @author Qiu
	 * 功能:省县市 三级联动  城市
	 * 
	 */
	private Integer id;
	private String name;
	private Integer cid;
	
//	private City city;
//	
//	public City getCity() {
//		return city;
//	}
//	public void setCity(City city) {
//		this.city = city;
//	}
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
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
}
