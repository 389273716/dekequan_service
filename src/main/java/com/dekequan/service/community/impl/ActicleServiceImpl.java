/**
 * 
 */
package com.dekequan.service.community.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dekequan.dao.community.ArticleDao;
import com.dekequan.orm.community.Article;
import com.dekequan.service.community.ArticleService;

/**
 * @author qzr
 * 圈子业务层接口实现类
 */

@Service
public class ActicleServiceImpl implements ArticleService {
	@Autowired
	ArticleDao articleDaoImpl;
	
	@Override
	public List<Article> fetchArticleList(int pageNumber, int pageSize) {
		return articleDaoImpl.fetchList(pageSize, pageNumber);
	}
	
}
