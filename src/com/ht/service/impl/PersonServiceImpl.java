package com.ht.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.commons.PageBean;
import com.ht.dao.IPersonDao;
import com.ht.model.City;
import com.ht.model.County;
import com.ht.model.Person;
import com.ht.model.Provice;
import com.ht.service.PersonService;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private IPersonDao personDao;
	
	@Override
	public void save(Person entity) {
		personDao.save(entity);
	}

	@Override
	public void delete(Person entity) {
		personDao.delete(entity);
	}

	@Override
	public void update(Person entity) {
		personDao.update(entity);
	}

	@Override
	public void saveOrUpdate(Person entity) {
		personDao.saveOrUpdate(entity);
	}

	@Override
	public Person findById(Serializable id) {
		return personDao.findById(id);
	}

	@Override
	public List<Person> findAll() {
		return personDao.findAll();
	}

	@Override
	public void executeUpdate(String queryName, Object... objects) {
		personDao.executeUpdate(queryName, objects);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		personDao.pageQuery(pageBean);
	}

	@Override
	public List<Person> findByCriteria(DetachedCriteria detachedCriteria) {
		return personDao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<Provice> findallprovice() {
		return personDao.findallprovice();
	}

	@Override
	public List<City> findallcity(Integer id) {
		return personDao.findallcity(id);
	}

	@Override
	public List<County> findallcounty(Integer id) {
		return personDao.findallcounty(id);
	}

	@Override
	public Provice findprovice(Integer id) {
		return personDao.findprovice(id);
	}

	@Override
	public City findcity(Integer id) {
		return personDao.findcity(id);
	}

	@Override
	public County findcounty(Integer id) {
		return personDao.findcounty(id);
	}

	@Override
	public Integer selproviceid(String pname) {
		// TODO Auto-generated method stub
		return personDao.selproviceid(pname);
	}

	@Override
	public Integer selcityid(String cname) {
		// TODO Auto-generated method stub
		return personDao.selcityid(cname);
	}

	@Override
	public Person findId(Integer id) {
		// TODO Auto-generated method stub
		return personDao.findId(id);
	}

}
