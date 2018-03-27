package com.ht.bean;

public class PersonCard {
	private Integer id;
	private String name;
	private String provicename;
	private String cityname;
	private String countyname;
	private String cardnum;
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
	public String getProvicename() {
		return provicename;
	}
	public void setProvicename(String provicename) {
		this.provicename = provicename;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCountyname() {
		return countyname;
	}
	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	@Override
	public String toString() {
		return "PersonCard [id=" + id + ", name=" + name + ", provicename=" + provicename + ", cityname=" + cityname
				+ ", countyname=" + countyname + ", cardnum=" + cardnum + "]";
	}
	public PersonCard(Integer id, String name, String provicename, String cityname, String countyname, String cardnum) {
		super();
		this.id = id;
		this.name = name;
		this.provicename = provicename;
		this.cityname = cityname;
		this.countyname = countyname;
		this.cardnum = cardnum;
	}
	public PersonCard() {
		super();
	}
	

}
