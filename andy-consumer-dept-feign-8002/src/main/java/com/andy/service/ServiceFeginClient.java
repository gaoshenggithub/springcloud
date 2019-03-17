package com.andy.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.andy.service.hystrix.DeptClientServicesFallbackFactory;

@FeignClient(name = "ANDY-PRORIDER",fallbackFactory=DeptClientServicesFallbackFactory.class)
public interface ServiceFeginClient {
	@GetMapping(value = "/provider/dept/discovery")
	public String discover();
}
