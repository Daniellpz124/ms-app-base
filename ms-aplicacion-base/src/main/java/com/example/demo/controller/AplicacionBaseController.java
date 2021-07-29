package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.app.ServicioApp;
import com.example.demo.vo.ManagerVO;


@RestController
@RequestMapping("/company/v1/app")
public class AplicacionBaseController {
	
	@Autowired
	private ServicioApp servicioApp;
	
	@PostMapping(value = "/detalle")
	public ResponseEntity<Object> obtenerDetalles(@Valid @RequestBody ManagerVO manager){
		ManagerVO response = servicioApp.obtenerDatos(manager.getId());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
