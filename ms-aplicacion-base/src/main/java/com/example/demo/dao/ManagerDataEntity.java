package com.example.demo.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the MANAGER_DATA database table.
 * 
 */
@Entity
@Table(name = "MANAGER_DATA")
public class ManagerDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_MANAGER")
	private long idManager;

	@Column(name = "AGE")
	private Long age;

	@Column(name = "NAME")
	private String name;

	public long getIdManager() {
		return this.idManager;
	}

	public void setIdManager(long idManager) {
		this.idManager = idManager;
	}

	public String getName() {
		return this.name;
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