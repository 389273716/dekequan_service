package com.dekequan.orm.other;

/**
 * 
 * <p>
 * 设备
 * </p>
 * 
 * @author TTM
 * @date 2016年9月17日 下午10:51:48
 * @version 1.0
 */
public class Divice {

	private Integer devideId;

	private String deviceName; // 设备名

	private Integer status; // 设备状态

	private String deviceType; // 设备型号

	private String deviceSN; // 设备SN号

	private String img; // 设备图片

	private String createTime; // 创建时间

	public Integer getDevideId() {
		return devideId;
	}

	public void setDevideId(Integer devideId) {
		this.devideId = devideId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceSN() {
		return deviceSN;
	}

	public void setDeviceSN(String deviceSN) {
		this.deviceSN = deviceSN;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
