package io.spring.workshop.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class PatientSvcClient {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@HystrixCommand(commandKey = "patient-patientSvc", fallbackMethod = "patientSvcFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4") })
	public PatientDetails[] allPatients() {

		List<ServiceInstance> list = discoveryClient.getInstances("patient-svc");
		if (list == null || list.size() == 0) {
			throw new RuntimeException("No service instances found!");
		}

		return restTemplate.getForObject(list.get(0).getUri().toString() + "/patients", PatientDetails[].class);
	}

	public PatientDetails[] patientSvcFallback() {
		return new PatientDetails[0];
	}
}
