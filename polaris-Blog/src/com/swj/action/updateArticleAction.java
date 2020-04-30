package com.swj.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.bean.Article;
import com.swj.service.ArticleService;

@Controller("updatewenzhang")
public class updateArticleAction {
	@Autowired
	private ArticleService articleService;
	public String udpdate(){
		article=articleService.getArticeContent(articleid);
		return "success";
	}
	
	private Integer articleid;
	private Article article;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	
	
	
}
