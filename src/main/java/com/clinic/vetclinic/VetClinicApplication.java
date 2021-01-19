package com.clinic.vetclinic;

import com.clinic.vetclinic.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@Import(SwaggerConfiguration.class)
@EnableJpaRepositories
public class VetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetClinicApplication.class, args);
	}

}
