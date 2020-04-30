package com.swj.action;

import java.io.PrintWriter;


import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.bean.UserInfo;
import com.swj.service.UserInfoService;

@Controller("DN")
public class DNAction {
	@Autowired
	private UserInfoService infoService;

	public String DN() throws Exception {
		UserInfo dn = infoService.DN(username);
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (dn == null) {
			out.print("0");
			return "input";
		} 
		out.print("1");
		return null;
	}
	public String insert(){
		UserInfo info=new UserInfo();
		info.setLoginid(username);
		info.setUsername(name);
		info.setQQ(QQ);
		info.setLoginpwd(pwd2);
		info.setMail(EMIL);
		int register = infoService.register(info);
		System.out.println("ÊÇ·ñ×¢²á³É¹¦"+register);
		return "success";
	}
	private String name;
	private String username;
	private String pwd2;
	private String QQ;
	private String EMIL;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getEMIL() {
		return EMIL;
	}
	public void setEMIL(String eMIL) {
		EMIL = eMIL;
	}
	private String resuitid;

	public String getResuitid() {
		return resuitid;
	}

	public void setResuitid(String resuitid) {
		this.resuitid = resuitid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
