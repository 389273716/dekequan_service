package com.dekequan.orm.other;

/**
 * 
 * <p>
 * 售后服务信息
 * </p>
 * 
 * @author TTM
 * @date 2016年9月17日 下午11:18:43
 * @version 1.0
 */
public class AfterSales {

	private Integer afterSaleId;			
	
	private String createTime;			//创建时间
	
	private String content;				//内容
	
	private String description;			//描述
	
	private String img;					//图片
	
	private Integer status;				//状态

	public Integer getAfterSaleId() {
		return afterSaleId;
	}

	public void setAfterSaleId(Integer afterSaleId) {
		this.afterSaleId = afterSaleId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
