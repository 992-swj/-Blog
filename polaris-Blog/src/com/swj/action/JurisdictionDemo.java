package com.swj.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.swj.bean.Jurisdiction;
import com.swj.service.UserInfoService;

@Controller("JurisdictionDemo")
public class JurisdictionDemo {
	@Autowired
	@Qualifier("userinfoservice")
	private UserInfoService infoService;
	
	public String demo(){
		map=new HashMap<String, Object>();
		map.put("identity", id);
		list=infoService.getidentity(map);
		return "success";
	}
	private Map<String, Object> map;
	
	private Integer id;
	
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	private List<Jurisdiction> list;
	
	public List<Jurisdiction> getList() {
		return list;
	}
	public void setList(List<Jurisdiction> list) {
		this.list = list;
	}
	public UserInfoService getInfoService() {
		return infoService;
	}
	public void setInfoService(UserInfoService infoService) {
		this.infoService = infoService;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
