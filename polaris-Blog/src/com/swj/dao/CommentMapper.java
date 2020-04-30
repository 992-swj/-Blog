package com.swj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.swj.bean.Comment;

public interface CommentMapper {
	//查询评论信息
	List<Comment> getComment(int articleid);
	//评论
	int getPost_comments(Comment comment);
	//查询评论
	List<Comment> queryComment();
	//删除评论
	int delcomment(@Param("commentid")int commentid);
	
}
