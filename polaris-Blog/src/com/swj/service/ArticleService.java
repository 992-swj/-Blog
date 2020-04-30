package com.swj.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.swj.bean.Article;

public interface ArticleService {
	// ��ҳ��ѯ
	List<Article> getArticeLimit(Map<String, Object> map);

	// ��ѯ�ܼ�¼��
	int getArticeCount(Map<String, Object> map);

	// ����id��ȡ�û�����
	List<Article> Articelist(int userid);

	// ����id��ѯ��������
	Article getArticeContent(int articleid);

	// markedownת��֮�����id��ȡ��������
	Article gethtmlArtice(int articleid);

	// �������
	int add_article(Article article);

	// ��ȷ��ȡ����
	List<Article> getArticelist(Map<String, Object> map);

	// ��ѯ�û�����
	List<Article> article_ids(int userid);

	// �����
	int getclicks(@Param("articleid") int articleid);

	// ɾ������
	int delarticle(@Param("articleid") int articleid);

	// ɾ���û���������
	int delUserAllArticle(@Param("articleid") int[] articleid);

	// �޸�����
	int update(Article article);

	// ���Ż�ȡ�����ǰ5������
	List<Article> TOP5();

	// ɾ�����£�ɾ�����ڸ����µ���������
	int delAllCommentWhereArticle(@Param("commentid") int[] commentid);

	// ͨ������idɾ������
	int delAllCommentWherearticles(@Param("articles") int[] articles);
}
