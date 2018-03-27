package com.ht.commons;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IBaseService<T> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public void saveOrUpdate(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	//提供通用修改方法
	public void executeUpdate(String queryName,Object ...objects);
	public void pageQuery(PageBean pageBean);
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);
}
