package com.sanketjbdl.springboottwo.usingBeanDifferently;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Configuration // i made this @component and the bean started making object for every call. So be careful
public class newWayOfMakingBean {
	
	// Finally i got the logger working. just be careful about the dependencies.
	private Logger logger = LoggerFactory.getLogger(newWayOfMakingBean.class);
	
	@Bean // And we dont have to manage this process.
	public RestTemplate getTemplate() {
		RestTemplate restTemplate=new RestTemplate(); // only one object will be created. and used for all calls.
		logger.info("Inside getTemplate: obj = {}", restTemplate);
		return restTemplate; // now whoever calls this function will get object of this template.
	}
}