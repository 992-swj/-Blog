package com.swj.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.service.ArticleService;

@Controller("delarticle")
public class A_delArticle {
	@Autowired
	private ArticleService articleService;
	
	//„h³ýÎÄÕÂ
	public String del(){
		int delarticle = articleService.delarticle(articleid);
		return "success";
	}
	
	
	
	private Integer articleid;






	public Integer getArticleid() {
		return articleid;
	}






	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	
}
