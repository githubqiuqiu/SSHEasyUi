package com.ht.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ht.commons.BaseDaoImpl;
import com.ht.dao.IUserDao;
import com.ht.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{
	
	@Override
	public User seluser(String name) {
		String hql="from User where name=?";
		List<User> list=(List<User>) hibernateTemplate.find(hql,name);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<User> seluserwithpage(Integer currentpage, Integer pagesize) {
		//第一种分页查询
//		 List list = hibernateTemplate.executeFind(new HibernateCallback(){  
//             public Object doInHibernate(Session session)  
//                      throws HibernateException, SQLException {  
//                 List list2 = session.createQuery("from User")  
//                         .setFirstResult((currentpage-1)*pagesize)  
//                         .setMaxResults(pagesize)  
//                         .list();  
//
//                  return list2;  
//              }});
//     	 if(list!=null&&list.size()>0) {
//     		 return list;
//     	 }else {
//     		 return null; 
//     	 }
		
		  //第二种分页查询
	      session=hibernateTemplate.getSessionFactory().openSession();  
		  List<User> list=session.createQuery("from User").setFirstResult((currentpage-1)*pagesize).setMaxResults(pagesize).list();	
	      if(list!=null&&list.size()>0) {
	    	  return list;
	      }else {
	    	  return null;
	      }
	}

	@Override
	public Integer selcount() {
		Long count = (Long)hibernateTemplate.find("select count(*) from User").listIterator().next();
        return count.intValue();
	}

	
}
