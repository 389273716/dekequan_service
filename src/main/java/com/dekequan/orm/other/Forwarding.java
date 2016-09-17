package com.dekequan.orm.other;
/**
 * 
 * <p>转发</p>
 * @author TTM
 * @date 2016年9月17日 下午11:25:26
 * @version 1.0
 */
public class Forwarding {

	private String createTime;			//创建时间
	
	private Integer userId;				//用户ID
	
	private Integer articleId;			//文章ID
	
	private String description;			//转发描述

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
