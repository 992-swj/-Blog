package com.swj.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.swj.bean.Comment;
import com.swj.service.CommentService;

@Controller("comment")
public class CommentAllAction {
	@Autowired
	private CommentService commentService;
	
	public String comment(){
		list=commentService.queryComment();
		return "success";
	}
	private List<Comment> list;

	public List<Comment> getList() {
		return list;
	}
	public void setList(List<Comment> list) {
		this.list = list;
	}

	

	
}
