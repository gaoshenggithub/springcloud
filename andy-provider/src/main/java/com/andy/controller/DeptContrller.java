package com.andy.controller;

import static org.assertj.core.api.Assertions.shouldHaveThrown;
import static org.mockito.Matchers.intThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andy.model.Dept;
import com.andy.service.DeptService;

@RestController
public class DeptContrller {
	@Autowired
	private DeptService deptService;
	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping(value = "/provider/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.get(id);
		return dept;
	}

	@PostMapping(value = "/provider/dept/add")
	public Boolean add(Dept dept) {
		boolean add = deptService.add(dept);
		return add;
	}
	
	@RequestMapping("/provider/dept/list")
	public List<Dept> list(){
		List<Dept> list = deptService.list();
		System.out.println(list);
		return list;
	}
	
	
	@RequestMapping("/provider/dept/discovery")
	public Object discovery(){
		List<String> services = discoveryClient.getServices();
		System.out.println(services);
		List<ServiceInstance> instances = discoveryClient.getInstances("ANDY-PRORIDER");
		System.out.println(instances);
		return instances;
	}

}
