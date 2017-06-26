package io.spring.workshop.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientSvcClient {
	
	@Autowired
	private RestTemplate restTemplate; 
		
	
		public PatientDetails[] allPatients(){
			
			return restTemplate.getForObject("http://localhost:8085/patients", PatientDetails[].class);
	}
}
