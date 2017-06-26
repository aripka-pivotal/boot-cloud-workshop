package io.spring.workshop.patientsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientSvcApplication.class, args);
	}
}
