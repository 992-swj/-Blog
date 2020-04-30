package com.swj.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
@Controller("exit")
public class exitAction {
	public String exit(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "success";
	}
}
