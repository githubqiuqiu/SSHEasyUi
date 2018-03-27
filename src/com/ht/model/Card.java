package com.ht.model;

public class Card {
	/**
	 * @author Qiu
	 * 功能:一对一关系  每个人对应一张身份证(使用唯一外键关联)
	 * 身份证的bean
	 */
	
	private Integer id;
	private String cardnum;
	
	private Person person;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	//自己重写tostring方法
		public String toSting() {
			StringBuffer sb=new StringBuffer("[");  
	        sb.append("id="+getId()+",");  
	        sb.append("cardnum="+getCardnum()+",");  
	        sb.append("person="+getPerson()+","); 
	        sb.append("]");  
	        return sb.toString();  
		}
	
	
}
