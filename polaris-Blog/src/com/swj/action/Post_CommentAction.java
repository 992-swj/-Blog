package com.swj.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.swj.bean.Article;
import com.swj.bean.Comment;
import com.swj.service.CommentService;

@Controller("post_comment")
public class Post_CommentAction {
	@Autowired
	@Qualifier("commentServiceImpl")
	private CommentService commentService;
	public String post_comment(){
		Comment comment=new Comment();
		comment.setAuthorname(username);
		comment.setCommentcontent(postcomment);
		Date date=new Date();
		comment.setPubdate(date);
		Article article=new Article();
		article.setArticleid(articleid);
		comment.setArticle(article);
		int post_comments = commentService.getPost_comments(comment);
		return "success";
	}
	private String username;
	private String postcomment;
	private Integer articleid;
	
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public String getPostcomment() {
		return postcomment;
	}
	public void setPostcomment(String postcomment) {
		this.postcomment = postcomment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
}
