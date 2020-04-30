package com.swj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swj.bean.Article;
import com.swj.bean.Comment;
import com.swj.dao.ArticleMapper;
import com.swj.dao.CommentMapper;
import com.swj.service.ArticleService;
import com.swj.util.MakedownUtil;

@Transactional
@Service("articleserviceimpl")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Article> getArticeLimit(Map<String, Object> map) {
		int pageIndex = Integer.parseInt(map.get("pageIndex").toString());
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		// ��ʼҳ
		int start = (pageIndex - 1) * pageSize;
		map.put("pageIndex", start);
		map.put("pageSize", pageSize * pageIndex);

		// �ܼ�¼��
		int articeCount = getArticeCount(map);
		// ������ҳ��
		int SumIndex = (articeCount + pageSize - 1) / pageSize;
		// ��һҳ
		int prev = 0;
		if (pageIndex <= 1) {
			prev = 1;
		} else {
			prev = pageIndex - 1;
		}

		// ��һҳ
		int next = 0;
		if (pageIndex >= SumIndex) {
			next = SumIndex;
		} else {
			next = pageIndex + 1;
		}
		map.put("articeCount", articeCount);
		map.put("SumIndex", SumIndex);
		map.put("prev", prev);
		map.put("next", next);
		return articleMapper.getArticeLimit(map);
	}

	@Override
	public int getArticeCount(Map<String, Object> map) {
		return articleMapper.getArticeCount(map);
	}

	@Override
	public List<Article> Articelist(int userid) {
		// TODO Auto-generated method stub
		return articleMapper.Articelist(userid);
	}

	@Override
	public Article getArticeContent(int articleid) {
		// TODO Auto-generated method stub
		return articleMapper.getArticeContent(articleid);
	}

	@Override
	public int add_article(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.add_article(article);
	}

	@Override
	@Transactional
	public Article gethtmlArtice(int articleid){
		Article articeContent = articleMapper.getArticeContent(articleid);
		Article a=new Article();
		//BeanUtils.copyProperties(articeContent, a);
		BeanUtils.copyProperties(articeContent, a);
		String str = a.getArticlecontent();
		a.setArticlecontent(MakedownUtil.markedownToHtml(str));
		//���+1
		int getclicks = articleMapper.getclicks(articleid);
		System.out.println("�Ƿ����ɹ�"+getclicks);
		return a;
	}

	@Override
	public List<Article> getArticelist(Map<String, Object> map) {
		int pageIndex = Integer.parseInt(map.get("pageIndex").toString());
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		// ��ʼҳ
		int start = (pageIndex - 1) * pageSize;
		map.put("pageIndex", start);
		map.put("pageSize", pageSize * pageIndex);

		// �ܼ�¼��
		int articeCount = getArticeCount(map);
		// ������ҳ��
		int SumIndex = (articeCount + pageSize - 1) / pageSize;
		// ��һҳ
		int prev = 0;
		if (pageIndex <= 1) {
			prev = 1;
		} else {
			prev = pageIndex - 1;
		}

		// ��һҳ
		int next = 0;
		if (pageIndex >= SumIndex) {
			next = SumIndex;
		} else {
			next = pageIndex + 1;
		}
		map.put("articeCount", articeCount);
		map.put("SumIndex", SumIndex);
		map.put("prev", prev);
		map.put("next", next);
		return articleMapper.getArticelist(map);
	}

	@Override
	public List<Article> article_ids(int userid) {
		return articleMapper.article_ids(userid);
	}

	@Override
	public int getclicks(int articleid) {
		return articleMapper.getclicks(articleid);
	}
	
	/*
	 * ɾ������
	 * @see com.swj.service.ArticleService#delarticle(int)
	 */
	@Override
	public int delarticle(int articleid) {
		//��ȡ����������Ϣ
		List<Comment> list = commentMapper.getComment(articleid);
		if(list.size()>0){
			int[] commentsid=new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				//��ȡ���������е�����
				commentsid[i]=list.get(i).getCommentid();
			}
			//ɾ��
			if(commentsid.length>0){
				int article = articleMapper.delAllCommentWhereArticle(commentsid);
				System.out.println("ɾ���ɹ�����:"+article+"����"+list.size());
			}
		}
		return articleMapper.delarticle(articleid);
	}

	@Override
	public int delUserAllArticle(int[] articleid) {
		
		return articleMapper.delUserAllArticle(articleid);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}

	@Override
	public List<Article> TOP5() {
		// TODO Auto-generated method stub
		return articleMapper.TOP5();
	}
	/**
	 * ɾ�������µ���������
	 */
	@Override
	public int delAllCommentWhereArticle(int[] commentid) {
		return articleMapper.delAllCommentWhereArticle(commentid);
	}

	@Override
	public int delAllCommentWherearticles(int[] articles) {
		// TODO Auto-generated method stub
		return articleMapper.delAllCommentWherearticles(articles);
	}

	
}
