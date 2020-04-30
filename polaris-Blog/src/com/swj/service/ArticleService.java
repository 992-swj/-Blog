package com.swj.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.swj.bean.Article;

public interface ArticleService {
	// 分页查询
	List<Article> getArticeLimit(Map<String, Object> map);

	// 查询总记录数
	int getArticeCount(Map<String, Object> map);

	// 根据id获取用户文章
	List<Article> Articelist(int userid);

	// 根据id查询文章内容
	Article getArticeContent(int articleid);

	// markedown转换之后根据id获取文章内容
	Article gethtmlArtice(int articleid);

	// 添加文章
	int add_article(Article article);

	// 正确获取文章
	List<Article> getArticelist(Map<String, Object> map);

	// 查询用户文章
	List<Article> article_ids(int userid);

	// 点击量
	int getclicks(@Param("articleid") int articleid);

	// 删除文章
	int delarticle(@Param("articleid") int articleid);

	// 删除用户所有文章
	int delUserAllArticle(@Param("articleid") int[] articleid);

	// 修改文章
	int update(Article article);

	// 热门获取点击率前5的文章
	List<Article> TOP5();

	// 删除文章，删除属于该文章的所有评论
	int delAllCommentWhereArticle(@Param("commentid") int[] commentid);

	// 通过文章id删除评论
	int delAllCommentWherearticles(@Param("articles") int[] articles);
}
