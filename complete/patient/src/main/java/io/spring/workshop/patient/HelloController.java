package io.spring.workshop.patient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {
	
	@Value("${config.message:config.message not found}")
	private String configMessage;
	
	@RequestMapping("/")
	public String hello(){
		return "Hello Spring Workshop!";
	}
	
	@RequestMapping("/configMessage")
	public String configMessage(){
		return configMessage;
	}
}
