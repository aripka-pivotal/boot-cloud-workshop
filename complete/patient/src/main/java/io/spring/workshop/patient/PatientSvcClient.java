package io.spring.workshop.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
@RibbonClient(name="patient-svc", configuration=PatientSvcConfig.class)
public class PatientSvcClient {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(commandKey = "patient-patientSvc", fallbackMethod = "patientSvcFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4") })
	public PatientDetails[] allPatients() {


		return restTemplate.getForObject("http://patient-svc/patients", PatientDetails[].class);
	}

	public PatientDetails[] patientSvcFallback() {
		return new PatientDetails[0];
	}
}
