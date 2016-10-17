package com.dekequan.orm.permissions;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色 - 功能关系
 * 
 * @author 唐太明
 * @date 2016年10月17日 下午11:54:15
 * @version 1.0
 */
@Table(name = "dk_role_resource")
public class RoleResource {

	@Id
	@Column(name = "rr_id")
	private Integer rrId;		//主键Id
	
	private Integer roleId;		//角色Id
	
	private Integer resourceId;	//功能Id

	public Integer getRrId() {
		return rrId;
	}

	public void setRrId(Integer rrId) {
		this.rrId = rrId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	
}
