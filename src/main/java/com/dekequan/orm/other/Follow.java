package com.dekequan.orm.other;

/**
 * 
 * <p>
 * 关注
 * </p>
 * 
 * @author TTM
 * @date 2016年9月17日 下午11:17:04
 * @version 1.0
 */
public class Follow {

	private Integer followId;			//关注人ID
	
	private Integer followedId;			//被关注人ID
	
	private Integer createTime;			//创建时间

	public Integer getFollowId() {
		return followId;
	}

	public void setFollowId(Integer followId) {
		this.followId = followId;
	}

	public Integer getFollowedId() {
		return followedId;
	}

	public void setFollowedId(Integer followedId) {
		this.followedId = followedId;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	
}
