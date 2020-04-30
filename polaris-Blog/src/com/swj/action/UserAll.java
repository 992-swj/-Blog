package com.swj.action;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.swj.bean.UserInfo;
import com.swj.service.UserInfoService;

@Controller("userAll")
public class UserAll {
	@Autowired
	private UserInfoService infoService;
	public String getUser(){
		infos=infoService.getUserInfoAll();
		return "success";
	}
	private List<UserInfo> infos;
	public List<UserInfo> getInfos() {
		return infos;
	}
	public void setInfos(List<UserInfo> infos) {
		this.infos = infos;
	}
	
}
