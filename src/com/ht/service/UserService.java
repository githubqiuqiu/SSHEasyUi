package com.ht.service;

import java.util.List;

import com.ht.commons.IBaseService;
import com.ht.model.User;

public interface UserService extends IBaseService<User>{
	//根据用户名  查询用户信息
	public User seluser(String name);
	
	//分页查询用户数据
	public List<User> seluserwithpage(Integer currentpage,Integer pagesize);
	//查询总数据条数
	public Integer selcount();
}
