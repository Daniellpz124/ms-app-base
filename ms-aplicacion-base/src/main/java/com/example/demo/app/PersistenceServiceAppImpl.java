package com.example.demo.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ManagerDataEntity;
import com.example.demo.dao.ManagerDataRepositoryDao;

@Service
public class PersistenceServiceAppImpl implements PersistenceServiceApp {

	@Autowired
	private ManagerDataRepositoryDao managerDataRepositoryDao;

	public ManagerDataEntity getManagerEntityById(Long id) {
		Optional<ManagerDataEntity> data = managerDataRepositoryDao.findById(id);
		return (data.isPresent() ? data.get() : null);
	}

	public String getManagerEntityByIdNative(Long id) {
		String data = managerDataRepositoryDao.getManagerEntityByIdNative(id);
		return (data != null ? data : null);
	}
}
