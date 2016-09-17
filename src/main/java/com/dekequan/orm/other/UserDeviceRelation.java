package com.dekequan.orm.other;

/**
 * 
 * <p>
 * 用户设备关系
 * </p>
 * 
 * @author TTM
 * @date 2016年9月17日 下午11:22:03
 * @version 1.0
 */
public class UserDeviceRelation {

	private Integer userId;			//用户ID
	
	private Integer deviceId;		//设备ID
	
	private String createTime;		//创建时间

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
