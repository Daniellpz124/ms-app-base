package com.example.demo.app;

import com.example.demo.dao.ManagerDataEntity;

public interface PersistenceServiceApp {

	public ManagerDataEntity getManagerEntityById(Long id);
	public String getManagerEntityByIdNative(Long id);
}
