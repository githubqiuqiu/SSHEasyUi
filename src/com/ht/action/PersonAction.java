package com.ht.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.ht.action.base.BaseAction;
import com.ht.bean.CityBean;
import com.ht.bean.CountyBean;
import com.ht.bean.PersonCard;
import com.ht.model.City;
import com.ht.model.County;
import com.ht.model.Person;
import com.ht.model.Provice;

public class PersonAction extends BaseAction{
	/**
	 * @author Qiu
	 * 功能:个人身份信息action
	 */
	private Integer id;
	private Map map;
	private Person person;
	private PrintWriter pWriter;
	private Integer  ids[];
	
	
	
	public PrintWriter getpWriter() {
		return pWriter;
	}
	public void setpWriter(PrintWriter pWriter) {
		this.pWriter = pWriter;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}

	@Action(value="toperson",results= {@Result(name="success",location="/WEB-INF/views/ht/person.jsp")})
	public String toperson() {
		return SUCCESS;
	}
	
	@Action(value="selperson")
	public void selperson() throws IOException {
		List<Person> list=personService.findAll();
		List<PersonCard> lists=new ArrayList<>();
		//转到页面的list json
		for (Person person : list) {
			//根据省县市的id查询名字
			person.setProvicename(personService.findprovice(person.getProviceid()).getPname());
			person.setCityname(personService.findcity(person.getCityid()).getCname());
			person.setCountyname(personService.findcounty(person.getCountyid()).getName());
			PersonCard p=new PersonCard();
			p.setId(person.getId());
			p.setName(person.getName());
			p.setProvicename(person.getProvicename());
			p.setCityname(person.getCityname());
			p.setCountyname(person.getCountyname());
			p.setCardnum(person.getCard().getCardnum());
			lists.add(p);
			//System.out.println(person.toSting());
			//System.out.println(person.getCard().toSting());
		}
		
		//转json  传到页面
		map=new HashMap<>();
		map.put("rows", lists);
		map.put("total", lists.size());
		
		//转json格式
		formate.formatejson(map);
	}
	
	//查询所有的省
	@Action(value="selprovince")
	public void selprovince() throws IOException {
		List<Provice> list=personService.findallprovice();
		for (Provice provice : list) {
			System.out.println(provice);
		}
		formate.formatejson(list);
	}
	
	//查询所有的市/区
	@Action(value="selcity")
	public void selcity() throws IOException {
		List<City> list=personService.findallcity(id);
		List<CityBean> lists=new ArrayList<>();
		for (City city : list) {
			CityBean cb=new CityBean();
			cb.setCid(city.getCid());
			cb.setCname(city.getCname());
			lists.add(cb);
		}
		formate.formatejson(lists);
	}
	
	@Action(value="selcounty")
	public void selcounty() throws IOException {
		List<County> list=personService.findallcounty(id);
		List<CountyBean> lists=new ArrayList<>();
		for (County county : list) {
			CountyBean cb=new CountyBean();
			cb.setId(county.getId());
			cb.setName(county.getName());
			lists.add(cb);
		}
		formate.formatejson(lists);
	}
	
	@Action(value="personadd",results= {@Result(name="success",location="toperson",type="redirect")})
	public String personadd() {
		//person.setProvicename(personService.findprovice(Integer.valueOf(person.getProvicename())).getPname());
		//person.setCityname(personService.findcity(Integer.valueOf(person.getCityname())).getCname());
		//person.setCountyname(personService.findcounty(Integer.valueOf(person.getCountyname())).getName());
		personService.save(person);
		return SUCCESS;
	}
	
	@Action(value="personedit",results= {@Result(name="success",location="toperson",type="redirect")})
	public String personedit() {
		//System.out.println(person.toSting());
		personService.update(person);
		return SUCCESS;
	}
	
	@Action(value="delperson")
	public void delperson() {
		//request and response
		HttpServletResponse resp = ServletActionContext.getResponse();
		HttpServletRequest req=ServletActionContext.getRequest();
		if(id!=null) {//单选删除
			//System.out.println("shanchu id="+id);
			person=personService.findById(id);
			personService.delete(person);
		}else {//多选删除
			for (int i = 0; i < ids.length; i++) {
				//System.out.println("shanchu ids="+ids[i]);
				person=personService.findById(ids[i]);
				personService.delete(person);
			}
		}
		
		try {
			pWriter = resp.getWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		pWriter.print("success");
		pWriter.flush();
		pWriter.close();
		
	}
	
	
	
}
