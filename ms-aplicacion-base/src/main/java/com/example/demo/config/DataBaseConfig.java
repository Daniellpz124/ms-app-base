package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataBaseConfig {
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.maximunPoolSize}")
	private int maximunPoolSize;
	
	@Value("${spring.datasource.minimumIdle}")
	private int minimumIdle;
	
	@Value("${spring.datasource.connectionTimeout}")
	private long connectionTimeout;
	
	@Value("${spring.datasource.idleTimeout}")
	private long idleTimeout;
	
	@Value("${spring.datasource.validationTimeout}")
	private long validationTimeOut;

	@Value("${spring.datasource.maxLifetime}")
	private long maxLifetime;
	
	@Bean(name = "infoDS")
	// @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Example SCOPE_PROTOTYPE
	public DataSource primaryDataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password); //Encription
		hikariConfig.setMaximumPoolSize(maximunPoolSize);
		hikariConfig.setMinimumIdle(minimumIdle);
		hikariConfig.setMaxLifetime(maxLifetime);
		hikariConfig.setConnectionTimeout(connectionTimeout);
		hikariConfig.setIdleTimeout(idleTimeout);
//		hikariConfig.setValidationTimeout(validationTimeOut);
		hikariConfig.setDriverClassName(driver);
		return new HikariDataSource(hikariConfig);
	}

}
