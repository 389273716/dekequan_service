/**
 * 
 */
package com.dekequan.service.community;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dekequan.orm.community.Article;

/**
 * @author qzr
 * 圈子的业务层接口
 */
@Service
public interface ArticleService {
	public abstract List<Article> fetchArticleList(int pageNumber, int pageSize);
}
