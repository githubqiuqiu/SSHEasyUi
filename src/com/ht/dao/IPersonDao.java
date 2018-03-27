package com.ht.dao;

import java.util.List;

import com.ht.commons.IBaseDao;
import com.ht.model.City;
import com.ht.model.County;
import com.ht.model.Person;
import com.ht.model.Provice;

public interface IPersonDao extends IBaseDao<Person>{
	
	//查询省
	public List<Provice> findallprovice();
	
	//查询市/区
	public List<City> findallcity(Integer id);
	
	//查询县城
	public List<County> findallcounty(Integer id);
	
	//根据id查询省的名字
	public Provice findprovice(Integer id);
	
	//根据id查询市/区的名字
	public City findcity(Integer id);
	
	//根据id查询市/区的名字
	public County findcounty(Integer id);
	
	//根据省的名字查询省的id
	public Integer selproviceid(String pname);
	
	//根据市/区的名字查询市/区的id
	public Integer selcityid(String cname);
		
	public Person findId(Integer id);
	
}
