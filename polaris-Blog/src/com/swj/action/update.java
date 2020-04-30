package com.swj.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.bean.Article;
import com.swj.service.ArticleService;


@Controller("update")
public class update {
	@Autowired
	private ArticleService articleService;
	public String updatearticle(){
		Date date=new Date();
		Article article=new Article();
		article.setTitle(title);
		article.setArticlecontent(concat);
		article.setPubdate(date);
		article.setArticleid(articleid);
		int update = articleService.update(article);
		return "success";
	}
	
	private Integer articleid;
	private String title;
	private String concat;
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getConcat() {
		return concat;
	}
	public void setConcat(String concat) {
		this.concat = concat;
	}
	
}
