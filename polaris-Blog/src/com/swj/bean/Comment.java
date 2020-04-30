package com.swj.bean;

import java.util.Date;

public class Comment {
	private Integer commentid;
	private Article article;
	private String authorname;
	private String commentcontent;
	private Date pubdate;
	
	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", article=" + article
				+ ", authorname=" + authorname + ", commentcontent="
				+ commentcontent + ", pubdate=" + pubdate + "]";
	}

}
