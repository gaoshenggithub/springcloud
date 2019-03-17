package com.andy.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.andy.model.Dept;
import com.andy.service.hystrix.DeptClientServicesFallbackFactory;

@FeignClient(name = "ANDY-PRORIDER",fallbackFactory=DeptClientServicesFallbackFactory.class)
public interface ServiceFeginClient {
	
	@LoadBalanced
	@GetMapping(value = "/provider/dept/discovery")
	public String discover();
	
	@LoadBalanced
	@GetMapping(value = "/provider/dept/get/{id}")
	public Dept get(@PathVariable("id")String id);
}
