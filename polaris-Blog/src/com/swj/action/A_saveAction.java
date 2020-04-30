package com.swj.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.bean.Article;
import com.swj.bean.UserInfo;
import com.swj.service.ArticleService;

/*
 * ±£´æÎÄÕÂ
 */
@Controller("save")
public class A_saveAction {
	@Autowired
	private ArticleService service;

	public String save() {
		System.out.println("title"+title);
		System.out.println("concat"+concat);
		System.out.println("userid"+userid);
		Article article = new Article();
		UserInfo info=new UserInfo();
		info.setUserid(userid);
		article.setUserInfo(info);
		Date date=new Date();
		article.setPubdate(date);
		article.setTitle(title);
		article.setArticlecontent(concat);
		int add_article = service.add_article(article);
		return "success";
	}

	private Integer userid;
	private String title;
	private String concat;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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
