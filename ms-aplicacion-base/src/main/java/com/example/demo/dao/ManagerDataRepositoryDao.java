package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDataRepositoryDao extends CrudRepository<ManagerDataEntity, Long>{

	@Query(value = "SELECT NAME FROM MANAGER_DATA WHERE ID_MANAGER = :id", nativeQuery=true)
	 public String getManagerEntityByIdNative(Long id);
}
