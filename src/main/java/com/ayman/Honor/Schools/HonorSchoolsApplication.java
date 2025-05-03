package com.ayman.Honor.Schools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories ("com.ayman.Honor.Schools.repository")
@EntityScan("com.ayman.Honor.Schools.model")
public class HonorSchoolsApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(HonorSchoolsApplication.class, args);
	}

}
