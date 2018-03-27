package com.ht.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.commons.PageBean;
import com.ht.dao.IUserDao;
import com.ht.model.User;
import com.ht.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public void save(User entity) {
		userDao.save(entity);
	}

	@Override
	public void delete(User entity) {
		userDao.delete(entity);
	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
	}

	@Override
	public void saveOrUpdate(User entity) {
		userDao.saveOrUpdate(entity);
	}

	@Override
	public User findById(Serializable id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void executeUpdate(String queryName, Object... objects) {
		userDao.executeUpdate(queryName, objects);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}

	@Override
	public List<User> findByCriteria(DetachedCriteria detachedCriteria) {
		return userDao.findByCriteria(detachedCriteria);
	}

	@Override
	public User seluser(String name) {
		return userDao.seluser(name);
	}

	@Override
	public List<User> seluserwithpage(Integer currentpage, Integer pagesize) {
		// TODO Auto-generated method stub
		return userDao.seluserwithpage(currentpage, pagesize);
	}

	@Override
	public Integer selcount() {
		return userDao.selcount();
	}

}
