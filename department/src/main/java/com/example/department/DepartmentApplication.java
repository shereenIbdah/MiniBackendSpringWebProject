package com.example.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Collections;

@EnableFeignClients
@SpringBootApplication(exclude = {SpringApplicationAdminJmxAutoConfiguration.class})
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DepartmentApplication.class);
		application.setAddCommandLineProperties(false);
		application.setDefaultProperties(Collections.singletonMap("spring.jmx.enabled", "false"));
		application.run(args);
	}

}
