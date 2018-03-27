package com.ht.dao;

import java.util.List;

import com.ht.commons.IBaseDao;
import com.ht.model.User;

public interface IUserDao extends IBaseDao<User>{
	//根据用户名  查询用户信息
	public User seluser(String name);
	
	//分页查询用户数据
	public List<User> seluserwithpage(Integer currentpage,Integer pagesize);
	
	//查询总数据条数
	public Integer selcount();
	
}
