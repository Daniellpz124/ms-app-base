package com.example.demo.config;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfigurations {

	@Bean(name="namedFile")
	public File namedFile() {
		File namedFile = new File ("C:\\Users\\Danie\\Desktop\\FileExample.txt");
		return namedFile;
	}
}
