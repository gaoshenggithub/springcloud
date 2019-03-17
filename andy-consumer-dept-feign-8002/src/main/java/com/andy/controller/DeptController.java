package com.andy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.andy.model.Dept;
import com.andy.service.ServiceFeginClient;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

	//private static final String REQUEST_URL_TEMP = "http://ANDY-PRORIDER";
	//@Autowired
	//private RestTemplate restTemplate;
	@Autowired
	ServiceFeginClient serviceFeginClient;

	/*@GetMapping(value = "/consumner/dept/get/{id}")
	public Dept get(@PathVariable("id") Integer id) {
		return (Dept) restTemplate.getForObject(REQUEST_URL_TEMP + "/provider/dept/get/" + id, Dept.class);
	}*/

	/*@PostMapping(value = "/consumner/dept/add")
	public boolean add(Dept dept) {
		System.out.println(dept);
		return restTemplate.postForObject(REQUEST_URL_TEMP + "/provider/dept/add", dept, Boolean.class);
	}*/

	/*@SuppressWarnings("unchecked")
	@GetMapping(value = "/consumner/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REQUEST_URL_TEMP + "/provider/dept/list", List.class);
	}*/
	
	@GetMapping(value = "/provider/dept/get/{id}")
	public Dept get(@PathVariable("id")String id){
		return serviceFeginClient.get(id);
	}
	
	@GetMapping(value = "/consumner/dept/list2")
	public String list2(){
		return serviceFeginClient.discover();
		//return restTemplate.getForObject(REQUEST_URL_TEMP+"/provider/dept/discovery", Object.class);
	}
}