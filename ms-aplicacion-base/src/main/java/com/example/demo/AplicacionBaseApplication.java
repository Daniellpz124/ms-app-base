package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.CharacterEncodingFilter;

import io.javabrains.springsecurityjwt.MyUserDetailsService;
import io.javabrains.springsecurityjwt.util.JwtUtil;

@SpringBootApplication
public class AplicacionBaseApplication {
	
	@Bean 
	public MyUserDetailsService getMyUserDetailsService() {
		MyUserDetailsService myUserDetailsService = new MyUserDetailsService();
		return myUserDetailsService;
	}
	
	@Bean 
	public JwtUtil getJwtUtil() {
		JwtUtil jwtUtil = new JwtUtil();
		return jwtUtil;
	}
	
	@Bean
	public CharacterEncodingFilter characterFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		return messageSource;
		
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(AplicacionBaseApplication.class, args);
	}

}
