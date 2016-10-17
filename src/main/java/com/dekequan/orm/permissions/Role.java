package com.dekequan.orm.permissions;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色
 * 
 * @author 唐太明
 * @date 2016年10月18日 上午12:51:03
 * @version 1.0
 */
@Table(name = "dk_role")
public class Role {

	@Id
	@Column(name = "role_id")
	private Integer roleId; // 角色主键

	private String name; // 角色名称

	private String createTime; // 创建时间

	private String updateTime; // 结束时间

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
