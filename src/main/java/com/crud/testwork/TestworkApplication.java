package com.crud.testwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.crud.controller.UserController;
import com.crud.repository.UserRepository;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackageClasses = UserController.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EntityScan(basePackages = { "com.crud.model" })
public class TestworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestworkApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean corsFilterRegistration() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CORSFilter());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}

}
