package com.ht.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.commons.PageBean;
import com.ht.dao.IRoleDao;
import com.ht.model.Role;
import com.ht.service.RoleService;


@Transactional
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private IRoleDao roleDao;
	
	@Override
	public void save(Role entity) {
		roleDao.save(entity);
	}

	@Override
	public void delete(Role entity) {
		roleDao.delete(entity);
	}

	@Override
	public void update(Role entity) {
		roleDao.update(entity);
	}

	@Override
	public void saveOrUpdate(Role entity) {
		roleDao.saveOrUpdate(entity);
	}

	@Override
	public Role findById(Serializable id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public void executeUpdate(String queryName, Object... objects) {
		roleDao.executeUpdate(queryName, objects);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		roleDao.pageQuery(pageBean);
	}

	@Override
	public List<Role> findByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return roleDao.findByCriteria(detachedCriteria);
	}

}
