package com.dekequan.orm.other;

/**
 * 
 * <p>
 * 设备程序关系
 * </p>
 * 
 * @author TTM
 * @date 2016年9月17日 下午11:02:02
 * @version 1.0
 */
public class DiviceProgramRelation {

	private Integer deviceId;			//设备ID
	
	private Integer programId;			//程序ID
	
	private Integer userId;				//程序ID
	
	private String createTime;			//创建时间

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
