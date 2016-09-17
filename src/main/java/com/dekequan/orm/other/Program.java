package com.dekequan.orm.other;

/**
 * 
 * <p>
 * 程序
 * </p>
 * 
 * @author TTM
 * @date 2016年9月17日 下午10:57:02
 * @version 1.0
 */
public class Program {

	private Integer programId;

	private String name; // 设备名称

	private String img; // 图片

	private String command; // 程序指令

	private String createTime; // 创建时间

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
