package com.dekequan.orm.user;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 管理员用户
 * 
 * @author 唐太明
 * @date 2016年10月17日 下午11:18:11
 * @version 1.0
 */
@Table(name = "dk_admin_user")
public class AdminUser {

	@Id
	@Column(name = "admin_user_id")
	private Integer adminUserId;			//用户Id
	
	private String userName;				//登录用户名称
	
	private String password;				//登录密码
	
	private String name;					//姓名
	
	private Integer sex;					//性别 男 1 女 0
	
	private Integer isAdmin;				//是否 管理员 1 是 0 否
	
	private Integer isLock;					//是否锁定	1 是 0 否
	
	private Integer isDelete;				//是否删除 1 是 0 否
	
	private String createTime;				//创建时间
	
	private String updateTime;				//更新时间

	public Integer getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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
