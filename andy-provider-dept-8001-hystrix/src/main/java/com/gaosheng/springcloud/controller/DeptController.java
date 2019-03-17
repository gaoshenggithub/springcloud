package com.gaosheng.springcloud.controller;

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
import com.gaosheng.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@GetMapping(value = "/provider/dept/list")
	public List<Dept> list(){
		List<Dept> depts = deptService.list();
		return depts; 
	}
	
	@GetMapping(value = "/provider/dept/get/{id}")
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id")String id){
		Dept dept = deptService.get(id);
		/*if(dept==null){
			throw new RuntimeException();
		}*/
		return dept;
	}
	
	public Dept processHystrix_Get(@PathVariable("id")String id){
		return new Dept().setDeptno(id)
						 .setDname("没有编号为"+id+"用户"+"@HystrixCommnd")
						 .setDb_source("NO a database in SQL"); 
	}
	
	@PostMapping(value = "/provider/dept/add")
	public Boolean add(Dept dept){
		boolean add = deptService.add(dept);
		return add;
	}
	
	@GetMapping(value ="/provider/dept/discovery") 
	public Object discovery(){
		//获取服务
		String string2  = null;
		List<String> list = discoveryClient.getServices();
		for (String string : list) {
			 string2 = string.toString();
		}
		List<ServiceInstance> instances = discoveryClient.getInstances(string2);
		for (ServiceInstance serviceInstance : instances) {
			System.out.println(serviceInstance.getUri()+"\n"+serviceInstance.getServiceId()+"\n"+serviceInstance.getPort()+"\n"+serviceInstance.getHost());
		}
		return discoveryClient;
	}
}
