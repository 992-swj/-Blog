package com.swj.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.bean.UserInfo;
import com.swj.service.UserInfoService;

/*
 * 获取所有除管理员外的所有用户
 */
@Controller("articleaction")
public class ArticleAction {
	@Autowired
	private UserInfoService infoService;
	
	
	public String articelall(){
		list=infoService.getUserInfoAll();
		return "success";
	}
	
	
	public String delAllUser(){
		int delUser = infoService.delUser(userid);
		return "success";
	}
	private Integer userid;
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	private List<UserInfo> list;


	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}
	
}
