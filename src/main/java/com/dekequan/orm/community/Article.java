/**
 * 
 */
package com.dekequan.orm.community;

/**
 * <p>文章实体</p>
 * @author qzr
 * @date 2016年9月14日
 * @version 1.0
 */
public class Article {
	private Integer aticleId;       //主键
	
	private String createTime;    //创建时间
	
	private String title;               //文章标题
	
	private String content;         //内容
	
	private String mainImage;   //图片标题
	
	private Integer type;            //文章类型
	
	private Integer creator;        //创建人
	
	private Integer viewCount;   //浏览量
	
	private Integer likeCount;    //点赞量
	
	private Integer level;            //级别，用于排序
	
	private Integer collectCount;//收藏数
	
	private Integer isShow;        //数据是否显示（1：是，0：否）
	
	private String likes;             //点赞人(1,2,3) 存储用户id 用逗号隔开

	public Integer getAticleId() {
		return aticleId;
	}

	public void setAticleId(Integer aticleId) {
		this.aticleId = aticleId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}
}
