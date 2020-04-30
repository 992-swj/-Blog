package com.swj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swj.bean.Comment;
import com.swj.dao.CommentMapper;
import com.swj.service.CommentService;

@Service("commentServiceImpl")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Comment> getComment(int articleid) {
		return commentMapper.getComment(articleid);
	}

	@Override
	public int getPost_comments(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.getPost_comments(comment);
	}

	@Override
	public List<Comment> queryComment() {
		return commentMapper.queryComment();
	}

	@Override
	public int delcomment(int commentid) {
		return commentMapper.delcomment(commentid);
	}
}
