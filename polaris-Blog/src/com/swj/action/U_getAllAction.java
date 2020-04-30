package com.swj.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.bean.Article;
import com.swj.bean.UserInfo;
import com.swj.service.ArticleService;
import com.swj.service.UserInfoService;
@Controller("u_getaction")
public class U_getAllAction {
	@Autowired
	private UserInfoService infoService;
	@Autowired
	private ArticleService articleService;

	public String getUser(){
		//infos=infoService.getUserInfoAll();
		map=new HashMap<String, Object>();
		if(pageIndex==null){pageIndex=1;}
		if(Specify!=null){pageIndex=Specify;}
		map.put("pageIndex", pageIndex);
		map.put("pageSize", 3);
		list=articleService.getArticeLimit(map);
		top5=articleService.TOP5();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		return "success";
	}

	private Integer pageIndex;
	private Integer pageSize;
	private Map<String, Object> map;
	private List<Article> list;
	private Integer Specify;
	private String message;
	private List<Article> top5;
	
	public List<Article> getTop5() {
		return top5;
	}

	public void setTop5(List<Article> top5) {
		this.top5 = top5;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getSpecify() {
		return Specify;
	}

	public void setSpecify(Integer specify) {
		Specify = specify;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public List<Article> getList() {
		return list;
	}

	public void setList(List<Article> list) {
		this.list = list;
	}

	public List<UserInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<UserInfo> infos) {
		this.infos = infos;
	}

	private List<UserInfo> infos;
	
	public UserInfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(UserInfoService infoService) {
		this.infoService = infoService;
	}

}
