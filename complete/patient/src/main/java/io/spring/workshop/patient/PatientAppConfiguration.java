package io.spring.workshop.patient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PatientAppConfiguration {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
		
}