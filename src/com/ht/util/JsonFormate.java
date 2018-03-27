package com.ht.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

public class JsonFormate {
	private String mapJson;

	public String getMapJson() {
		return mapJson;
	}

	public void setMapJson(String mapJson) {
		this.mapJson = mapJson;
	}
	
	
	public void formatejson(Object object) throws IOException {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		
		mapJson = JSON.toJSONString(object);
		System.out.println("mapjson="+mapJson);
		PrintWriter pWriter = resp.getWriter();
		pWriter.print(mapJson);
		pWriter.flush();
		pWriter.close();
	}
	
}
