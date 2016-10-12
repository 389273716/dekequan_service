package com.dekequan.orm.user;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>用户实体</p>
 * @author TTM
 * @date 2016年8月17日 下午11:40:02
 * @version 1.0
 */
@Table(name = "dk_user")
public class User {

	@Id
	@Column(name = "user_id")
	private Integer userId;				
	
	private String userName;			//用户名
	
	private String password;			//密码
	
	private String nickName;			//昵称
	
	private Integer rank;				//等级(外键)
	
	private Integer level;				//会员级别(外键)
	
	private String img;					//用户头像
	
	private String createTime;			//创建时间
	
	private String accessToken;			//第三方登录授权码
	
	private String dkToken;				//系统内部登录token
	
	private String expireTime;			//失效时间
	
	private Integer sex;				//性别

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getDkToken() {
		return dkToken;
	}

	public void setDkToken(String dkToken) {
		this.dkToken = dkToken;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
}
