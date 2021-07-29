package com.example.demo.app;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ManagerDataEntity;
import com.example.demo.vo.ManagerVO;

@Service
public class ServicioAppImpl implements ServicioApp{

	@Autowired
	private PersistenceServiceApp persistenceServiceApp;
	
	@Resource
	private File defaultFile;
	
	
	@Override
	public ManagerVO obtenerDatos(Long id) {
		ManagerDataEntity managerDataEntity = persistenceServiceApp.getManagerEntityById(id);
		
		String name = persistenceServiceApp.getManagerEntityByIdNative(id);
		System.out.println(name);
		
		ManagerVO response = new ManagerVO();
		if(managerDataEntity!=null) {
			response.setAge(managerDataEntity.getAge()!=null ? managerDataEntity.getAge():null);
			response.setId(managerDataEntity.getIdManager());
			response.setName(managerDataEntity !=null ? managerDataEntity.getName() : null );
		}
		return response;
	}

}
