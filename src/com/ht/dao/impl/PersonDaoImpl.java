package com.ht.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.commons.BaseDaoImpl;
import com.ht.dao.IPersonDao;
import com.ht.model.City;
import com.ht.model.County;
import com.ht.model.Person;
import com.ht.model.Provice;

@Repository
public class PersonDaoImpl extends BaseDaoImpl<Person> implements IPersonDao{

	@Override
	public List<Provice> findallprovice() {
		return (List<Provice>) hibernateTemplate.find("from Provice");
	}

	@Override
	public List<City> findallcity(Integer id) {
		return (List<City>) hibernateTemplate.find("from City where pid="+id);
	}

	@Override
	public List<County> findallcounty(Integer id) {
		return (List<County>) hibernateTemplate.find("from County where cid="+id);
	}

	@Override
	public Provice findprovice(Integer id) {
		String hql="from Provice where pid="+id;
		List<Provice> list=(List<Provice>) hibernateTemplate.find(hql);
		if(list.size()>0&&list!=null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public City findcity(Integer id) {
		String hql="from City where cid="+id;
		List<City> list=(List<City>) hibernateTemplate.find(hql);
		if(list.size()>0&&list!=null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public County findcounty(Integer id) {
		String hql="from County where id="+id;
		List<County> list=(List<County>) hibernateTemplate.find(hql);
		if(list.size()>0&&list!=null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer selproviceid(String pname) {
		String hql="from Provice where pname="+pname;
		List<Provice> list=(List<Provice>) hibernateTemplate.find(hql);
		if(list.size()>0&&list!=null) {
			return list.get(0).getPid();
		}
		return null;
	}

	@Override
	public Integer selcityid(String cname) {	
		String hql="from City where cname="+cname;
		List<City> list=(List<City>) hibernateTemplate.find(hql);
		if(list.size()>0&&list!=null) {
			return list.get(0).getCid();
		}
		return null;
	}

	@Override
	public Person findId(Integer id) {
		// TODO Auto-generated method stub
		List<Person> list = (List<Person>) hibernateTemplate.find("from Person where id=?", id);
		return list.get(0);
	}

}
