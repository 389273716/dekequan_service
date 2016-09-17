package com.dekequan.orm.other;

/**
 * 
 * <p>
 * 用户收藏
 * </p>
 * 
 * @author TTM
 * @date 2016年9月17日 下午11:14:10
 * @version 1.0
 */
public class UserCollect {

	private Integer userId;			//用户ID
	
	private Integer collectId;		//被收藏内容的主键
	
	private Integer type;			//类型（从1开始定义）
	
	private String createTime;		//创建时间

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCollectId() {
		return collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
