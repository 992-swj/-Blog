package com.swj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.swj.bean.Comment;

public interface CommentMapper {
	//��ѯ������Ϣ
	List<Comment> getComment(int articleid);
	//����
	int getPost_comments(Comment comment);
	//��ѯ����
	List<Comment> queryComment();
	//ɾ������
	int delcomment(@Param("commentid")int commentid);
	
}
