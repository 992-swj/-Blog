package com.swj.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.swj.bean.Jurisdiction;
import com.swj.bean.UserInfo;
import com.swj.service.UserInfoService;


@Controller("u_userlogin")
public class U_UserLogin {
	@Autowired
	private UserInfoService service;
	
	public String login(){
		map=new HashMap<String, Object>();
		UserInfo userInfoLogin =service.UserInfoLogin(loginid);
		if(userInfoLogin!=null && userInfoLogin.getLoginpwd().equals(loginpwd)){
			map.put("identity",userInfoLogin.getAdminis() );
			//获取到用户权限
			list=service.getidentity(map);
			HttpSession session = ServletActionContext.getRequest().getSession();
			Map<String, Object> map=(Map<String, Object>)ActionContext.getContext().get("request");
			session.setAttribute("jurisdiction", list);
			session.setAttribute("username", userInfoLogin.getUsername());
			session.setAttribute("userid", userInfoLogin.getUserid());
			map.put("userid", userInfoLogin.getUserid());
			return "success";
		}
		return "error";
	}
	private List<Jurisdiction> list;
	private Map<String, Object> map;
	private String loginid;
	private String loginpwd;
	
	
	public List<Jurisdiction> getList() {
		return list;
	}
	public void setList(List<Jurisdiction> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	
	
}
