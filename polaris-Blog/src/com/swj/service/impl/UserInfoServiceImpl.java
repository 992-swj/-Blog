package com.swj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swj.bean.Article;
import com.swj.bean.Jurisdiction;
import com.swj.bean.UserInfo;
import com.swj.dao.ArticleMapper;
import com.swj.dao.CommentMapper;
import com.swj.dao.UserInfoMapper;
import com.swj.service.UserInfoService;

@Service("userinfoservice")
@Transactional
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoMapper infoMapper;
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<UserInfo> getUserInfoAll() {
		return infoMapper.getUserInfoAll();
	}

	@Override
	public UserInfo UserInfoLogin(String loginid) {
		
		return infoMapper.UserInfoLogin(loginid);
	}

	@Override
	public List<Jurisdiction> getidentity(Map<String, Object> map) {
		return infoMapper.getidentity(map);
	}

	@Override
	public List<UserInfo> getUserWhereNoAdmin() {
		return infoMapper.getUserWhereNoAdmin();
	}

	@Override
	public int delUser(int userid) {
		//获取当前用户所有文章
		List<Article> ids = articleMapper.article_ids(userid);
		
		if(ids.size()>0){
			//声明数组
			int[] articles=new int[ids.size()];
			//int[] comments=new int[ids.size()];
			//循环把所有文章id给数组
			for (int i = 0; i < ids.size(); i++) {
				articles[i]=ids.get(i).getArticleid();
			}
			//articleMapper.delAllCommentWhereArticle(comments);
			articleMapper.delAllCommentWherearticles(articles);
			//刪除文章
			int article = articleMapper.delUserAllArticle(articles);
		}
		return infoMapper.delUser(userid);
	}

	@Override
	public UserInfo DN(String loginid) {
		return infoMapper.DN(loginid);
	}

	@Override
	public int register(UserInfo info) {
		return infoMapper.register(info);
	}
}
