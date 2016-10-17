package com.dekequan.orm.permissions;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * <p>
 * 介绍 角色 - 模块
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月17日 上午1:26:34
 * @version 1.0
 */

@Table(name = "dk_role_module")
public class RoleModule {

	@Id
	private Integer rmId;			//流水号Id
	
	private Integer roleId;			//角色Id
	
	private Integer moduleId;		//模块Id

	public Integer getRmId() {
		return rmId;
	}

	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
}
