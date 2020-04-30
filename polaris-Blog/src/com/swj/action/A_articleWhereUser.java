package com.swj.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.swj.bean.Article;
import com.swj.service.ArticleService;

@Controller("A_articleWhereUser")
public class A_articleWhereUser {
	@Autowired
	@Qualifier("articleserviceimpl")
	private ArticleService service;

	public String list() {
		if(Specify!=null){pageIndex=Specify;}
		if (pageIndex == null) {pageIndex = 1;}
		map = new HashMap<String, Object>();
		map.put("pageIndex", pageIndex);
		map.put("pageSize", 3);
		map.put("userid", userid);
		//list = service.getArticeLimit(map);
		list=service.getArticelist(map);
		return "success";
	}
	private Integer Specify;
	private Integer pageIndex;
	private Integer pageSize;
	private Map<String, Object> map;

	public Integer getSpecify() {
		return Specify;
	}

	public void setSpecify(Integer specify) {
		Specify = specify;
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

	private List<Article> list;

	public List<Article> getList() {
		return list;
	}

	public void setList(List<Article> list) {
		this.list = list;
	}

	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}



}
