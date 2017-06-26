package io.spring.workshop.circuitdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class CircuitDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitDashboardApplication.class, args);
	}
}
