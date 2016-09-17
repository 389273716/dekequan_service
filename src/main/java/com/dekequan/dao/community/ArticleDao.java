/**
 * 
 */
package com.dekequan.dao.community;

import java.util.List;

import com.dekequan.orm.community.Article;

/**
 * @author qzr
 * 圈子（个人动态）数据层接口
 */
public interface ArticleDao {
    int deleteByPrimaryKey(Integer aticleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer aticleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
    /**
     * 按分页条件分页查询圈子数据
     * @param pageSize             页号
     * @param pageNumber      每页条数
     * @return
     */
    List<Article> fetchList(int pageSize, int pageNumber);
	
}
