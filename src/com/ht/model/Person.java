package com.ht.model;

public class Person {
	/**
	 * @author Qiu
	 * 功能:一对一关系  每个人对应一张身份证(使用唯一外键关联)
	 * 人的bean
	 */
	
	private Integer id;
	private String name;
	private String provicename;
	private String cityname;
	private String countyname;
	private Integer cardid;
	
	private Integer proviceid; 
	private Integer cityid;
	private Integer countyid;
	
	private Card card;

	
	
	


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






	public Integer getCardid() {
		return cardid;
	}






	public void setCardid(Integer cardid) {
		this.cardid = cardid;
	}






	public Integer getProviceid() {
		return proviceid;
	}






	public void setProviceid(Integer proviceid) {
		this.proviceid = proviceid;
	}






	public Integer getCityid() {
		return cityid;
	}






	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}






	public Integer getCountyid() {
		return countyid;
	}






	public void setCountyid(Integer countyid) {
		this.countyid = countyid;
	}






	public Card getCard() {
		return card;
	}






	public void setCard(Card card) {
		this.card = card;
	}






	//自己重写tostring方法(不要用系统生成的)
	public String toSting() {
		StringBuffer sb=new StringBuffer("[");  
        sb.append("id="+getId()+",");  
        sb.append("name="+getName()+",");  
        sb.append("proviceid="+getProviceid()+","); 
        sb.append("cityid="+getCityid()+",");  
        sb.append("countyid="+getCountyid()+","); 
        sb.append("card="+getCard().toSting()+",");  
        sb.append("]");  
        return sb.toString();  
	}

	
}
