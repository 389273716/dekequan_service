package com.dekequan.orm.permissions;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * <p>
 * 介绍 用户 - 角色关系
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月17日 上午12:37:40
 * @version 1.0
 */
@Table(name = "dk_user_role")
public class UserRole {

	@Id
	private Integer urId;		//流水号id
	
	private Integer userId;		//用户id
	
	private Integer roleId;		//角色id

	public Integer getUrId() {
		return urId;
	}

	public void setUrId(Integer urId) {
		this.urId = urId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
