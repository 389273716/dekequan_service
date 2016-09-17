package com.dekequan.orm.other;

/**
 * 
 * <p>
 * 程序步骤
 * </p>
 * 
 * @author TTM
 * @date 2016年9月17日 下午11:31:40
 * @version 1.0
 */
public class ProgramStep {

	private Integer stepId;			//程序步骤ID
	
	private Integer sort;			//步骤顺序
	
	private String createTime;		//创建时间
	
	private Integer programId;		//程序ID
	
	private Integer menuId;			//菜谱ID
	
	private Integer userId;			//用户ID

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
