package com.sudm.spring.config.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudm.spring.config.client.ClientBeanClass;
import com.sudm.spring.config.client.ClientBeanClass2;

@RefreshScope
@RestController
public class SpringRestController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringRestController.class);

	@Value("${test.prop.value}")
	private String strVal;
	
	@Autowired
	private ClientBeanClass clientBeanClass;
	
	@Autowired
	private ClientBeanClass2 clientBeanClass2;


	@GetMapping("/strVal")
	public ResponseEntity<String> greeting() {
		
		//LOGGER.info("This is info log - CLIENT1");
		//LOGGER.trace("This is trace log - CLIENT1");
		//LOGGER.debug("This is debug log - CLIENT1");
		//LOGGER.error("This is error log - CLIENT1", new Exception("Test Error"));
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("CLIENT-1<br/><br/>");
		sb.append("test.prop.value: ");
		sb.append(strVal);
		sb.append("<br/><br/>bean.prop.value: ");
		sb.append(clientBeanClass.getPropVal());
		sb.append("<br/><br/>");
		sb.append("<br/><br/>bean2.prop.value: ");
		sb.append(clientBeanClass2.getPropVal());
		
		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}

}
