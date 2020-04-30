package com.swj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.service.CommentService;

@Controller("c_delcomment")
public class C_delComment {
	@Autowired
	private CommentService service;
	public String delcomment(){
		int delcomment = service.delcomment(commentid);
		if(delcomment>0){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("message", "É¾³ý³É¹¦");
			message="É¾³ý³É¹¦";
			return "success";
		}
		message="É¾³ýÊ§°Ü";
		return "error";
	}
	private Integer commentid;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public Integer getCommentid() {
		return commentid;
	}



	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}
	
}
