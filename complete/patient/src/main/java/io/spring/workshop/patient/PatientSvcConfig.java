package io.spring.workshop.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class PatientSvcConfig {
	@Autowired
	private IClientConfig ribbonClientConfig;
	
	@Bean
	public IPing ribbonPing(IClientConfig config) {
		//leverage actuator endpoint (could be just about anything we can hit
		return new PingUrl(false,"/health");
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}

}
