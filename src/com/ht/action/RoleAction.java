package com.ht.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.ht.action.base.BaseAction;
import com.ht.model.Role;
import com.ht.util.JsonFormate;

@Controller
public class RoleAction extends BaseAction{
	
	/**
	 * @author Qiu
	 * 功能:角色action
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mapJson;
	private Role role;
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getMapJson() {
		return mapJson;
	}
	public void setMapJson(String mapJson) {
		this.mapJson = mapJson;
	}

	@Action(value="torole",results= {@Result(name="success",location="/WEB-INF/views/ht/role.jsp")})
	public String torole() {
		System.out.println("123");
		return SUCCESS;
	}
	
	
	@Action(value="selrole")
	public void selrole() throws IOException {
		List<Role> list=roleService.findAll();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		
		//转json
		formate.formatejson(list);
	
	}
	
	@Action(value="roleadd",results= {@Result(name="success",location="torole", type="redirect")})
	public String roleadd() {
		roleService.save(role);
		return SUCCESS;
	}
	
	@Action(value="selrolebyid",results= {@Result(name="success",location="/WEB-INF/views/include/editrole.jsp")})
	public String selrolebyrid() {
		role=roleService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="saveeditrole" ,results= {@Result(name="success",location="torole",type="redirect")})
	public String saveeditrole() {
		roleService.update(role);
		return SUCCESS;
	}
	
	@Action(value="delrole")
	public void delrole() {
		//先通过id得到整个role的bean
		role=roleService.findById(id);
		
		//删除整个bean
		roleService.delete(role);
	
	}
	
	@Action(value="selectrole")
	public void selectrole() throws IOException {
		List<Role> list=roleService.findAll();
//		for (Role role : list) {
//			System.out.println(role.toSting());
//		}
		
		//转json
		formate.formatejson(list);
	
		
	}
	
	
	
}
