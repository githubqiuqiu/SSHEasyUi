package com.ht.action.base;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ModelDriven;
import com.ht.commons.PageBean;
import com.ht.service.PersonService;
import com.ht.service.RoleService;
import com.ht.service.UserService;
import com.ht.util.ExportExcel;
import com.ht.util.ImportExcel;
import com.ht.util.JsonFormate;
import com.opensymphony.xwork2.ActionSupport;


public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	@Autowired
	protected UserService userService;
	
	@Autowired
	protected RoleService roleService;

	@Autowired
	protected PersonService personService;
	
	//转json
	protected JsonFormate formate=new JsonFormate();
	//导出工具类
	protected ExportExcel exportexcel=new ExportExcel();
	//导入工具类
	protected ImportExcel importexcel=new ImportExcel();
	
	//模型对象 
	protected T model;
	
	@Override
	public T getModel() {
		return null;
	}

	protected PageBean pageBean = new PageBean();
	DetachedCriteria detachedCriteria = null;

	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}

	public void setPage(int page) {
		pageBean.setCurrentPage(page);
	}
	
	
	
}
