package com.sudm.spring.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class ClientAppBeanConfig {
	
	@Value("${bean.prop.value}")
	private String beanVal;
	
	@Value("${bean.prop.value2}")
	private String beanVal2;
	
	@Bean(name = "clientBeanClass")
	public ClientBeanClass getClientBeanClass() {
		ClientBeanClass bean = new ClientBeanClass();
		bean.setPropVal(beanVal);
		return bean;
	}
	
	@Bean(name = "clientBeanClass2")
	public ClientBeanClass2 getClientBeanClass2() {
		ClientBeanClass2 bean = new ClientBeanClass2();
		bean.setPropVal(beanVal2);
		return bean;
	}
}
