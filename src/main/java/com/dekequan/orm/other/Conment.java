package com.dekequan.orm.other;

/**
 * 
 * <p>
 * 评论
 * </p>
 * 
 * @author TTM
 * @date 2016年9月17日 下午11:27:31
 * @version 1.0
 */
public class Conment {

	private Integer conmentId;
	
	private Integer parentConmentId;			//父评论id (-1 顶级楼层)
	
	private Integer type;						//评论类型(菜谱，话题)
	
	private String createTime;					//创建时间
	
	private Integer conemtnUserId;				//评论用户ID
	
	private String conmentUserName;				//用户名称
	
	private String conmentUserImage;			//用户头像
	
	private Integer toConmentUserId;			//回复评论用户Id
	
	private String toConmentUserName;			//回复评论用户名称
	
	private String toConmentImage;				//回复评论用户头像
	
	private Integer aticleId;					//文章id/菜谱id

	public Integer getConmentId() {
		return conmentId;
	}

	public void setConmentId(Integer conmentId) {
		this.conmentId = conmentId;
	}

	public Integer getParentConmentId() {
		return parentConmentId;
	}

	public void setParentConmentId(Integer parentConmentId) {
		this.parentConmentId = parentConmentId;
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

	public Integer getConemtnUserId() {
		return conemtnUserId;
	}

	public void setConemtnUserId(Integer conemtnUserId) {
		this.conemtnUserId = conemtnUserId;
	}

	public String getConmentUserName() {
		return conmentUserName;
	}

	public void setConmentUserName(String conmentUserName) {
		this.conmentUserName = conmentUserName;
	}

	public String getConmentUserImage() {
		return conmentUserImage;
	}

	public void setConmentUserImage(String conmentUserImage) {
		this.conmentUserImage = conmentUserImage;
	}

	public Integer getToConmentUserId() {
		return toConmentUserId;
	}

	public void setToConmentUserId(Integer toConmentUserId) {
		this.toConmentUserId = toConmentUserId;
	}

	public String getToConmentUserName() {
		return toConmentUserName;
	}

	public void setToConmentUserName(String toConmentUserName) {
		this.toConmentUserName = toConmentUserName;
	}

	public String getToConmentImage() {
		return toConmentImage;
	}

	public void setToConmentImage(String toConmentImage) {
		this.toConmentImage = toConmentImage;
	}

	public Integer getAticleId() {
		return aticleId;
	}

	public void setAticleId(Integer aticleId) {
		this.aticleId = aticleId;
	}
	
}
