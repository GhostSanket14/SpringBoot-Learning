package com.sanketjbdl.springboottwo.usingBeanDifferently;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class restController {
	

	@Autowired
	private newWayOfMakingBean newBean;
	
	@RequestMapping(value="/testingBean", method=RequestMethod.GET)
	public String checkBean() {
		RestTemplate obj=newBean.getTemplate();   // Only 1 object will be created, and same will be used for number of calls
		return "Object created "+obj;
	}
	
}