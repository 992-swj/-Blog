package com.swj.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.bean.Article;
import com.swj.bean.Comment;
import com.swj.service.ArticleService;
import com.swj.service.CommentService;

/*
 * ����+����
 */
@Controller("contentaction")
public class ContentAction {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;
	
	public String connent(){
		//��ȡ��������
		articles=articleService.gethtmlArtice(articleid);
		//articles=articleService.getArticeContent(articleid);
		//��ȡ��������
		comments=commentService.getComment(articleid);
		return "success";
	}
	private Integer articleid;
	private Article articles;
	private List<Comment> comments;
	
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	
	public Article getArticles() {
		return articles;
	}
	public void setArticles(Article articles) {
		this.articles = articles;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
