package com.dekequan.orm.permissions;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * <p>
 * 介绍:模块
 * </p>
 * 
 * @author 唐太明
 * @date 2016年10月16日 下午5:39:10
 * @version 1.0
 */
@Table(name = "dk_module")
public class Module {

	@Id
	@Column(name = "module_id")
	private Integer moduleId;					//模块id

	private String name;						//模块名称

	private String flag;						//模块标记

	private String url;							//模块访问url

	private Integer sortNo;						//排序号
	
	private String createTime;					//创建时间

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
