package com.ht.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ht.action.base.BaseAction;
import com.ht.model.City;
import com.ht.model.County;
import com.ht.model.Person;
import com.ht.model.Provice;

@Controller
public class IncludeAction extends BaseAction{
	private Person person;
	private Integer id;
	private List<Provice> provicelist;
	private List<City> citylist;
	private List<County> countylist;
	
	public List<Provice> getProvicelist() {
		return provicelist;
	}

	public void setProvicelist(List<Provice> provicelist) {
		this.provicelist = provicelist;
	}

	public List<City> getCitylist() {
		return citylist;
	}

	public void setCitylist(List<City> citylist) {
		this.citylist = citylist;
	}

	public List<County> getCountylist() {
		return countylist;
	}

	public void setCountylist(List<County> countylist) {
		this.countylist = countylist;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Action(value="toroleadd",results= {@Result(name="success",location="/WEB-INF/views/include/roleadd.jsp")})
	public String toroleadd() {
		return SUCCESS;
	}
	
	@Action(value="topersonadd",results= {@Result(name="success",location="/WEB-INF/views/include/personadd.jsp")})
	public String topersonadd() {
		return SUCCESS;
	}
	
	@Action(value="topersonedit",results= {@Result(name="success",location="/WEB-INF/views/include/personedit.jsp")})
	public String topersonedit() {
		//注意  虽然person表里有cardid这个字段  但是我们建表的时候没有建这个字段 所以取这个值的时候会为空  但是可以去另外一张表的主键代替
		person=personService.findId(id);
		//System.out.println(person.toSting());
		//System.out.println(person.getCard().toSting());
		//查询所有省
		provicelist=personService.findallprovice();
		
		//根据省的名字  查询该省的id
		//Integer pid=personService.selproviceid(person.getProvicename());
		//Integer cid=personService.selcityid(person.getCityname());
		
		//根据省id 查所有的市
		citylist=personService.findallcity(person.getProviceid());
		//根据市id 查询所有县
		countylist=personService.findallcounty(person.getCityid());
		return SUCCESS;
	}
	
}
