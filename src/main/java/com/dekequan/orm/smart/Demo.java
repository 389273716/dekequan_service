package com.dekequan.orm.smart;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dk_demo")
public class Demo {

	@Id
	@Column(name = "demo_id")
	private Integer demoId;
	
	private String name;
	
	private Integer age;

	public Integer getDemoId() {
		return demoId;
	}

	public void setDemoId(Integer demoId) {
		this.demoId = demoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
