package com.swj.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.bean.Article;
import com.swj.service.ArticleService;

@Controller("chkArticle")
public class chkArticle {
	@Autowired
	private ArticleService articleService;
	
	
	public String chkArticles(){
		System.out.println(userid);
		list=articleService.article_ids(userid);
		return "success";
	}
	private Integer userid;
	private List<Article> list;


	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public List<Article> getList() {
		return list;
	}
	public void setList(List<Article> list) {
		this.list = list;
	}
	
}
