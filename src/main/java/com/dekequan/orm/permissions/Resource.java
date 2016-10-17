package com.dekequan.orm.permissions;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * <p>
 * 介绍 功能
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月17日 下午9:46:00
 * @version 1.0
 */
@Table(name = "dk_resource")
public class Resource {

	@Id
	@Column(name = "resource_id")
	private Integer resourceId;			//功能Id
	
	private String name;				//功能名称
	
	private String url;					//功能url
	
	private Integer parentId;			//功能父级id
	
	private String structure;			//菜单的层级结构
	
	private Integer sortNo;				//排序号
	
	private String moduleFlag;			//所属模块标记
	
	private String createTime;			//创建时间
	
	private String updateTime;			//修改时间

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public String getModuleFlag() {
		return moduleFlag;
	}

	public void setModuleFlag(String moduleFlag) {
		this.moduleFlag = moduleFlag;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
