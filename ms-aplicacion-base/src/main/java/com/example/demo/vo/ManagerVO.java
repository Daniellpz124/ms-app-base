package com.example.demo.vo;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;


public class ManagerVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "name.notempty")
	private String name;
	private Long age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

}
