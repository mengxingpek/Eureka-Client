package com.netease.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	@Autowired
	private DiscoveryClient client;
	
	
	@RequestMapping(value = "/hello" , method = RequestMethod.GET)
	public String index() {
		System.out.println("entering index() method");
		ServiceInstance instance = client.getLocalServiceInstance();
		System.out.println("/hello, host:" + instance.getHost() + ", serviceID:" + instance.getServiceId());
		return "HelloWorld";
	}

	
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String home() {
		System.out.println("entering home() method");
		ServiceInstance instance = client.getLocalServiceInstance();
		System.out.println("/, host:" + instance.getHost() + ", serviceID:" + instance.getServiceId());
		return "Home";
	}
	
	
	
}
